package Recursion;

public class LastOccurenseInArrayRecursion {

	public static void main(String[] args) {
		System.out.println(getLastOccurence(new int[] {5,2,6,3,9,1,33,2,6,7}, 0,6));

	}
	
	public static int getLastOccurence(int ar[], int idx,int element) {
		
		 if(idx == ar.length) {
			 return -1;
		 }
		
		 int minPart = getLastOccurence(ar, idx+1, element);  // idx,-1
		 if(minPart == -1) {
			  return (ar[idx] == element) ? idx : -1;
		 }
		 else {
			 return minPart;
		 }
		 
	}

}
