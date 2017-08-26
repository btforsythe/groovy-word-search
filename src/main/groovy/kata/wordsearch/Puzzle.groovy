package kata.wordsearch

class Puzzle {

	Iterable words
	LetterGrid grid

	Puzzle(words, letters) {
		this.words = words
		this.grid = new LetterGrid(letters)
	}
}
