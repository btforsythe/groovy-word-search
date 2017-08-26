package kata.wordsearch

import spock.lang.Specification

class LetterIteratorSpec extends Specification {

	LetterGrid grid = Mock()
	LetterIterator underTest = new LetterIterator(xInit: 0, yInit: 0, grid: grid)
	
	def "should be an iterator"() {
		expect:
		underTest instanceof Iterator
	}
	
	def "should offer next"() {
		expect:
		underTest.next() == 'A'
	}
	
	def "should have next"() {
		when:
		grid.letterAt(0, 0) >> 'Z'
		
		then:
		underTest.hasNext()
	}
	
	def "should not have next"() {
		expect:
		!underTest.hasNext()
	}
}
