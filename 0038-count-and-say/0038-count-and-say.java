class Solution {
    //5450
    public String countAndSay(int n) {
        
         if(n == 1){
            return "1";
        }
        
        
        String res = countAndSay(n-1); //11
        
        StringBuffer  finalRes = new StringBuffer("");
        
        char pch = res.charAt(0); // get first character
        int count = 1;
        
        
            
        for(int i=1; i<res.length(); i++){
              
                char ch = res.charAt(i); //to get ith character

                if(pch == ch)
                    count++;
                else{
                    finalRes.append(count).append(pch);
                    count = 1; //reset the count
                    pch = ch;                
                 }
         }
        
        finalRes.append(count).append(pch);
      
         
        
        System.out.println("Res->"+res+ "    FinalRes->  "+finalRes);
        
        
        
        return finalRes.toString();
        
    }
    
  
  
}