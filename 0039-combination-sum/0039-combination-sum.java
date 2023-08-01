
class Solution {
    
    
    List<List<Integer>> result = new ArrayList<>();
       
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        solve(0, candidates, new ArrayList<>(), target);
        return result;
    }
    
    private void solve(int idx, int[] candidates, List<Integer> temp, int target) {
        
        if (target < 0) {
            return;
        }
          
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return; // This return is important to avoid unnecessary recursive calls
        }
        
        if (idx >= candidates.length) {
            return;
        }
        
        // If we include the current candidate
        temp.add(candidates[idx]);
        solve(idx, candidates, temp, target - candidates[idx]);
        temp.remove(temp.size() - 1);
        
        // If we skip the current candidate
        solve(idx + 1, candidates, temp, target);
    }
}