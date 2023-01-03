package Recursion;

public class MaximumOfArrayRecursion {

	public static void main(String... args) {
		int maxValue = maxInArray(new int[] {5,2,7,3,9,1,33,2,7}, 0);
		System.out.println(maxValue);
	}
	
	public static int maxInArray(int ar[], int idx) {
		
		if(idx == ar.length) {
			return ar[idx-1];
		}
		
		int max = maxInArray(ar,idx+1);
		return (ar[idx] > max) ? ar[idx] : max;
	}
}
