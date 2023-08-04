import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.HashMap;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        HashMap<Integer, Boolean> memo = new HashMap<>();
        return helper(0, s, wordSet, memo);
    }

    public boolean helper(int idx, String str, Set<String> wordSet, HashMap<Integer, Boolean> memo) {
        if (idx >= str.length()) {
            return true;
        }

        if (memo.containsKey(idx)) {
            return memo.get(idx);
        }

        for (int i = idx + 1; i <= str.length(); i++) {
            String temp = str.substring(idx, i);
            if (wordSet.contains(temp) && helper(i, str, wordSet, memo)) {
                memo.put(idx, true);
                return true;
            }
        }

        memo.put(idx, false);
        return false;
    }
}
