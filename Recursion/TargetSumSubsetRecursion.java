package Recursion;

public class TargetSumSubsetRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		printSubset(new int[] {10,20,30},0,"", 0, 30);

	}
	
	public static void printSubset(int[] ar, int idx, String set, int sum,int target)
	{
		
		if(idx == ar.length) {
			if(sum == target) {
				System.out.println(set);
			}
			return;
		}
		
		printSubset(ar, idx+1, set +  ar[idx] + ",", sum+ar[idx], target);
		printSubset(ar, idx+1, set ,sum,target );
		
	}

}
