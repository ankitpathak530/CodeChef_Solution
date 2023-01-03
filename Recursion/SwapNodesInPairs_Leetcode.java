package Recursion;

public class SwapNodesInPairs_Leetcode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//  Definition for singly-linked list.
 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
	
	// swapping using recursion process
	public ListNode swapPairsRecursion(ListNode head) {

        if(head == null)
            return head;    
   
        if(head.next != null)
            swapPairsRecursion(head.next.next);
      
         //swapping
         if(head.next != null){
            int tempVal = head.val;
            head.val = head.next.val;
            head.next.val = tempVal;}
            
        return head;
    }
	
	
	
	
	// swapping using iterative process
    public ListNode swapPairsIterative(ListNode head) {

         ListNode temp = head;
         if(temp == null) return head;

         while(temp.next != null){
   
            int val = temp.next.val;
        
           //swapping
            temp.next.val = temp.val;
            temp.val = val;
                 
            if(temp.next != null)  temp = temp.next;
            if(temp.next != null)  temp = temp.next;
         }
         return head;
    }
}