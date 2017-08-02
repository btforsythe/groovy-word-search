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
		result.coordinate == [x: 0, y: 0]
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
		result.coordinate == [x: 1, y: 0]
	}

	def "should not find a match"() {
		given:
		HorizontalMatchFinder underTest = new HorizontalMatchFinder(grid: new LetterGrid(letters: [['A']]))

		when:
		def result = underTest.findMatch('B')

		then:
		result.foundMatch == false
	}

	def "should find a match"() {
		given:
		HorizontalMatchFinder underTest = new HorizontalMatchFinder(grid: new LetterGrid(letters: [['A']]))

		when:
		def result = underTest.findMatch('A')

		then:
		result.foundMatch == true
	}

	def "should match two character sequence"() {
		given:
		LetterGrid grid = new LetterGrid(4)
		grid.putLetterAt(0, 0, 'A')
		grid.putLetterAt(1, 0, 'C')
		grid.putLetterAt(2, 0, 'A')
		grid.putLetterAt(3, 0, 'B')

		HorizontalMatchFinder underTest = new HorizontalMatchFinder(grid: grid)

		when:
		def result = underTest.findMatch('AB')

		then:
		result.coordinate == [x: 2, y: 0]
	}
}
