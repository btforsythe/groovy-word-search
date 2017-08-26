package kata.wordsearch

import spock.lang.Specification

class LetterGridSpec extends Specification {
	
	LetterGrid underTest = new LetterGrid(4) // 4 x 4 grid
	
	def "should create grid of specified size"() {
		expect:
		underTest.size() == 4
	}
	
	def "should put letter at coordinates"() {
		given:
		underTest.putLetterAt(2, 2, 'Z')

		expect:
		underTest.letterAt(2, 2) == 'Z'
	}
}
