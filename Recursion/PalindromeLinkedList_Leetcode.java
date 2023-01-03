package Recursion;

public class PalindromeLinkedList_Leetcode {


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
    public static ListNode reverse(ListNode head){

        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }



    public boolean isPalindrome(ListNode head) {
        
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
              if(fhalf.val != shalf.val) return false;
              fhalf = fhalf.next;
              shalf = shalf.next;
           }

          return true;
    }
}





}