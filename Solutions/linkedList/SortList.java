class SortList
{
    static class ListNode 
    {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public ListNode mergeSortList(ListNode head) 
    {
        if(head == null || head.next==null)
        {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null; //separating left and right

        left = mergeSortList(left);
        right = mergeSortList(right);

        return merge(left,right);
    }
    private ListNode getMid(ListNode head)
    {
        if(head==null)
        {
            return null;
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
    private ListNode merge(ListNode list1, ListNode list2)
    {
        ListNode newHead = new ListNode();
        ListNode tail = newHead;
        while(list1 != null && list2 != null)
        {
            if(list1.val<=list2.val)
            {
                tail.next = list1;
                list1 = list1.next;
            }
            else
            {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        while(list1 != null)
        {
            tail.next = list1;
            list1 = list1.next;
            tail = tail.next;
        }
        while(list2 != null)
        {
            tail.next = list2;
            list2 = list2.next;
            tail = tail.next;
        }
        return newHead.next;
    }
}