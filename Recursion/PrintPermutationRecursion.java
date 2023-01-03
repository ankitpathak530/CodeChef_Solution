package Recursion;

public class PrintPermutationRecursion {

	public static void main(String[] args) {
	  
		permutation("abc", "");

	}
	
	
	
	public static void permutation(String str, String result) {
		
		if(str.length() == 0) {
			System.out.println(result);
			return;
		}
		
		
		 for(int i=0; i<str.length(); i++) {   // abcd // bcd // cd // d
			 String ros = str.substring(0,i) + str.substring(i+1); //  bcd  // cd // d  // ""
			 permutation(ros,  result + str.charAt(i) ); // bcd, a // cd , ab //  d, abc/  "", abcd
		 }
		 
		 
	}

}
