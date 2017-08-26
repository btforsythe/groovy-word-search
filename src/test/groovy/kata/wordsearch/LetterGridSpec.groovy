package kata.wordsearch

import spock.lang.Specification

class LetterGridSpec extends Specification {
	def "should create grid of specified size"() {
		given:
		LetterGrid underTest = new LetterGrid(4); // 4 x 4 grid
		
		expect:
		underTest.size() == 4
	}
	
	def "should put letter at coordinates"() {
		given:
		LetterGrid underTest = new LetterGrid(4);

		when:
		underTest.putLetterAt(2, 2, 'Z')

		then:
		underTest.letterAt(2, 2) == 'Z'
	}
}
