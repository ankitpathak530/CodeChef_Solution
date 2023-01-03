package Recursion;

import java.util.*;



  // Definition for a binary tree node.
  class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
   }
  
class LevelBinaryTreeZigZag {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        if(root == null) return result;
        
        Stack<TreeNode> mStack = new Stack<>();
        Stack<TreeNode> cStack = new Stack<>();
        int level = 1;

        mStack.push(root);

        while(!mStack.isEmpty()){
             TreeNode node = mStack.pop();
             if(node != null)
             {
                list.add(node.val);
            
                  if(level % 2 == 0){
                      if(node.right != null)
                        cStack.push(node.right);
                      if(node.left != null)
                        cStack.push(node.left); 
                  }else{
                      if(node.left != null)
                        cStack.push(node.left); 
                      if(node.right != null)
                        cStack.push(node.right);
                  }    
             } 


             if(mStack.isEmpty())
             {
                 level++;
                 mStack = cStack;
                 cStack = new Stack<>();
                 result.add(list);
                 list = new ArrayList<Integer>();
             }

        }


         return result;
    }
}