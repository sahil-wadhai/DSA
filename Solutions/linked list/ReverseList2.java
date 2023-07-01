class Solution 
{
    static class ListNode 
    {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) 
    {
        if(left==right || head==null) 
        {
            //it means no part is there to be reversed
            return head;
        }

        //placing pointing nodes at desired possition
        ListNode prev = null;
        ListNode curr = head;
        for(int i=1 ; curr!=null && i<left ; i++)
        {
            prev = curr;
            curr = curr.next;
        }
        ListNode justBefore = prev; //points to (left-1)th node
        ListNode newEnd = curr; //points to (left)th node

        //reversing
        prev=null;
        ListNode next = curr.next;
        for(int i=left; next != null && i<right ; i++)
        {
            curr.next=prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;
        //at this point requirred part is reversed
        //'curr' points to (right)th node
        //'next' points to (right+1)th node

        //combining reversed part with start and end of original list
        if(justBefore==null) head = curr;
        else justBefore.next = curr;

        newEnd.next = next;
        return head;
    }
    
}