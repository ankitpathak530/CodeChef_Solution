class Solution {
    public int findCircleNum(int[][] isConnected) {
        
         int  n = isConnected.length;

         Set<Integer>[] graph = new HashSet[n];
         Set<Integer> visited = new HashSet<>();
         int count = 0;

         for(int i=0; i<n; i++){
               graph[i] = new HashSet<>();
         }



         for(int i=0; i<n; i++){
           
             for(int j =0; j<n; j++){
                if(isConnected[i][j] == 1){
                    graph[i].add(j);
                    graph[j].add(i);
                }
             }
         }

        

         for(int i=0; i<n; i++){
        
                 if(!visited.contains(i)){
                     dfs(graph, i, visited);
                     count++;
                 }
             
         }
         return count;
    }

    public void dfs(Set<Integer>[] graph, int src, Set<Integer> visited){
            
            visited.add(src);
            for(int nbr : graph[src]){
                 if(!visited.contains(nbr)){
                     dfs(graph, nbr, visited);
                 }
            }
    }



    public void   getConnectedComponent(int[][] isConnected, int row, int col, boolean[][] visited){
         
         if(row < 0 || col < 0 || row >= isConnected.length || col >= isConnected[0].length || isConnected[row][col] == 0 || visited[row][col] == true){
             return;
         }

         visited[row][col] = true;

         getConnectedComponent(isConnected, row-1, col, visited);
         getConnectedComponent(isConnected, row, col+1, visited);
         getConnectedComponent(isConnected, row+1, col, visited);
         getConnectedComponent(isConnected, row, col-1, visited);

    }
}