package kata.wordsearch

import static kata.wordsearch.Match.NO_MATCH

class HorizontalMatchFinder {

	def grid

	def findMatch(toMatch) {
		def x = (0..grid.size() - 1).findIndexOf { grid.letterAt(it, 0) == toMatch }

		x == -1 ? NO_MATCH : new Match(coordinate: [x: x, y: 0])
	}
}
