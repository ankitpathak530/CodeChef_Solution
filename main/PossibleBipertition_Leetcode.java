package main;

import java.util.ArrayList;
import java.util.List;


public class PossibleBipertition_Leetcode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Solution {

	    public boolean possibleBipartition(int N, int[][] dislikes) {     //  [[1,2],[1,3],[2,3]]    
	    
	        List<Integer>[] graph = new List[N + 1];  

	        for (int i = 1; i <= N; ++i) graph[i] = new ArrayList<>();        

	        for (int[] dislike : dislikes) {
	            int fc = dislike[0];
	            int sc = dislike[1];
	            graph[fc].add(sc);
	            graph[sc].add(fc);
	        }

	        Integer[] colors = new Integer[N + 1];

	        for (int i = 1; i <= N; ++i) {
	            // If the connected component that node i belongs to hasn't been colored yet then try coloring it.
	            if (colors[i] == null && !dfs(graph, colors, i, 1)) return false;
	        }
	        return true;   
	    }

	    private boolean dfs(List<Integer>[] graph, Integer[] colors, int currNode, int currColor) {
	        colors[currNode] = currColor;

	        // Color all uncolored adjacent nodes.
	        for (Integer adjacentNode : graph[currNode]) {

	            if (colors[adjacentNode] == null) {
	                  if(!dfs(graph, colors, adjacentNode, currColor * -1)) return false;

	            } else if (colors[adjacentNode] == currColor) {
	                return false;                                     
	            }
	        }
	        return true;        
	    }
	}

}
