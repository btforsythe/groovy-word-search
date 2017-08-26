package kata.wordsearch;

class LetterIterator implements Iterator<Character> {

	CoordinateSequence sequence
	
	def xInit
	def yInit
	
	def xIncrement
	def yIncrement
	
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
		
		def next = grid.letterAt(xCurrent, yCurrent)
		xCurrent += xIncrement?: 0
		yCurrent += yIncrement?: 0
		
		return next
	}
}
