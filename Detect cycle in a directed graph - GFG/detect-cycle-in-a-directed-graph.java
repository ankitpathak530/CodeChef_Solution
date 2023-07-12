//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        
        
        boolean[] visited = new boolean[V];
        boolean[] inSameRecursion = new boolean[V];
        for(int i=0; i<V; i++){
            if(visited[i] == false){
                if(isCyclicGraph(adj, i, visited, inSameRecursion)){
                     return true;
                }
            }
        }
        return false;
    }
    
    public boolean isCyclicGraph(ArrayList<ArrayList<Integer>> adj, int src,boolean[] visited, boolean[] inSameRecursion)
    {
           
           visited[src] = true;
           inSameRecursion[src]  = true;
           
           for(int nbr : adj.get(src)){
                if(visited[nbr] == false){
                    if(isCyclicGraph(adj, nbr, visited, inSameRecursion)){
                        return true;
                    }
                }
                else{//if nbr is visited
                    if(inSameRecursion[nbr] == true){//but if it's visited in same recursion
                        return true;
                    }
                }
           }
           
           inSameRecursion[src] = false;
           return false;
    }
    
}