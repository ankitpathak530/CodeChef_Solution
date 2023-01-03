package Recursion;

import java.util.Arrays;

public class AllOccurenseInArrayRecursion {

	public static void main(String[] args) {
		
        int res[] =   getAllOccurence(new int[] {5,2,6,3,9,1,33,2,6,7}, 0,6,0);
        for(int i : res) {
        	System.out.println(i);
        }
	}
	
	public static int[] getAllOccurence(int ar[], int idx,int element, int fsf) {
		
		 if(idx == ar.length) {
			 return new int[fsf];
		 }
		
		 if(ar[idx] == element) {		 
		        int[] iarr = getAllOccurence(ar, idx+1, element,fsf+1); 
		        iarr[fsf] = idx;
		        return iarr;
		 }
		 else {
			   int rcr[] = getAllOccurence(ar, idx+1, element,fsf);  
			   return rcr;
		 }
			 
	}

}
