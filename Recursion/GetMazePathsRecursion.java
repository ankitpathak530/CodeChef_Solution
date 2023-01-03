package Recursion;

import java.util.ArrayList;
import java.util.List;

public class GetMazePathsRecursion {

	public static void main(String[] args) {
		
//             List<String> result = getPath(1,1,3,3);
//             result.forEach(System.out::println);
		printPath(1,1,3,3,"");
	}
	
	
	public static List<String> getPath(int sr, int sc, int dr, int dc )
	{
		
		if(sr == dr && sc == dc) {
			ArrayList<String> newList = new ArrayList<>();
			newList.add("");
			return newList;
		}
		
	            
		
		List<String> vPath = new ArrayList<>();
		List<String> hPath = new ArrayList<>();
		
		if(sr < dr){
			vPath = getPath(sr+1, sc, dr, dc);
		}
		if(sc < dc){
	       hPath = getPath(sr, sc+1, dr, dc);
		}
		
		List<String> list = new ArrayList<String>();
		for(String s : vPath) {
			list.add("v"+ s);
		}
		for(String s : hPath) {
			list.add("h"+ s);
		}
		
		return list;			
	}
	
	
	
	
	
	
	
	
	// This code won't return just print the output. Output of above code will also be same.
	public static void printPath(int sr, int sc, int dr, int dc, String result) {
		
		if(sr == dr && sc == dc) {
			System.out.println(result);
			return;
		}
		
		
		if(sr < dr) {
			 printPath(sr+1, sc, dr, dc, result + "v");
		}
		if(sc < dc) {
		    printPath(sr, sc+1, dr, dc , result + "h");
		}
		
		
	}
	

}
