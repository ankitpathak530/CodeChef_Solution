package graph;


import java.io.*;
import java.util.*;

public class PerfectOfficialFriend {
   
 static class Edge {
      int src;
      int nbr;
    

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());
      
      ArrayList<Edge>[] graph = new ArrayList[n];
      for (int i = 0; i < n; i++) {
         graph[i] = new ArrayList<>();
      }

      
      for (int i = 0; i < k; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      boolean[] visited = new boolean[n];
      // write your code here
      for(int i=0; i<n; i++){
           ArrayList<Integer> cmp = new ArrayList<Integer>();
           if(visited[i] == false){
                  getConnectedComponent(graph, i, visited, cmp);
                  comps.add(cmp);
           }
                  
      }
      
      int count = 0;
      for(int i=0; i<comps.size(); i++){
          for(int j=i+1; j<comps.size(); j++){
              int mul = comps.get(i).size() * comps.get(j).size();
              count += mul;
          }
      }
     

      System.out.println(count);
   }
   public static void getConnectedComponent(ArrayList<Edge>[] graph, int src, boolean[] visited, ArrayList<Integer> cmp)
   {
            visited[src] = true;
            cmp.add(src);
            for(Edge e : graph[src])
            {
                if(visited[e.nbr] == false)
                {
                    getConnectedComponent(graph, e.nbr, visited, cmp);
                }
            }
   }
}