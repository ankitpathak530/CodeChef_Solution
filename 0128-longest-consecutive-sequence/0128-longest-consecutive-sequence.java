class Solution {
    public int longestConsecutive(int[] nums) {

         Map<Integer, Boolean> map = new HashMap<>();
         int max = Integer.MIN_VALUE;

         for(int num : nums){
             map.put(num, true);
         }

         for(Map.Entry<Integer,Boolean> entry : map.entrySet()){
              int key = entry.getKey();
              if(map.containsKey(key-1)){
                  map.put(key, false);
              }
         }


         for(int value : nums ) {
             if(map.get(value) == true){

              int count = 1;
              while(map.containsKey(value+1)){
                    count++;
                    value++;
              }
              max = Math.max(count, max);
             }
         }

         return max == Integer.MIN_VALUE ? 0 : max;
    }
}