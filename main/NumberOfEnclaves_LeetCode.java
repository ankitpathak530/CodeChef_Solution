package main;

public class NumberOfEnclaves_LeetCode {


    public int numEnclaves(int[][] grid) {
 
    	StringBuilder sb = new StringBuilder();
    	
       
       boolean[][] visited = new boolean[grid.length][grid[0].length];
       for(int i=0; i<grid.length; i++){
           for(int j=0; j<grid[i].length; j++)
           {
               if( grid[i][j] == 1 && visited[i][j] == false && isOnBoundery(grid,i,j)){
                    drawTreeForComponent(grid, i, j, visited);   
               }
           }
       }

        int count = 0;
        for(int i=0; i<grid.length; i++)
           for(int j=0; j<grid[i].length; j++)
               if(grid[i][j] == 1) 
                  count++;
           
        return count;
    }


    public boolean isOnBoundery(int[][] grid, int i, int j){
          if(i==0 || j == 0 || i == grid.length-1 || j == grid[0].length-1){
              return true;
          }return false;
    }
    public boolean isOutsideBoundery(int[][] grid, int row, int col,boolean[][] visited){
         return (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length ||
            grid[row][col] == 0 || visited[row][col] == true 
         ) ? true : false;
    }

    public void drawTreeForComponent(int[][] grid, int row, int col,boolean[][] visited)
    {
         //outside boundery check
         if(isOutsideBoundery(grid,row,col,visited))
            return;
         
          visited[row][col] = true;
          grid[row][col] = 0;
           
          drawTreeForComponent(grid, row-1, col, visited);
          drawTreeForComponent(grid, row, col+1, visited);
          drawTreeForComponent(grid, row+1, col, visited);
          drawTreeForComponent(grid, row, col-1, visited);
    } 
}