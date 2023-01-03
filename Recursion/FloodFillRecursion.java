package Recursion;

public class FloodFillRecursion {

	public static void main(String[] args) {
		int maze[][] = {{0,1,1},{0,0,1},{1,0,0},{0,1,0}};
		boolean visited[][] = new boolean[4][3];
		
		printPath(maze, 0, 0 ,visited,"");
		
	}
	
	public static void printPath(int maze[][], int row, int col, boolean[][] visited, String psf) {
		
		//checking if are we pointing outside of the board ?
		if((row < 0 || col < 0 || row == maze.length || col == maze[0].length || 
				maze[row][col] == 1 || visited[row][col] == true)){
			return;
		}
		
		if(row == maze.length-1 && col == maze[0].length-1) {
			System.out.println("PATH -> "+psf);
			return;
		}
		
		
		visited[row][col] = true; //Once visit mark that cell as true 
		printPath(maze, row-1, col, visited, "t"+psf);// top
		printPath(maze, row, col-1, visited, "l"+psf);// left
		printPath(maze, row+1, col, visited, "d"+psf);// down
		printPath(maze, row, col+1, visited, "r"+psf); // right
		visited[row][col] = false; //Once returning mark false to all visited cell
	}
}
