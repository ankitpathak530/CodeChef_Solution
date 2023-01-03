package DSA;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generat ed method stub
            
		  LinkedHashMap<Integer, List<List<Integer>>> map = new LinkedHashMap<>();
		 
		  List<List<Integer>> res = map.entrySet().stream().findFirst().get().getValue();
	      int[][] result = new int[res.size()][2];
	      
	      for(int i=0; i<res.size(); i++) {
	    	  result[i] = new int[] {res.get(i).get(0), res.get(i).get(1)};
	      }
	     
	     
	        
	}

}
