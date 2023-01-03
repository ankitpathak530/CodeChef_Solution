package Recursion;

import java.util.ArrayList;
import java.util.List;

public class GetKeypadCombinationRecursion {

	private static List<String> keys = List.of("?!","abc","def","ghi","jkl","mnop","qrst","uv","wxyz",".;");    
	    
	public static void main(String[] args) 
	{	
//	     List<String> list = List.of("?!","abc","def","ghi","jkl","mnop","qrst","uv","wxyz",".;");    
//	     String keyPressed = "12";
//         List<String> result = getCombination(list, keyPressed);
//         result.forEach(System.out::println);
		
		printKPC("123","");
	}
	
	
	
	public static List<String> getCombination(List<String> chars, String keyPressed){ // 12
		
		if(keyPressed == "") {
			ArrayList<String> newList = new ArrayList<>();
			newList.add("");
			return newList;
		}
	
		char firstKey = keyPressed.charAt(0); // 1
		String restKey = keyPressed.substring(1); // 2
		List<String> returnString = getCombination(chars, restKey); // ["d","e","f"]
		
		
		String[] charOfFirstKey = chars.get(firstKey-'0').split("");// ["abc"] -> ["a","b","c"]
		
		List<String> newList = new ArrayList<>();
		for(String ch : charOfFirstKey) {
		      	for(String s: returnString) 
		      		  newList.add(ch + s);      		  
		}			
		return newList;
	}
	
	
	
	
	
	// This code won't return just print the output. Output of above code will also be same.
		public static void printKPC(String question, String result)
		{
			if(question.length() == 0) {
				System.out.println(result);
				return;
			}
			  
			char fst = question.charAt(0);
			String restOstring = question.substring(1);
			
			String fstKey = keys.get(fst - '0');
			for(char ch : fstKey.toCharArray()) {
				  printKPC(restOstring, result+ch);
			}
		}
		

}
