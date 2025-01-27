package graph;

import java.io.*;
import java.util.*;


public class CountIsland {


	   public static void main(String[] args) throws Exception {
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	      int m = Integer.parseInt(br.readLine());
	      int n = Integer.parseInt(br.readLine());
	      int[][] arr = new int[m][n];

	      for (int i = 0; i < arr.length; i++) {
	         String parts = br.readLine();
	         for (int j = 0; j < arr[0].length; j++) {
	            arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
	         }
	      }

	      // write your code here
	      int count = 0;
	      boolean visited[][] = new boolean[m][n];
	      for(int i=0; i<m; i++){
	          for(int j=0; j<n; j++){
	              if(arr[i][j] == 0 && visited[i][j] == false){
	                   countIsland(arr,i,j,visited);
	                   count++;
	              }
	          }
	      }
	      System.out.println(count);
	   }
	   
	   public static void countIsland(int[][] ar, int i, int j, boolean[][] visited)
	   {
	        if(i < 0 || i >= ar.length || j < 0 || j >= ar[0].length || ar[i][j] == 1 || visited[i][j] == true){
	            return;
	        }
	        
	        visited[i][j] = true;
	        countIsland(ar, i-1, j, visited); // top
	        countIsland(ar, i, j+1, visited); // right
	        countIsland(ar, i+1, j, visited);//  bottom
	        countIsland(ar, i, j-1, visited);//  left
	   }

	}
