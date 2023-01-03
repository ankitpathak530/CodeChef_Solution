package main;

import java.util.HashMap;
import java.util.Map;

public class VirbleArithmaticPuzzle {

	public static void main(String[] args) {
		
		System.out.println(isSolvable(new String[]{"CBA","CBA","CBA","CBA","CBA"}, "EDD"));
	}
	public static boolean isSolvable(String[] words, String result) {
	        
	        Map<Character,Integer> map = new HashMap<>();
	        StringBuilder sb = new StringBuilder("");
	        
	        
	        for(String s : words){
	            for(char ch : s.toCharArray()){
	                if(!map.containsKey(ch)){
	                   sb.append(ch);
	                   map.put(ch, -1);
	                }
	            }
	        }
	        
	        //adding all common character of result to oneString sb
	        for(char ch : result.toCharArray())
	        	if(sb.indexOf(ch+"") == -1)
	        		 sb.append(ch);
	        
	        
	        String oneUniqueCharacters = sb.toString();
	        boolean[] usedNum = new boolean[10];
	        return doSolve(oneUniqueCharacters, 0, map, usedNum, result, words);
	       
	  }

	 public static int getNumValue(String[] words, Map<Character,Integer> map ) {
		 System.out.println();
		  int sum = 0;
		  for(String s :words)
		  {
			  System.out.println(s);
			  String num = "";
			  for(char ch : s.toCharArray()) {
			      num  += Integer.toString(map.get(ch));
			  }
			  System.out.println(num);
			  sum += Integer.parseInt(num);
		  }
		  return sum;
	 }
	 
	 
	 
	 public static boolean doSolve(String oneUniqueCharacters, int idx, Map<Character,Integer> map, boolean[] usedNum, String result, String[] words)
	 {
	        
		 if(idx == oneUniqueCharacters.length())
		 {
			 int sum = getNumValue(words, map);
			 int res = getNumValue(new String[] {result}, map);
			 if(sum == res) {
				 System.out.println("YES");
				 return true;
			 }
			 return false;
		 }
		 boolean flag = false;
		 
		 for(int pnum = 0; pnum <=9; pnum++) {
			 char ch = oneUniqueCharacters.charAt(idx);
			 
		     if(usedNum[pnum] == false) {
		    	  usedNum[pnum] = true;
		    	  map.put(ch, pnum);
		    	  flag = doSolve(oneUniqueCharacters, idx + 1, map, usedNum, result, words);
		    	  usedNum[pnum] = false;
		    	  map.put(ch, -1);
		    	  if(flag) break;
		     }
		 }
		 
		 return flag;
	 }

}
