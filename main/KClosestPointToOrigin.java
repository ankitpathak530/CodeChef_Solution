package main;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointToOrigin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
   
        //designing max heap using custom comparator with array of coordinates with greatest distance from origin  at top of the heap followed by lower distance 
    
    // PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() { 
    //     @Override
    //     public int compare(int[] a, int[] b) {
    //         int distA=a[0]*a[0]+a[1]*a[1]; //by formula distanceFromOrigin = (X^2)-(Y^2)
    //         int distB=b[0]*b[0]+b[1]*b[1];
    //         return (distB-distA); //difference = secondDistance - firstDistance
    //     }
    // });
    

	public int[][] kClosest(int[][] points, int k) {

	     Arrays.sort(points, (o1,o2) ->  o1[0]*o1[0]+o1[0]*o1[1] - o2[0]*o2[0]+o2[1]*o2[1] );   
	     return Arrays.copyOfRange(points, 0, k);   	    
	}
	
}
