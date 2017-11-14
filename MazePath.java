import java.util.Random;
import java.util.Stack;

public class MazePath {
	
	public void findPathDFS(Maze maze) {
		long start = System.nanoTime();
		Cell currentNode = maze.maze[0][0];//set maze[0][0] to be the entrance
		Stack<Cell> mazeCells = new Stack<Cell>();
		mazeCells.push(currentNode); //push the entrance node into stack
		currentNode.visit(); //set the flag of entrance node to visited.
		Cell nextNode = null;
		
		//find the Path use DFS
		while(!mazeCells.isEmpty()) {
			currentNode = mazeCells.pop();
			nextNode = this.randomChildSelectrion(currentNode);// randomly select a child of the currentNode
			
			if(nextNode!=null) {
				//If currentNode has no unvisited child, current node will be popped out of the Stack. 
				//And we will back to the previous nodes.
				if(nextNode.x == maze.sizeColumn - 1 && nextNode.y == maze.sizeRow - 1) {
					//Let the lower right corner to be the exit of the maze
					//If we arrive at the exit then we terminate this algorithm.
					System.out.println("Found the path");
					break;
				}else {
					//If next node is not the exit, push currenNode and its randomly selected child into stack.
					System.out.println(nextNode.x + " . " + nextNode.y);
					mazeCells.push(currentNode);
					mazeCells.push(nextNode);
					nextNode.visit();
				}
			}
		}
		
		long end = System.nanoTime();
		System.out.println(end-start);
	}
	
	private Cell randomChildSelectrion(Cell c) {
		Cell randomChild = null;		
		//Generate a random number for randomly child selection
		Random random = new Random();
		int randomSelectFactor = Math.abs(random.nextInt());
		//select a random child of current cell
		for(int i = 0 ; i < 4 ; i++) {
			//randomly select a child, if the child is not exist or has been visited, then selected next one.
			//If the node has no unvisited child. return null.
			switch(randomSelectFactor % 4) {
			case 0 : randomChild = (c.upCell == null) ? null : (c.upCell.getFlag() == true) ? null : c.upCell;
			break;
			case 1 : randomChild = (c.rightCell == null) ? null : (c.rightCell.getFlag() == true) ? null : c.rightCell;
			break;
			case 2 : randomChild = (c.downCell == null) ? null : (c.downCell.getFlag() == true) ? null : c.downCell;
			break;
			case 3 : randomChild = (c.leftCell == null) ? null : (c.leftCell.getFlag() == true) ? null : c.leftCell;
			break;
			}
			if (randomChild == null) {
				randomSelectFactor++;
			}else {
				return randomChild;
			}
		}//end of selection
		return randomChild;
	}
}
	
