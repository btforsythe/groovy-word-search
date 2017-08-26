package kata.wordsearch

import spock.lang.Specification

class WordSearchSpec extends Specification {

	LetterGrid grid = Mock()
	
	WordSearch underTest = new WordSearch(word: "AB", grid: grid)
	
	def "should find horizontal"() {
		given:
		grid.letterAt([x: 0, y: 0]) >> 'A'
		grid.letterAt([x: 1, y: 0]) >> 'B'
		
		when:
		def coordinates = underTest.search()
		
		then:
		coordinates == [[x: 0, y: 0], [x: 1, y: 0]]
	}
	
	def "should find vertical"() {
		given:
		grid.letterAt([x: 0, y: 0]) >> 'A'
		grid.letterAt([x: 0, y: 1]) >> 'B'
		
		when:
		def coordinates = underTest.search()
		
		then:
		coordinates == [[x: 0, y: 0], [x: 0, y: 1]]
	}
}
