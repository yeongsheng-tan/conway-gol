package org.ys.tdd

/**
 * Created with IntelliJ IDEA.
 * User: nbdqxmt
 * Date: 5/8/13
 * Time: 2:13 PM
 * To change this template use File | Settings | File Templates.
 */
class Cell {
	int x, y
	List neighbours = new ArrayList()
	Universe universe

	public Cell(Universe u, int x, int y){
		this.x = x
		this.y = y
		this.universe = u
		this.universe.cells.add(this)
	}

	public void evolve(){
		if(immediateNeighboursSize() < 2){
			die()
		}
	}

	public void die(){
		universe.cells.remove(this)
	}

	public int immediateNeighboursSize(){
		return 1
	}
}
