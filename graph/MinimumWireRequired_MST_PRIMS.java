package graph;

import java.io.*;
import java.util.*;

public class MinimumWireRequired_MST_PRIMS {

   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }
   public static class Pair implements Comparable<Pair>{
       int v; //vertex
       int av; //acquire vertex
       int wt; //weight
       
       Pair(int v, int av, int wt){
           this.v = v;
           this.av = av;
           this.wt = wt;
       }
       
       public int compareTo(Pair o){
           return this.wt - o.wt;
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
         int wt = Integer.parseInt(parts[2]);
         
         graph[v1].add(new Edge(v1,v2,wt));
         graph[v2].add(new Edge(v2,v1,wt));
      }

      // write your code here
      boolean[] visited = new boolean[vtces];
      PriorityQueue<Pair> priorityQ = new PriorityQueue<>();
      priorityQ.add(new Pair(0,-1,0));
      
      while(priorityQ.size() > 0){
          
          Pair rmpair = priorityQ.remove();
          
          if(visited[rmpair.v] == true){
              continue;
          }
          
          visited[rmpair.v] = true;
          if(rmpair.av != -1){
             System.out.println("["+rmpair.v + "-"+rmpair.av+"@"+rmpair.wt+"]");
          }
          
          for(Edge edge : graph[rmpair.v])
          {
              if(visited[edge.nbr] == false){
                  priorityQ.add(new Pair(edge.nbr,rmpair.v,edge.wt));
              }
          }
      }
      
      
      
      
      
      
      
      
      
      
      
      
      
      
   }

}
