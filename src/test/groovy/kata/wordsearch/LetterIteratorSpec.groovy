package kata.wordsearch

import spock.lang.Specification

class LetterIteratorSpec extends Specification {

	LetterGrid grid = Mock()
	
	def "should be an iterator"() {
		when:
		LetterIterator underTest = new LetterIterator()
		
		then:
		underTest instanceof Iterator
	}
	
	def "should offer next"() {
		when:
		LetterIterator underTest = new LetterIterator()
		
		then:
		underTest.next() == 'A'
	}
	
	def "should have next"() {
		when:
		LetterIterator underTest = new LetterIterator(xInit: 0, yInit: 0, grid: grid)
		grid.letterAt(0, 0) >> 'Z'
		
		then:
		underTest.hasNext()
	}
	
	def "should not have next"() {
		when:
		LetterIterator underTest = new LetterIterator(xInit: 0, yInit: 0, grid: grid)
		
		then:
		!underTest.hasNext()
	}
}
