import java.util.ArrayList;

class Solution {
 
    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][] visited = new boolean[m][n];
        AtomicInteger maxGold = new AtomicInteger(0);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                  
                    dfs(grid, i, j, visited, 0, maxGold);
                }
            }
        }

        return maxGold.get();
    }

    public void dfs(int[][] grid, int row, int col, boolean[][] visited, int sum, AtomicInteger maxGold) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col] || grid[row][col] == 0) {
            maxGold.set(Math.max(maxGold.get(), sum));
            return;
        }

        visited[row][col] = true; // Mark cell as visited
        sum += grid[row][col]; // Add gold to the current sum

        // Explore all four directions
        dfs(grid, row - 1, col, visited, sum, maxGold);
        dfs(grid, row, col + 1, visited, sum, maxGold);
        dfs(grid, row + 1, col, visited, sum, maxGold);
        dfs(grid, row, col - 1, visited, sum, maxGold);

        visited[row][col] = false; // Mark cell as unvisited (backtrack)
    }
}
