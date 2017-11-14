
public class Client {
	public static void main(String[] args) {
		System.out.println("maze using DFS");
		Maze maze = new Maze(1000,1000);
		maze.generateMaze();
		MazePath path = new MazePath();
		path.findPathDFS(maze);
	}
}
