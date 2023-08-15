/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        
        ListNode newHeadTemp = new ListNode();
        ListNode newHead = newHeadTemp;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null){
            if(fast.val < x){
                newHeadTemp.next = new ListNode(fast.val);
                newHeadTemp = newHeadTemp.next;
            }
            fast = fast.next;
        }
        
        while(slow != null){
              if(slow.val >= x){
                newHeadTemp.next = new ListNode(slow.val);
                newHeadTemp = newHeadTemp.next;
              }
            
                slow = slow.next;
        }
        
        return newHead.next;
    }
}