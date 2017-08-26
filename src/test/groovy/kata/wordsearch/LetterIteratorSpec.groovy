package kata.wordsearch

import spock.lang.Specification

class LetterIteratorSpec extends Specification {
	
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
}
