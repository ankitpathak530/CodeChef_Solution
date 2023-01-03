package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

//Note:- We have given person can jump 1, 2 or 3 stairs at a time
public class GetStairPathRecursion {

	public static void main(String[] args) {
		
		//System.out.println(getWays(10));
        printWays(2,"");
	}

	
	
	public static List<String> getWays(int stairs) {
		
	
		if(stairs == 0) {
			ArrayList<String> newList = new ArrayList<>();
			newList.add("");
			return newList;
		}
		else if(stairs < 0) {
			return new ArrayList<>();
		}
		
		
		
		List<String> fstStep = getWays(stairs - 1);
		List<String> sndStep = getWays(stairs - 2);
		List<String> trdStep = getWays(stairs - 3);
	
		List<String> list = new ArrayList<>(); 
		for(String s : fstStep)
			 list.add("1"+ s);
		for(String s : sndStep)
			 list.add("2"+ s);
		for(String s : trdStep)
			 list.add("3"+ s);
	
		
		return list;
	}

	
	
	
	
	
	
	
	// This code won't return just print the output. Output of above code will also be same.
	public static void printWays(int stairs, String path) {
		
		if(stairs == 0) {
			System.out.println(path);
			return;
		}
		else if(stairs < 0) {
			return;
		}
		
		
		printWays(stairs-1, 1 + path);
		printWays(stairs-2, 2 + path);
		printWays(stairs-3, 3 + path);
		
		
	}
}
