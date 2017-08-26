package kata.wordsearch

class LetterGrid {

	String[][] letters;

	LetterGrid(String[][] letters) {
		this.letters = letters
	}

	LetterGrid(int size) {
		letters = new String[size][size]
	}

	def size() { letters.size() }
	def letterAt(x, y) { letters[y][x] }
	def putLetterAt = { x, y, letter -> letters[y][x] = letter}
}
