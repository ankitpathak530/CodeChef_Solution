class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    
    
    
    
    public List<List<Integer>> permute(int[] nums) {
    
         boolean[] visited =new boolean[nums.length];
         solve(nums, new ArrayList<>(), visited);
         return result;
    }
    
    
    
    private void solve(int[] nums, List<Integer> temp, boolean[] visited){
          
         if(temp.size() == nums.length){
             result.add(new ArrayList<>(temp));
             return;
         }
        
        
         for(int i=0; i<nums.length; i++){
             if(visited[i]) continue;
             
             visited[i] = true;
             temp.add(nums[i]);
             solve(nums, temp, visited);
             
             visited[i] = false;
             temp.remove(temp.size()-1);
         }
        
        
    }
}