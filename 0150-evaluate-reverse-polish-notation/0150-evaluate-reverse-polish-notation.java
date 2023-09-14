class Solution {
    public int evalRPN(String[] tokens) {
          Stack<Integer> s1 = new Stack<>();
          int a,b;
        
          for(String str : tokens){

                if(str.equals("+")){
                    s1.add(s1.pop() + s1.pop());
                }else if(str.equals("-")){
                    a = s1.pop();
                    b = s1.pop();
                    s1.add(b-a);
                }else if(str.equals("*")){
                    s1.add(s1.pop() * s1.pop());
                }else if(str.equals("/")){
                    a = s1.pop();
                    b = s1.pop();
                    s1.add(b / a);
                }else{
                    s1.add(Integer.parseInt(str));
                }
          } 
          return s1.pop();  
    }
}