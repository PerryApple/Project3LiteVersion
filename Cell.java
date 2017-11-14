
public class Cell {
	private boolean flag;//flag to indicate that has this cell been visited.
	public int x, y;
	
	//every Node may have four children. This four parameters are used to store the children of Cell C.
	public Cell upCell;
	public Cell rightCell;
	public Cell downCell;
	public Cell leftCell;
	
	Cell (int i, int j){
		//initial flag to unvisited and has no child at first.
		this.flag = false;
		this.x = i;
		this.y = j;
		this.upCell=null;
		this.rightCell=null;
		this.downCell=null;
		this.leftCell=null;
	}
	public boolean getFlag() {
		return flag;
	}
	public void visit() {
		this.flag = true;
	}
	public void cleanFlag() {
		this.flag = false;
	}
	
}
