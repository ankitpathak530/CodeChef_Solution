package Recursion;

import java.util.ArrayList;
import java.util.List;

public class GetMazePathsWithJumpRecursion {

	public static void main(String[] args) {
		
             List<String> result = getPath(1,1,1,3,3);
             result.forEach(System.out::println);
	}
	
	
	public static List<String> getPath(int sr, int sc, int diag, int dr, int dc )
	{
		
		if(sr == dr && sc == dc) {
			ArrayList<String> newList = new ArrayList<>();
			newList.add("");
			return newList;
		}
		
	            
		
		List<String> vPath = new ArrayList<>();
		List<String> hPath = new ArrayList<>();
		List<String> dPath = new ArrayList<>();
		
		if(sr < dr){
			vPath = getPath(sr+1, sc,diag, dr, dc);
		}
		if(sc < dc){
	       hPath = getPath(sr, sc+1, diag, dr, dc);
		}
		if(diag <= dr && diag <= dc)
		{
		   dPath = getPath(sr+1,sc+1,diag+1,dr,dc);
		}
		List<String> list = new ArrayList<String>();
		for(String s : vPath) {
			list.add("v"+ s);
		}
		for(String s : hPath) {
			list.add("h"+ s);
		}
		for(String s : dPath) {
			list.add("d"+ s);
		}
		return list;
			
	}
	

}
