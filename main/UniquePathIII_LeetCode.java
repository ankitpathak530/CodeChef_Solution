package main;

public class UniquePathIII_LeetCode {


    public int uniquePathsIII(int[][] grid) {
        
         int zeroCount = 0, srcRow = 0, srcCol = 0;

         for(int i=0; i<grid.length; i++){
             for(int j=0; j<grid[i].length; j++){
                 if(grid[i][j] == 0){
                    zeroCount++;
                 }
                 if(grid[i][j] == 1){
                     srcRow = i; srcCol = j;
                 }
             }
         }

         return unique(grid, srcRow, srcCol, zeroCount);
     
    }
    public int unique(int[][] grid, int row, int col, int zeroCount)
    {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length ||
                 grid[row][col] == -1 ){
                  return 0;}
    
            if(grid[row][col] == 2){
                return zeroCount == -1 ? 1 : 0;
            }

            grid[row][col] = -1;
            zeroCount--;
            
            int total = unique(grid, row-1, col, zeroCount) +
                      unique(grid, row, col+1, zeroCount) +
                      unique(grid, row+1, col, zeroCount) +
                      unique(grid, row, col-1, zeroCount);
          
          grid[row][col] = 0;
          zeroCount++;            
          return total;
    }
}