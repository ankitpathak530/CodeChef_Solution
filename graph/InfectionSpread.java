package graph;

import java.io.*;
import java.util.*;





public class InfectionSpread {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
   static class Pair{
       int vtx;
       int time;
       Pair(int vtx, int time){
           this.vtx = vtx;
           this.time = time;
       }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());
      int t = Integer.parseInt(br.readLine());
      
      // write your code here
      int count = 0;
      int[] visited = new int[vtces];
      ArrayDeque<Pair> queue = new ArrayDeque<>();
      queue.add(new Pair(src,1));
      
      while(queue.size() > 0)
      {
           Pair rmPair = queue.removeFirst();
           
           if(visited[rmPair.vtx] > 0){
               continue;
           }
           
           if(rmPair.time > t){
               break;
           }
           
           visited[rmPair.vtx] = rmPair.time;
           count++;
           
           for(Edge e : graph[rmPair.vtx]){
               if(visited[e.nbr] == 0){
                   queue.add(new Pair(e.nbr,rmPair.time + 1));
               }
           }
      }
      System.out.println(count);
   }
 
}