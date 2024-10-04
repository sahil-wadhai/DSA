class PalindromInLL
{
    static class ListNode 
    {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public boolean isPalindrome(ListNode head) 
    {
        if(head==null||head.next==null)
        {
            return true;
        }
        ListNode mid = getMiddle(head);
        ListNode right = reverseList(mid.next); //right side of mid will be reversed
        mid.next = null; //separating left and right list

        ListNode left = head;
        boolean ans = true;
        while(left != null && right !=null)
        {
            if(left.val != right.val)
            {
                ans = false;
                break;
            }
            left = left.next;
            right = right.next;
        }
        //we need to undo changes made to the list , 
        //so re-reverse right side and attach left and right
        right = reverseList(right);
        mid.next = right;
        return ans;
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