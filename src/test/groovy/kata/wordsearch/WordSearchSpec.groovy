package kata.wordsearch

import spock.lang.Specification

class WordSearchSpec extends Specification {

	static final String WORD = "AB"

	LetterGrid grid = Mock()

	WordSearch underTest = new WordSearch(word: WORD, grid: grid)

	def "should find horizontal"() {
		given:
		buildMockGrid([WORD, "XY"])

		when:
		def coordinates = underTest.search()

		then:
		coordinates == [[x: 0, y: 0], [x: 1, y: 0]]
	}

	def buildMockGrid(rows) {
		grid = new LetterGrid(rows)
//		grid.size() >> rows.size()
//		rows.eachWithIndex { row, y ->
//			row.eachWithIndex { element, x ->
//				grid.letterAt([x: x, y: y]) >> element
//			}
//		}
	}

	def "should find vertical"() {
		given:
		buildMockGrid(["A", "B"])

		when:
		def coordinates = underTest.search()

		then:
		coordinates == [[x: 0, y: 0], [x: 0, y: 1]]
	}

	def "should find horizontal at second column"() {
		given:
		buildMockGrid(["ZAB", "XYZ", "PDQ"])

		when:
		def coordinates = underTest.search()

		then:
		coordinates == [[x: 1, y: 0], [x: 2, y: 0]]
	}
}
