class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
     
        int inDegree[] = new int[n];
        int path[][] = new int[n][n];
        int max = Integer.MIN_VALUE;
        
        for(int[] road : roads){
            inDegree[road[0]]++;
            inDegree[road[1]]++;
            
            path[road[0]][road[1]] = 1;
            path[road[1]][road[0]] = 1;
        }
        
        
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                
                int count = inDegree[i]+inDegree[j];
                if(path[i][j] == 1){
                    count--;
                }
                max = Math.max(count, max);
            }
        }
        
        return max;
    }
}