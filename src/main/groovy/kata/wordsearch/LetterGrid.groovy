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
	def letterAt(coordinate) { letters[coordinate.y][coordinate.x] }
	def putLetterAt = { coordinate, letter -> letters[coordinate.y][coordinate.x] = letter}
}
