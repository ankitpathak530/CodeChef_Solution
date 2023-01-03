package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;



public class PrintPath {
	 static class Edge {
	      int src;
	      int nbr;
	      int wt;

	      Edge(int src, int nbr, int wt){
	         this.src = src;
	         this.nbr = nbr;
	         this.wt = wt;
	      }
	   }
	   public static void main(String[] args) throws Exception {
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	      int vtces = Integer.parseInt(br.readLine());
	      ArrayList<Edge>[] graph = new ArrayList[vtces];
	      for(int i = 0; i < vtces; i++){
	         graph[i] = new ArrayList<>();
	      }

	      int edges = Integer.parseInt(br.readLine());
	      for(int i = 0; i < edges; i++){
	         String[] parts = br.readLine().split(" ");
	         int v1 = Integer.parseInt(parts[0]);
	         int v2 = Integer.parseInt(parts[1]);
	         int wt = Integer.parseInt(parts[2]);
	         graph[v1].add(new Edge(v1, v2, wt));
	         graph[v2].add(new Edge(v2, v1, wt));
	      }

	      int src = Integer.parseInt(br.readLine());
	      int dest = Integer.parseInt(br.readLine());

	      // write your code here
	      boolean[] visited = new boolean[vtces];
	      getAllPossiblePath(graph,src,dest,visited, src+"");
	    }
	    
	    
	   public static void getAllPossiblePath(ArrayList<Edge>[] graph, int src, int dst, boolean[] visited, String psf)
	   {
	       if(src == dst){
	           System.out.print(psf+"\n");
	           return;
	       }
	       
	       visited[src] = true;
	       for(Edge edge : graph[src]){
	           if(visited[edge.nbr] == false){ 
	              getAllPossiblePath(graph,edge.nbr,dst,visited, psf+edge.nbr);
	           }
	       }
	       visited[src] = false;
	   }
}