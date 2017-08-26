package kata.wordsearch

import javax.swing.text.DefaultEditorKit.DeleteNextCharAction

import spock.lang.Specification

class LetterIteratorSpec extends Specification {

	final static int X_INIT = 42
	final static int Y_INIT = 86
	
	def INIT_COORDINATE = [x: X_INIT, y: Y_INIT]
	def SECOND_COORDINATE = [x: X_INIT + 1, y: Y_INIT + 1]
	def THIRD_COORDINATE = [x: X_INIT + 2, y: Y_INIT + 2]
	
	LetterGrid grid = Mock()
	CoordinateSequence sequence = Mock()
	
	LetterIterator underTest = new LetterIterator(sequence: sequence, grid: grid)
	
	def setup() {
		sequence.next() >>> [INIT_COORDINATE, SECOND_COORDINATE, THIRD_COORDINATE]
	}
	
	def "should be an iterator"() {
		expect:
		new LetterIterator() instanceof Iterator
	}
	
	def "should offer next"() {
		when:
		grid.letterAt(INIT_COORDINATE) >> 'A'
		
		then:
		underTest.next() == 'A'
	}
	
	def "should have next"() {
		when:
		grid.letterAt(INIT_COORDINATE) >> 'Z'
		
		then:
		underTest.hasNext()
	}
	
	def "should not have next"() {
		expect: "mock grid without stubbing to have no letters"
		!underTest.hasNext()
	}
	
	def "should not have second letter"() {
		given:
		grid.letterAt(INIT_COORDINATE) >> 'Z'
		
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
	
	def "should return two letters"() {
		when:
		grid.letterAt(INIT_COORDINATE) >> 'A'
		grid.letterAt(SECOND_COORDINATE) >> 'B'

		then:
		underTest.collect() == ['A', 'B']
	}
}
