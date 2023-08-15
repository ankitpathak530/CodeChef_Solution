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
             
        ListNode smaller = new ListNode();
        ListNode smTemp = smaller;
        ListNode larger = new ListNode();
        ListNode lgTemp = larger;
        
        
        while(head != null){
            
            if(head.val < x){
                smTemp.next = new ListNode(head.val);
                smTemp = smTemp.next;
            }else{
                lgTemp.next = new ListNode(head.val);
                lgTemp = lgTemp.next;
            }
            head = head.next;
        }
       
        smTemp.next = larger.next;
       
        return smaller.next;
    }
}