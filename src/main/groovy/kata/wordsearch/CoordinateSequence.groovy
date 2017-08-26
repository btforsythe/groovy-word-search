package kata.wordsearch

class CoordinateSequence {

	int xInit
	int yInit
	
	int xIncrement = 0
	int yIncrement = 0
	
	def xCurrent
	def yCurrent
	
	def next() {
		xCurrent = xCurrent ?: xInit
		yCurrent = yCurrent ?: yInit
		
		def next = [x: xCurrent, y: yCurrent]
		xCurrent += xIncrement
		yCurrent += yIncrement
		
		return next
	}
	
	def reset() {
		xCurrent = xInit
		yCurrent = yInit
	}
	
	def current() {
		[x: xCurrent, y: yCurrent]
	}
}
