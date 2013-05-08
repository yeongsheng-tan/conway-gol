package org.ys.tdd

import spock.lang.Specification

/**
 * Created with IntelliJ IDEA.
 * User: nbdqxmt
 * Date: 5/8/13
 * Time: 2:05 PM
 * To change this template use File | Settings | File Templates.
 */
class CellSpec extends Specification {
	def setup(){

	}

	def "Any live cell with fewer than two live neighbours dies, as if caused by under-population."(){
		Universe universe = new Universe()
		Cell cell = new Cell(universe,2,2)

        when:
		cell.evolve()

		then:
		universe.cells.size() == 0
		universe.cells.contains(cell) == false
	}
}
