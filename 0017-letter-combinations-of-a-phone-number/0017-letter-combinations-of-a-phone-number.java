class Solution {
    
      
    
    
    
    public List<String> letterCombinations(String digits) {
        
         String keys[] = {"", "","abc", "def", "ghi", "jkl","mno", "pqrs", "tuv", "wxyz"};          
         List<String> result = new ArrayList<>();
         
         if(digits.equals("")) return result;
        
         helper(digits, "", keys, result);
         return result;
        
    }
    
    
    private void helper(String str, String asf, String[] keys,  List<String> list){

        if(str.length() == 0){
            list.add(asf);
            return;
        }

        
        String cho = keys[str.charAt(0) - '0']; //taking keys belonging to 0th character position.
        String ros = str.substring(1); // excluding keys of first character all are rest of string. 

        for(int i=0; i<cho.length(); i++){
              helper(ros, asf + cho.charAt(i), keys, list);
        }

    }
}