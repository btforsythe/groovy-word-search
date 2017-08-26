package kata.wordsearch

import spock.lang.Specification

class CoordinateSequenceSpec extends Specification {

	final static int XINIT = 42
	final static int YINIT = 86
	
	CoordinateSequence underTest = new CoordinateSequence(xInit: XINIT, yInit: YINIT)
	
	def "should return initial coordinate"() {
		expect:
		underTest.next() == [x: XINIT, y: YINIT]
	}
	
	def "should return increasing x coordinate"() {
		when:
		underTest.xIncrement = 1
		
		then:
		underTest.next() == [x: XINIT, y: YINIT]
		underTest.next() == [x: XINIT + 1, y: YINIT]
	}

	def "should return increasing y coordinate"() {
		when:
		underTest.yIncrement = 1
		
		then:
		underTest.next() == [x: XINIT, y: YINIT]
		underTest.next() == [x: XINIT, y: YINIT + 1]
	}
	
	def "should reset"() {
		given:
		underTest.xIncrement = 1
		underTest.yIncrement = 1
		
		when:
		3.times { underTest.next() }
		underTest.reset()
		
		then:
		underTest.next()== [x: XINIT, y: YINIT]
	}
}
