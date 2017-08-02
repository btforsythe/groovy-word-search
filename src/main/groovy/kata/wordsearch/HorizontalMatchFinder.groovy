package kata.wordsearch

import static kata.wordsearch.Match.NO_MATCH

class HorizontalMatchFinder {

	def grid

	def findMatch(toMatch) {
		def sequence = (0..grid.size() - 1).collect { grid.letterAt(it, 0) }.join('')

		def matchLocation = sequence.indexOf(toMatch)
		matchLocation == -1 ? NO_MATCH : new Match(coordinate: [x: matchLocation, y: 0])
	}
}
