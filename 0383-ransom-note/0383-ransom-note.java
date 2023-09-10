class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

         int[] noteCharCount = new int[27];
         int[] magaCharCount = new int[27];

         for( char ch : ransomNote.toCharArray()){
              noteCharCount[ch- 'a']++; 
         }   

         for(char ch : magazine.toCharArray()){
             magaCharCount[ch - 'a']++;
         }

         for(int i=0; i<27; i++){
             if(noteCharCount[i] > magaCharCount[i]) return false;
         }

         return true;
    }
}