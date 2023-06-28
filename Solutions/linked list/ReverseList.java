class ReverseList
{
    static class ListNode 
    {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) 
    {
        if(head==null || head.next==null)
        {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;

        while(next != null)
        {
            curr.next = prev;
            prev = curr;
            curr = next;

            next = next.next;
        }
        //at the end of loop 'prev' is reversed list missing one element
        //'curr' points to last element of original list and 'curr.next' points to null
        //so to get complete reverse list we do, "curr.next = prev"
        curr.next = prev;
        return curr;
    } 
}