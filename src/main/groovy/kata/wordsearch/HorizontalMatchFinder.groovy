package kata.wordsearch

class HorizontalMatchFinder {

	def grid

	def findMatch(toMatch) {
		def x = (0..grid.size() - 1).findIndexOf { grid.letterAt(it, 0) == toMatch }
		[x: x, y: 0]
	}
}
