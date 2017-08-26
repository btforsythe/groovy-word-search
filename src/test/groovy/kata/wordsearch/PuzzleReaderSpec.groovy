package kata.wordsearch

import spock.lang.Specification

class PuzzleReaderSpec extends Specification {

	def "should read 1x1 grid"() {
		given:
		PuzzleReader underTest =  new PuzzleReader(filepath: "reader1x1.txt")

		when:
		def wordSearch = underTest.read()

		then:
		wordSearch.words == ['1x1']
		wordSearch.grid.size() == 1
		wordSearch.grid.letterAt([x: 0, y: 0]) == 'X'
	}

	def "should read 2x2 grid"() {
		given:
		PuzzleReader underTest = new PuzzleReader(filepath: "reader2x2.txt")

		when:
		def wordSearch = underTest.read()

		then:
		wordSearch.words == ['foo', 'bar']
		wordSearch.grid.size() == 2

		expect:
		wordSearch.grid.letterAt([x: x, y: y]) == expected

		where:
		x 	| y		|| expected
		0	| 0		|| 'W'
		0	| 1		|| 'Y'
		1	| 0		|| 'X'
		1	| 1		|| 'Z'

	}
}  