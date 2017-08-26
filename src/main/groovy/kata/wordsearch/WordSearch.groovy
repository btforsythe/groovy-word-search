package kata.wordsearch

class WordSearch {

	String word
	LetterGrid grid

	def search() {
		def increments = [[x: 1, y: 0], [x: 0, y: 1]]
		for (increment in increments) {
			def sequence = new CoordinateSequence(xInit: 0, yInit: 0, xIncrement: increment.x, yIncrement: increment.y)
			def iterator = new LetterIterator(sequence: sequence, grid: grid)

			if(matchFound(iterator)) {
				return buildCoordinatesFrom(sequence)
			}
		}
	}

	def matchFound(letterItr) {
		letterItr.collect().join("").startsWith(word)
	}

	private buildCoordinatesFrom(CoordinateSequence sequence) {
		sequence.reset()

		def coordinates = []
		word.size().times {
			coordinates << sequence.next()
		}

		return coordinates
	}
}
