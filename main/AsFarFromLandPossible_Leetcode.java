package main;

import java.util.ArrayDeque;

public class AsFarFromLandPossible_Leetcode {


	    public static class Pair{
	        int i;
	        int j;
	        Pair(int i, int j){
	            this.i = i;
	            this.j = j;
	        }
	    }

	    public static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};

	    public int maxDistance(int[][] grid) {
	                  
	          ArrayDeque<Pair> q = new ArrayDeque<>();
	          int rowSize = grid.length;
	          int colSize = grid[0].length;

	          for(int i=0; i<rowSize; i++){
	              for(int j=0; j<colSize; j++){
	                  if(grid[i][j] == 1)
	                       q.add(new Pair(i,j));
	              }
	          }


	          if(q.size() == 0 || q.size() == rowSize * colSize)
	               return -1;  


	          int level = -1;
	          while(q.size() > 0)
	          {
	                int size = q.size();
	                while(size-->0){
	                    Pair pair = q.removeFirst();
	        
	                    for(int k=0; k<4; k++){
	                        int rowdash = pair.i + dir[k][0];
	                        int coldash = pair.j + dir[k][1];

	                        if(rowdash < 0 || rowdash >= rowSize || coldash < 0 || coldash >= colSize || grid[rowdash][coldash] == 1){
	                            continue;
	                        }
	                        
	                        grid[rowdash][coldash] = 1;
	                        q.add(new Pair(rowdash,coldash));
	                    }
	                }
	                level++;
	          }
	        
	         return level;
	    }
	}