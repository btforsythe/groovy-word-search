package kata.wordsearch

import spock.lang.Specification

class GridReaderSpec extends Specification {

	def "should read 1x1 grid"() {
		given:
		GridReader underTest =  new GridReader(filepath: "1x1.txt")

		when:
		def resultGrid = underTest.read()

		then:
		resultGrid.size() == 1
		resultGrid.letterAt(0, 0) == 'X'
	}

	def "should read 2x2 grid"() {
		given:
		GridReader underTest = new GridReader(filepath: "2x2.txt")

		when:
		def resultGrid = underTest.read()

		then:
		resultGrid.size() == 2

		expect:
		resultGrid.letterAt(x, y) == expected

		where:
		x 	| y		|| expected
		0	| 0		|| 'W'
		0	| 1		|| 'Y'
		1	| 0		|| 'X'
		1	| 1		|| 'Z'

	}
}  