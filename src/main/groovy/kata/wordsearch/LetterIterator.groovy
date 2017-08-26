package kata.wordsearch;

class LetterIterator implements Iterator<Character> {

	LetterGrid grid;
	
	@Override
	boolean hasNext() {
		return true;
	}

	@Override
	Character next() {
		return 'A';
	}
}
