package kata.wordsearch

class GridReader {
	String filepath

	File file

	String[][] letters

	def read() {
		file = new File(getClass().getResource(filepath).toURI())
		def row = 0
		file.splitEachLine(',', { rowLetters ->
			initLetters(rowLetters.size())
			letters[row++] = rowLetters
		})
		new LetterGrid(letters: letters)
	}

	def initLetters(int length) {
		if (letters != null) {
			return
		}
		letters = new String[length][length]
	}
}

