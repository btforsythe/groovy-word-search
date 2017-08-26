package kata.wordsearch

class CoordinateSequence {

	int xInit
	int yInit
	
	int xIncrement = 0
	
	int xCurrent = 0
	
	def next() {
		def next = [x: xCurrent, y: 0]
		xCurrent += xIncrement
		return next
	}
}
