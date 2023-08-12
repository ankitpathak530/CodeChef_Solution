class Solution {
    int count = 0;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        
        return solve(obstacleGrid, 0, 0, memo);
        
     
    }
    
    private int solve(int[][] obs, int row, int col, int[][] memo){
        
        if(row >= obs.length || col >= obs[0].length || obs[row][col] == 1){
            return 0;
        }
        
             
        if(memo[row][col] != -1){
            return memo[row][col];
        }
        
        
        if(row == obs.length-1 && col == obs[0].length-1){
            return 1;
        }
   
 
        
        int downStep = solve(obs, row+1, col, memo); // Move Down
        int rightStep = solve(obs, row, col+1, memo); // Move Right
        
        memo[row][col] = downStep+rightStep;
        return memo[row][col];
        
    }
}
