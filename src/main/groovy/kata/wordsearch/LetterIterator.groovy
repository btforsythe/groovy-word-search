package kata.wordsearch;

class LetterIterator implements Iterator<String> {

	CoordinateSequence sequence
	
	LetterGrid grid

	def nextCoordinate

	@Override
	boolean hasNext() {
		nextCoordinate = nextCoordinate ?: sequence.next()
		return nextLetter()
	}

	private def nextLetter() {
		grid.letterAt(nextCoordinate)
	}
	
	@Override
	String next() {
		if(!hasNext()) {
			throw new NoSuchElementException()
		}
		
		def next = nextLetter()
		
		nextCoordinate = sequence.next()
		
		return next
	}
}
