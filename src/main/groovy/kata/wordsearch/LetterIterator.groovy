package kata.wordsearch;

class LetterIterator implements Iterator<Character> {

	def xInit;
	def yInit;
	LetterGrid grid;
	
	@Override
	boolean hasNext() {
		return grid.letterAt(xInit, yInit);
	}

	@Override
	Character next() {
		return 'A';
	}
}
