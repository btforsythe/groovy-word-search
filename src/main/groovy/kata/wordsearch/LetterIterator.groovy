package kata.wordsearch;

class LetterIterator implements Iterator<Character> {

	def xInit
	def yInit
	
	def xIncrement = 0
	def yIncrement = 0
	
	def xCurrent
	def yCurrent
	
	LetterGrid grid

	@Override
	boolean hasNext() {
		xCurrent = xCurrent ?: xInit
		yCurrent = yCurrent ?: yInit
		return grid.letterAt(xCurrent, yCurrent)
	}

	@Override
	Character next() {
		if(!hasNext()) {
			throw new NoSuchElementException()
		}
		
		def next = grid.letterAt(xCurrent, yInit)
		xCurrent += xIncrement
		yCurrent += yIncrement
		
		return next
	}
}
