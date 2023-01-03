package Recursion;
import java.util.List;
import java.util.ArrayList;

public class GetSubsequenceOfStringRecursion {

	public static void main(String[] args) {
		
//		 List<String> rs =  getSS("abc");
//         rs.forEach(System.out::println);
		
		printSS("abc","");
	}
	
	
	
	//Faith -> [bc] -> [-- , b-, -c, bc]
	//        [abc] -> [---, -b-, --c,-bc     a--, ab-, a-c, abc]
	public static List<String> getSS(String str)
	{
		
		if(str == "") {
			ArrayList<String> newList = new ArrayList<>();
			newList.add("");
			return newList;
		}
		
		
		char firstChar = str.charAt(0);
		String othersChar = str.substring(1);
		
		List<String> recursionResult = getSS(othersChar); 
		List<String> myResult = new ArrayList<String>();
		
		
		for(String s : recursionResult) {
			    myResult.add(""+ s);               //concatenating nothing with String 
		     	myResult.add(firstChar + s);       //concatenating firstChar with String
		}
		return myResult;
	}
	
	
	
	
	
	
	
	
	
	// This code won't return just print the output. Output of above code will also be same.
	public static void printSS(String str, String result)
	{
		if(str.length() == 0 ) {
			System.out.println(result);
			return;
		}
		
	    char firstChar = str.charAt(0);
	    String restofs = str.substring(1);
		
	    printSS(restofs, result+firstChar);
	    printSS(restofs, result+"");
		
		
	}

}
