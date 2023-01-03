package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CountStairPath {

	// 1-2-3 steps are allowed
	public static void main(String[] args) {
		int i  = printPath(6,new int[7]);
		 SortedMap<String,Integer> map = new TreeMap<>();
		  Map<String, Integer> collect = map.entrySet().stream()
	        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry :: getValue));
		
	}
	
	public static int printPath(int n, int[] qb) {
		
		if(n == 0) {
			return 1;
		}else if(n < 0) {
			return 0;
		}
		if(qb[n]  != 0) {
			return qb[n];
		}
		
		System.out.println("Hello : "+n);
		int fstep = printPath(n-1, qb);
		int sstep = printPath(n-2, qb);
		int tstep = printPath(n-3, qb);
		System.out.println();
		int total = fstep + sstep + tstep;
		qb[n] = total;
		return total;
	}
}