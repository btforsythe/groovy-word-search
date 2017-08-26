package kata.wordsearch

class WordSearchReader {
	
	String filepath

	def read() {
		def reader = createReader()
		def words = reader.readLine().split(",")

		String[][] letters = readLetters(reader)
		new WordSearch(words, letters)
	}

	def createReader() {
		new File(getClass().getResource(filepath).toURI()).newReader()
	}

	def readLetters(reader) {
		def row = 0
		String[][] letters
		reader.lines().each { line ->
			def rowLetters = line.split(",")

			if (row == 0) {
				int numberOfLetters = rowLetters.size()
				letters = new String[numberOfLetters][numberOfLetters]
			}

			letters[row++] = rowLetters
		}
		return letters
	}
}

