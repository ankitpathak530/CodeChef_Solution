class MinStack {
    private class Node{
        int val;
        int min;
        Node next;
    
    private Node(int val, int min, Node next){
        this.val = val;
        this.min = min;
        this.next = next;
    }
    }

   
    private Node head;

    
    public MinStack() {
         
    }
    
    public void push(int val) {
        
        int min = head == null ? Integer.MAX_VALUE : head.min;
        Node newNode = new Node(val, Math.min(min, val), head);
        head = newNode;
    }

    
    public void pop() {
        head = head.next;    
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */