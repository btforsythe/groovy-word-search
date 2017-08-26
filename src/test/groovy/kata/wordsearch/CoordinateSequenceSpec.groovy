package kata.wordsearch

import spock.lang.Specification

class CoordinateSequenceSpec extends Specification {

	def "should return initial coordinate"() {
		when:
		CoordinateSequence underTest = new CoordinateSequence(xInit: 0, yInit: 0)
		then:
		underTest.next() == [x: 0, y: 0]
	}
	
	def "should return increasing x coordinate"() {
		when:
		CoordinateSequence underTest = new CoordinateSequence(xInit: 0, yInit: 0, xIncrement: 1)
		
		then:
		underTest.next() == [x: 0, y: 0]
		underTest.next() == [x: 1, y: 0]
	}
}
