class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Create a dummy node to simplify edge cases.
        ListNode dummyHead = new ListNode(-1);

        // Connect the dummy node to the original head.
        dummyHead.next = head;
        
        ListNode prev = dummyHead;  // Pointer to the node just before 'left subList'.
        ListNode curr = dummyHead.next;  // Pointer to the 'left sublist' node.

        int i = 1;
        while (i < left) {
            prev = curr;
            curr = curr.next;
            i++;
        }
        
        ListNode firstPartLastNode = prev;  // Node before the reversed section.

        // Reverse the nodes between 'left' and 'right'.
        while (i <= right) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
            i++;
        }

        // Connect the reversed section back to the original list.
        firstPartLastNode.next.next = curr;
        firstPartLastNode.next = prev;

        // Return the modified list.
        return dummyHead.next;
    }
}
