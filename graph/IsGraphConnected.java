package graph;


import java.io.*;
import java.util.*;


public class IsGraphConnected {
	
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
	         graph[v1].add(new Edge(v1, v2, wt));
	         graph[v2].add(new Edge(v2, v1, wt));
	      }

	      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
	      boolean[] visited = new boolean[vtces];
	      // write your code here
	      for(int i=0; i<vtces; i++){
	           ArrayList<Integer> cmp = new ArrayList<Integer>();
	           if(visited[i] == false){
	                  getConnectedComponent(graph, i, visited, cmp);
	                  comps.add(cmp);
	           }
	                  
	      }
	     

	      System.out.println(comps.size() == 1);
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