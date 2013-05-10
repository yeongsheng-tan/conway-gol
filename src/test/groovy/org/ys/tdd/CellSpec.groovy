package org.ys.tdd
import spock.lang.Specification
/**
 * Created with IntelliJ IDEA.
 * User: yeongsheng.tan
 * Date: 5/8/13
 * Time: 2:05 PM
 * To change this template use File | Settings | File Templates.
 */
class CellSpec extends Specification {
	Universe universe
	Cell cell

	def setup(){
		universe = new Universe()
		cell = new Cell(universe,3,2)
	}

	def cleanup(){
		universe = null
		cell = null
	}

	def "Law 1: Any live cell with fewer than two live neighbours dies, as if caused by under-population."(){
        expect:
        cell.immediateNeighbours().size() == 0

		when:
		universe.tick()

		then:
		universe.cells.size() == 0
		universe.cells.contains(cell) == false
	}

	def "New cell is generated"(){
		when:
		Cell newCell = cell.generate(1,2)

		then:
		newCell instanceof Cell
		newCell.x == 1
		newCell.y == 2
	}

	def "Cell dies"(){
		when:
		Cell cellToDie = cell.generate(3,4)
		cellToDie.die()

		then:
		cell.universe.cells.contains(cellToDie) == false
	}

	def "Locate a cell neighbour to the north"(){
		when:
		cell.generate(3,1)

		then:
		cell.immediateNeighbours().size() == 1
	}

/*	def "Law 3: Any live cell with more than three live neighbors dies, as if by overcrowding."(){
		Cell cell1 = new Cell(universe,2,2)
		Cell cell2 = new Cell(universe,1,2)
		Cell cell3 = new Cell(universe,3,2)
		Cell cell4 = new Cell(universe,1,1)
		Cell cell5 = new Cell(universe,2,1)

		when:
		universe.tick()

		then:
		universe.cells.size() == 4
		universe.cells.contains(cell1) == false
	}*/
}
