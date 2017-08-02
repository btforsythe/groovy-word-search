package kata.wordsearch

import spock.lang.Specification

class HorizontalMatchFinderSpec extends Specification {

	def "should find single letter from a 1x1 grid"() {
		given:
		LetterGrid grid = new LetterGrid(letters: [['A']])
		HorizontalMatchFinder underTest = new HorizontalMatchFinder(grid: grid)

		when:
		def result = underTest.findMatch('A')

		then:
		result == [x: 0, y: 0]
	}

	def "should find a single letter from a single row"() {
		given:
		LetterGrid grid = new LetterGrid(3)
		grid.putLetterAt(0, 0, 'X')
		grid.putLetterAt(1, 0, 'Y')
		grid.putLetterAt(2, 0, 'Z')

		HorizontalMatchFinder underTest = new HorizontalMatchFinder(grid: grid)

		when:
		def result = underTest.findMatch('Y')

		then:
		result == [x: 1, y: 0]
	}
}
