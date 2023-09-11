class Solution {
    public boolean isAnagram(String s, String t) {
        
        int scount[] = new int[27];
        int tcount[] = new int[27];

        for(char ch : s.toCharArray()){
            scount[ch-'a']++;
        }

        for(char ch : t.toCharArray()){
            tcount[ch-'a']++;
        }

        for(int i=0; i<27; i++){
            if(scount[i] != tcount[i]) return false;
        }

        return true;


    }
}