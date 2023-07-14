class Solution {
    public int longestSubsequence(int[] arr, int difference) {
           
        Map<Integer,Integer> map = new HashMap<>();
        int d = difference;
        int longestMax = 1;
        
        
        for(int i=0; i<arr.length; i++){
             
             if(map.containsKey(arr[i]-d)){
                 int newMax = map.get(arr[i]-d);
                 longestMax = Math.max(longestMax, newMax+1);
                 map.put(arr[i], newMax + 1);
             }
            else{
                map.put(arr[i], 1);
            }
        }
        
        return longestMax;
    }
}