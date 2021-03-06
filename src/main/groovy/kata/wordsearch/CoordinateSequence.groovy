package kata.wordsearch

class CoordinateSequence {

	int xInit
	int yInit

	int xIncrement = 0
	int yIncrement = 0

	def current

	def next() {
		if(current) {
			current.x += xIncrement
			current.y += yIncrement
		} else {
			current = [x: xInit, y: yInit]
		}
		return [x: current.x, y: current.y]
	}

	def reset() {
		current = null
	}
}
