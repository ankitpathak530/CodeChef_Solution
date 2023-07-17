class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
           
         int[] letFreq = new int[27];
        
         for(char ch : letters)
             letFreq[ch - 'a']++;
         
        
         return maxScore(words, letFreq, score, 0);
        
    }
    
    private int maxScore(String[] words, int[] letFreq, int[] score, int idx)
    {
        if(idx == words.length){
            return 0;
        }
        
        //if word not selected
         int sno = 0 + maxScore(words, letFreq, score, idx+1);
        
        //if word got seletected
           //1st check weather all char freq letter is available for selection 
        boolean flag = true; //true if this word can be part of the set
        int wordScore = 0;
        String word = words[idx];
        for(char ch : word.toCharArray()){
             
            if(letFreq[ch - 'a'] <= 0){
                 flag = false;
            }
            
            letFreq[ch-'a']--;
            wordScore += score[ch-'a'];          
        }
        
        int syes = 0;
        if(flag){//true means all frequency of words are available and this word can be part of the set
             syes = wordScore + maxScore(words, letFreq, score, idx+1);
        }
        
        //now backtracking to make freq of word character as it was before
        for(char ch : word.toCharArray()){
            letFreq[ch-'a']++;
        }
        
        return Math.max(sno, syes);
    }
}