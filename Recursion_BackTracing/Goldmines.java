package Recursion_BackTracing;
import java.util.*;



public class Goldmines {
  static int max = 0;
  public static void getMaxGold(int[][] arr) {
    //write your code here
     
       boolean[][] visited = new boolean[arr.length][arr[0].length];
       int res = goldMines(arr,visited,0,0,0);
       System.out.println(res);
       
       
	    
	  
  }
  public static int goldMines(int[][] arr, boolean[][] visited, int row, int col,int sum)
  {
      if(row < 0 || row > arr.length || col < 0 || col > arr[0].length || visited[row][col] || arr[row][col] == 0){
          return 0;
      }
      else if(row == arr.length && col == arr[0].length){
    	  System.out.println("MAX:-"+max);
          return max;
      }
                 System.out.println("SUM:"+sum);
                 visited[row][col] = true;
                 int topSum = goldMines(arr,visited,row-1,col,sum+arr[row][col]); // top
                 int rightSum = goldMines(arr,visited,row,col+1,sum+arr[row][col]); // right
                 int bottomSum = goldMines(arr,visited,row+1,col,sum+arr[row][col]); // bottom
                 int leftSum = goldMines(arr,visited,row,col-1,sum+arr[row][col]); // left;
                 visited[row][col] = false;
                 int total = topSum+rightSum+bottomSum+leftSum;
                 
                 if(total > max) {
                	 max = total;
                	 return max;
                 }
                 return max;
                  
                
  }
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();
    int[][] arr = new int[m][n];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0 ; j  < arr[0].length; j++) {
        arr[i][j] = scn.nextInt();
      }
    }
    getMaxGold(arr);
    System.out.println(max);
  }

}















/*
*
*import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	static Integer max = 0;
	public static void getMaxGold(int[][] arr){
		//write your code here
	
	    boolean[][] visited = new boolean[arr.length][arr[0].length];
	    for(int i=0; i<arr.length; i++){
	        for(int j=0; j<arr[0].length; j++){
	            if(arr[i][j] != 0 && visited[i][j] == false){
	                  
	                  ArrayList<Integer> sum = new ArrayList<>();
	                  getMax(arr,0,0,visited, sum);
	                  Integer res = sum.stream().collect(Collectors.summingInt( e -> e));
	                  if(res > max ) max = res;
	            }
	        }
	    }
	}
	public static void getMax(int[][] ar, int row, int col, boolean[][] visited, ArrayList<Integer> sum)
	{
	     if(row < 0 || col < 0 || row >= ar.length || col >= ar[0].length || 
	            ar[row][col] == 0 || visited[row][col] == true){
	           return;
         }
         
          visited[row][col] = true;
          sum.add(ar[row][col]);
          
          getMax(ar, row-1, col, visited,sum);
          getMax(ar, row, col+1, visited, sum);
          getMax(ar, row+1, col, visited, sum);
          getMax(ar, row, col-1, visited, sum);
          visited[row][col] = false;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[][] arr = new int[m][n];
		for(int i = 0; i < arr.length; i++){
			for(int j = 0 ; j  < arr[0].length; j++){
				arr[i][j] = scn.nextInt();
			}
		}
		getMaxGold(arr);
		System.out.println(max);
	}
		
}
*/