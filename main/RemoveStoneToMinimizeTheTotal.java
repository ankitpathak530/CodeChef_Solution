package main;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class RemoveStoneToMinimizeTheTotal {

	public static void main(String[] args) {
		
		Set<Integer> set = new HashSet<>();
		
	}
	class Solution {
	    
	    public int minStoneSum(int[] piles, int k) {
	        
	        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);
	        int totalSum = 0;

	        for(int i=0; i<piles.length; i++){
	            pq.add(piles[i]);
	            totalSum += piles[i];
	        }


	        while(k-->0){
	            int i = pq.remove();
	            int j = (int)Math.ceil(i/2.0); 
	            totalSum = totalSum - i + j;
	            pq.add(j);
	        }
	    
	         return totalSum;
	    }
	}

}
