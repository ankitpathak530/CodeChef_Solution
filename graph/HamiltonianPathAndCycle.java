package graph;


import java.io.*;
import java.util.*;


/*
 *  0123456.
	0123465.
	0125643*
	0346521*
	
	NOTE :>)
	Output ends with "." justify that, from given source input there is hamiltonian path exist.
	Output ends with "*" justify that,  from given source input there is hamiltonian life cycle exist.
	
 */
public class HamiltonianPathAndCycle {

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

	      int src = Integer.parseInt(br.readLine());

	      // write all your codes here
	       Set<Integer> visitedSet = new HashSet<>();
	       printHamiltonian(graph,src,visitedSet,src, src+"");
	      
	       
	     
	   }


	   public static void printHamiltonian(ArrayList<Edge>[] graph, int src,  Set<Integer> visitedSet, int originalSource, String psf)
	   {
	       if(visitedSet.size() == graph.length-1){
	           
	           boolean isHamiltonian = false;
	           
	           for(Edge edge : graph[src]){
	               if(edge.nbr == originalSource){
	                   isHamiltonian = true;
	                   break;
	               }
	           }
	           
	           if(isHamiltonian)
	              System.out.println(psf+"*");
	           else
	              System.out.println(psf+".");
	           
	           return;
	       }
	       
	       visitedSet.add(src);
	       for(Edge edge : graph[src]){
	           if(!visitedSet.contains(edge.nbr)){
	               printHamiltonian(graph, edge.nbr, visitedSet, originalSource, psf+edge.nbr);
	           }
	       }
	       visitedSet.remove(src);
	       
	   }















	}
