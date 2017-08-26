package kata.wordsearch

import javax.swing.text.DefaultEditorKit.DeleteNextCharAction

import spock.lang.Specification

class LetterIteratorSpec extends Specification {

	LetterGrid grid = Mock()
	CoordinateSequence sequence = Mock()
	
	LetterIterator underTest = new LetterIterator(sequence: sequence, grid: grid)
	
	def "should be an iterator"() {
		expect:
		new LetterIterator() instanceof Iterator
	}
	
	def "should offer next"() {
		given:
		
		when:
		grid.letterAt(0, 0) >> 'A'
		
		then:
		underTest.next() == 'A'
	}
	
	def "should have next"() {
		when:
		grid.letterAt(0, 0) >> 'Z'
		
		then:
		underTest.hasNext()
	}
	
	def "should not have next"() {
		expect: "mock grid without stubbing to have no letters"
		!underTest.hasNext()
	}
	
	def "should not have second letter"() {
		given:
		underTest.xIncrement = 1
		grid.letterAt(0, 0) >> 'Z'
		
		when:
		underTest.next()
		
		then:
		!underTest.hasNext()
	}
	
	def "should fail with no such element"() {
		when: "attempting to get next from mock grid without stubbing"
		underTest.next()
		
		then:
		thrown(NoSuchElementException)
	}
	
	def "should return two letters horizontally"() {
		given:
		underTest.xIncrement = 1
		
		when:
		grid.letterAt(0, 0) >> 'A'
		grid.letterAt(1, 0) >> 'B'
		
		then:
		underTest.collect() == ['A', 'B']
	}
	
	def "should iterate vertically"() {\
		given:
		underTest.yIncrement = 1
		
		when:
		grid.letterAt(0, 0) >> 'A'
		grid.letterAt(0, 1) >> 'B'
		
		then:
		underTest.collect() == ['A', 'B']
	}
}
