import java.util.*;

class Solution {
    public String minWindow(String s, String t) {

        // Create a map to store the count of characters in string 't'
        Map<Character, Integer> tCount = new HashMap<>();
        
        // Create a map to store the count of characters in the current window of 's'
        Map<Character, Integer> sCount = new HashMap<>();

        // Populate the 'tCount' map with the character counts of string 't'
        for (char ch : t.toCharArray()) {
            tCount.put(ch, tCount.getOrDefault(ch, 0) + 1);
        }

        int mcount = 0;          // Maintain the count of characters matched with 't'
        int dcount = t.length(); // The desired count of characters from 't'
        int i = -1, j = -1;      // Initialize 'i' and 'j' to -1 to represent an empty window
        String ans = "";         // Initialize the final answer

        while (true) {
            // Maintain two flags to exit from the outer loop if no progress is made in inner loops
            boolean f1 = false, f2 = false;

            // Expand the window by acquiring characters towards the right side
            while (i < s.length() - 1 && mcount < dcount) {
                i++;
                char ch = s.charAt(i);
                sCount.put(ch, sCount.getOrDefault(ch, 0) + 1);

                // Check if the character count in the current window is less than or equal to its count in 't'
                if (sCount.getOrDefault(ch, 0) <= tCount.getOrDefault(ch, 0)) {
                    mcount++;
                }
                f1 = true;
            }

            // Contract the window by releasing characters from the left side
            while (j < i && mcount == dcount) {
                String pans = s.substring(j + 1, i + 1);
                if (ans.length() == 0 || ans.length() > pans.length()) {
                    ans = pans;
                }

                j++;
                char ch = s.charAt(j);

                // If the character count is one, remove the element; otherwise, decrement its count
                if (sCount.get(ch) == 1) {
                    sCount.remove(ch);
                } else {
                    sCount.put(ch, sCount.get(ch) - 1);
                }

                // Check if removing this character affects the count matching with 't'
                if (sCount.getOrDefault(ch, 0) < tCount.getOrDefault(ch, 0)) {
                    mcount--;
                }
                f2 = true;
            }

            // Base condition to exit from the loop when no progress is made
            if (!f1 && !f2) {
                break;
            }
        }

        return ans;
    }
}
