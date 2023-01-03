package main;

import java.util.ArrayDeque;

public class ShortestBridge_Leetcode {


	    public static class Pair{
	        int i; 
	        int j;
	        Pair(int i, int j){
	            this.i = i;
	            this.j = j;
	        }
	    }

	    public static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
	    public int shortestBridge(int[][] grid) {
	        
	        boolean flag = true;
	        boolean[][] visited = new boolean[grid.length][grid[0].length];
	        ArrayDeque<Pair> q = new ArrayDeque<>();

	        for(int i=0; i<grid.length && flag; i++){
	            for(int j=0; j<grid[0].length && flag; j++){
	                  if(grid[i][j] == 1){
	                       dfs(grid, i,j,visited,q);
	                       flag = false;
	                  }
	            }
	        }

	        int level = -1;
	        while(q.size() > 0)
	        {
	             level++;
	             int size = q.size();
	             while(size-->0){
	                 Pair rem = q.removeFirst();
	                 for(int i=0; i<4; i++){
	                      int rowdash = rem.i + dir[i][0];
	                      int coldash = rem.j + dir[i][1];
	                      
	                      if(rowdash < 0 || rowdash >= grid.length || coldash < 0 || coldash >= grid[0].length ||
	                           visited[rowdash][coldash] == true){
	                                continue; }
	                       
	                       visited[rowdash][coldash] = true;
	                       if(grid[rowdash][coldash] == 1)
	                           return level;
	                       q.add(new Pair(rowdash,coldash));
	                 }
	             }    
	        }
	       return level;
	    }

	    public void dfs(int[][] grid, int row, int col,boolean[][] visited,ArrayDeque<Pair> q){

	         if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0 || 
	               visited[row][col] == true){
	             return; }
	         
	             visited[row][col] =  true;
	             q.add(new Pair(row,col));
	             dfs(grid, row-1, col, visited,q);
	             dfs(grid, row, col+1, visited,q);
	             dfs(grid, row+1, col, visited,q);
	             dfs(grid, row, col-1, visited,q); 
	    }
	}