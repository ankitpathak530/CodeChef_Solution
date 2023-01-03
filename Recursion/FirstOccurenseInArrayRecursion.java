package Recursion;

public class FirstOccurenseInArrayRecursion {

	public static void main(String[] args) {
		System.out.println(getFirstOccurence(new int[] {5,2,6,3,9,1,33,2,7}, 0,6));

	}
	
	public static int getFirstOccurence(int ar[], int idx,int element) {
		
		 if(idx == ar.length) {
			 return -1;
		 }
		
		 System.out.println("idx->"+idx);
		 if(ar[idx] == element)
			 return idx;
		 else
			 return getFirstOccurence(ar, idx+1, element);
	}

}
