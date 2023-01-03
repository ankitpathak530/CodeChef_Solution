package Recursion;

import java.util.Stack;


public class DecodeString {

	class Solution {
	    public String decodeString(String s) {
	        String finalString = "";
	        Stack<Integer> stack1 = new Stack<Integer>();
	        Stack<String> stack2 = new Stack<String>();
	        int i = 0;
	        while(i < s.length()){
	             char ch = s.charAt(i);

	             if(Character.isDigit(ch)){
	                int num = 0;
	                while(Character.isDigit(s.charAt(i))){
	                      num = num * 10 + s.charAt(i++) - '0';
	                }
	                stack1.push(num); 
	             }
	             else if(ch == '['){
	                stack2.push("[");
	                i++;
	             }          
	             else if(ch == ']'){
	                 //pop until [ bracket
	                 String res = "";
	                 while(!stack2.isEmpty()){
	                     String str = stack2.pop();
	                     if(str == "[") break;
	                     res = str + res;
	                 }
	                 int times = stack1.pop();
	                 StringBuilder sb = new StringBuilder(res);
	                 while(times-->1){    sb.append(res);   }
	                 stack2.push(sb.toString());
	                 i++;
	             }
	             else{
	                stack2.push(ch+"");    
	                i++;
	             }  
	         }
	        while(!stack2.isEmpty()){
	            finalString = stack2.pop() + finalString;
	        }

	       return finalString;
	    }
	}
}
