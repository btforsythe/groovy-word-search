package kata.wordsearch

import spock.lang.Specification

class CoordinateSequenceSpec extends Specification {

	final static int X_INIT = 42
	final static int Y_INIT = 86
	
	CoordinateSequence underTest = new CoordinateSequence(xInit: X_INIT, yInit: Y_INIT)
	
	def "should return initial coordinate"() {
		expect:
		underTest.next() == [x: X_INIT, y: Y_INIT]
	}
	
	def "should return increasing x coordinate"() {
		when:
		underTest.xIncrement = 1
		
		then:
		underTest.next() == [x: X_INIT, y: Y_INIT]
		underTest.next() == [x: X_INIT + 1, y: Y_INIT]
	}

	def "should return increasing y coordinate"() {
		when:
		underTest.yIncrement = 1
		
		then:
		underTest.next() == [x: X_INIT, y: Y_INIT]
		underTest.next() == [x: X_INIT, y: Y_INIT + 1]
	}
	
	def "should reset"() {
		given:
		underTest.xIncrement = 1
		underTest.yIncrement = 1
		
		when:
		3.times { underTest.next() }
		underTest.reset()
		
		then:
		underTest.next()== [x: X_INIT, y: Y_INIT]
	}
	
	def "should initially return null for current"() {
		expect:
		underTest.current == null
	}
	
	def "should return initial coordinate for current after next"() {
		given:
		underTest.next()
		
		expect:
		underTest.current == [x: X_INIT, y: Y_INIT]
	}
}
