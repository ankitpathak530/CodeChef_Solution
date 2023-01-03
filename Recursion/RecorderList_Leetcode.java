package Recursion;

public class RecorderList_Leetcode {


  //Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {

    /* Function to reverse the linked list */
    ListNode reverse(ListNode node)
    {
        ListNode prev = null;
        ListNode current = node;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
    public void reorderList(ListNode head) {
           
           ListNode slow = head, fast = head.next;
           
           while(fast != null && fast.next != null){
               slow = slow.next;
               fast = fast.next.next;
           }

           ListNode shalf = slow.next;
           slow.next = null;
           ListNode fhalf = head;

           //reverse secnod half
           shalf = reverse(shalf);

           while(shalf != null){
               ListNode fTemp = fhalf.next;
               fhalf.next = null; // 1st half next connection broken
               fhalf.next = shalf;

               ListNode sTemp = shalf.next;
               shalf.next = null; //  2nd half next connection broken
               shalf.next = fTemp;

               fhalf = fTemp;
               shalf = sTemp;
           }

    }
 
}







}