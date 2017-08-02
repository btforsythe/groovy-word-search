package kata.wordsearch

class WordSearch {

	def words;
	def grid

	WordSearch(words, letters) {
		this.words = words
		this.grid = new LetterGrid(letters: letters)
	}
}
