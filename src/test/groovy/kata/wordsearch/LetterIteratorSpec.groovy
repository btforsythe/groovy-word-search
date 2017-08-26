package kata.wordsearch

import spock.lang.Specification

class LetterIteratorSpec extends Specification {
	
	def letterGrid = Mock(LetterGrid)
	
	def "should be an iterator"() {
		when:
		LetterIterator underTest = new LetterIterator()
		
		then:
		underTest instanceof Iterator
	}
}
