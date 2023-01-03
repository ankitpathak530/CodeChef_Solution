package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class HashPath {
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
      System.out.println(isPathAvailable(graph,src,dest,visited));
    }
    
    
	 public static boolean isPathAvailable(ArrayList<Edge>[] graph, int src, int dst, boolean[] visited) {
		  if(src == dst) { 
			  return true; 
		  }
	
		  visited[src] = true;
		  for(Edge edge : graph[src]) {
		        if(visited[edge.nbr] == false){
		            boolean res = isPathAvailable(graph, edge.nbr, dst,visited);
			        if(res) return true;
		        }
		  }
	
		return false;
	}

	 
	 
	 
	 //another way
	 public boolean validPath(int n, int[][] edges, int start, int end) {
	        Map<Integer, List<Integer>> g = new HashMap<>();
	        IntStream.range(0, n).forEach(u -> g.put(u, new LinkedList<>()));
	        Arrays.stream(edges).forEach(e -> {g.get(e[0]).add(e[1]); g.get(e[1]).add(e[0]);});
	        Set<Integer> seen = new HashSet<>();
	        Queue<Integer> q = new LinkedList<>();
	        for (q.add(start), seen.add(start); !q.isEmpty() && q.peek() != end; )
	            g.get(q.poll()).stream().filter(seen::add).forEach(q::offer);
	        return !q.isEmpty();
	    }
	 
	 //another way
	 public boolean isValidPath(int n, int[][] edges, int source, int destination) {
	     Set<Integer> ans= new HashSet<>();
	        ans.add(source);
	        int r=0;
	    

	        while(r<ans.size() && !ans.contains(destination)) {
	            r=ans.size();
	            for(int i=0;i<edges.length;i++) {
	                if(ans.contains(edges[i][0])) {
	                    ans.add(edges[i][1]);
	                }
	                if(ans.contains(edges[i][1])) {
	                    ans.add(edges[i][0]);
	                }
	            }
	        }

	        return ans.contains(destination);
	     }
}













