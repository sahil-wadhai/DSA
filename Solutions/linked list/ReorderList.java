class ReorderList
{
    static class ListNode 
    {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    
    public void reorderList(ListNode head) 
    {
        if(head==null||head.next==null)
        {
            return;
        }
        ListNode mid = getMiddle(head);
        ListNode right = reverseList(mid.next); //right side of mid will be reversed

        //separating left and right list
        mid.next = null; 
        ListNode left = head;

        ListNode newHead = new ListNode();
        ListNode tail = newHead;
        
        //merge nodes of left and right one-by-one
        int turn=1;
        while(left != null && right !=null)
        {
            if(turn%2==1)//odd
            {
                tail.next = left;
                left = left.next;
            }
            else//even
            {
                tail.next = right;
                right = right.next;
            }
            turn++;
            tail=tail.next;
        }
        
        //now add remaining elements in new reordered list
        while(left != null)
        {
            tail.next = left;
            left = left.next;
            tail=tail.next;
        }
        while(right != null)
        {
            tail.next = right;
            right = right.next;
            tail=tail.next;
        }

        //update head and return
        head = newHead.next;
        return;
    }
    
    private ListNode getMiddle(ListNode head)
    {
        if(head==null || head.next==null)
        {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverseList(ListNode head)
    {
        if(head==null || head.next==null)
        {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;

        while(next!=null)
        {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;
        return curr;
    }
}
