class Solution {
    public int minDeletions(String s) {
          
         int[] scount = new int[27];
         Set<Integer> set = new HashSet<>();

         for(char ch : s.toCharArray()){
             scount[ch-'a']++;
         }
         
        Arrays.sort(scount);
        int count = 0;
        
        for(int i : scount){
            if(i == 0) continue;
            if(set.contains(i)){
                int j = i;
                while(set.contains(j) && j > 0){
                    j--;
                    count++;
                }
                set.add(j);
            }
            else{
                set.add(i);
            }
        }

        return count;
    }
}