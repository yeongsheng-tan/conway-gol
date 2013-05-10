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
	Universe universe

	public Cell(Universe univ, int x_coordinate, int y_coordinate){
		x = x_coordinate
		y = y_coordinate
		this.universe = univ
		this.universe.cells.add(this)
	}

	public Cell generate(int x_coordinate, int y_coordinate){
		return new Cell(universe,x_coordinate,y_coordinate)
	}

	public void die(){
		universe.cells.remove(this)
	}

	public List immediateNeighbours(){
		List neighbours = new ArrayList()
		universe.cells.each { cell ->
			// Has a cell to the north of this cell
			if (this.x == cell.x && this.y == cell.y - 1){
				neighbours.add(cell)
			}

			// Has a cell to the north-east of this cell
			if (this.x == cell.x - 1 && this.y == cell.y - 1){
				neighbours.add(cell)
			}

			// Has a cell to the east of this cell
			if (this.x == cell.x - 1 && this.y == cell.y){
				neighbours.add(cell)
			}

			// Has a cell to the south-east of this cell
			if(this.x == cell.x - 1 && this.y == cell.y + 1){
				 neighbours.add(cell)
			}

			// Has a cell to the south of this cell
			if(this.x == cell.x && this.y == cell.y + 1){
				neighbours.add(cell)
			}

			// Has a cell to the south-west of this cell
			if(this.x == cell.x + 1 && this.y == cell.y + 1){
				neighbours.add(cell)
			}

			// Has a cell to the west of this cell
			if(this.x == cell.x + 1 && this.y == cell.y){
				neighbours.add(cell)
			}
		}
		return neighbours
	}
}
