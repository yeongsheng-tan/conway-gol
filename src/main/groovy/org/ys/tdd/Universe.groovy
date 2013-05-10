package org.ys.tdd

import java.util.concurrent.CopyOnWriteArrayList

/**
 * Created with IntelliJ IDEA.
 * User: nbdqxmt
 * Date: 5/8/13
 * Time: 5:10 PM
 * To change this template use File | Settings | File Templates.
 */
class Universe {
	List cells = new CopyOnWriteArrayList()

	public void tick(){
		cells.each { cell ->
			if (cell.immediateNeighbours().size() < 2)
				cell.die()
		}
	}
}
