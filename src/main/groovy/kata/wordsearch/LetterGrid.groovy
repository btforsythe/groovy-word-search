package kata.wordsearch

class LetterGrid {

	String[][] letters;

	LetterGrid() {}

	LetterGrid(size) {
		letters = new String[size][size]
	}

	def size() { letters.size() }
	def letterAt(x, y) { letters[y][x] }
	def putLetterAt = { x, y, letter -> letters[y][x] = letter}
}
