/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<Integer, List<TreeNode>> map = new HashMap();
    
    public List<TreeNode> allPossibleFBT(int n) {
        
          if(!map.containsKey(n)){
              List<TreeNode> answer = new ArrayList<>();
              if(n == 1){
                  answer.add(new TreeNode(0));
              }if(n % 2 == 1){//only for odd tree no.
                  for(int i=1; i<n; i++){
                     List<TreeNode> left = allPossibleFBT(i);
                     List<TreeNode> right = allPossibleFBT(n-i-1);
                     for(TreeNode l : left){
                         for(TreeNode r : right){
                              TreeNode newNode = new TreeNode(0);
                              newNode.left = l;
                              newNode.right = r;
                              answer.add(newNode);
                         }
                     }
                  }
              }
              map.put(n, answer);
          }
          return map.get(n);
    }
}