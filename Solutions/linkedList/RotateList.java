class RotateList
{
    static class ListNode 
    {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public ListNode rotateRight(ListNode head, int k) 
    {
        if(head==null || head.next==null)
        {
            return head;
        }

        //finding size
        ListNode n = head;
        int size = 0;
        while(n!=null)
        {
            n = n.next;
            size++;
        }

        //rotations overlaps if k>=size ,
        //k is number of rotations
        k = k%size;
        if(k==0)
        {
            return head;
        }

        //placing node pointers at dessired possition
        ListNode prev = null;
        ListNode curr = head;
        for(int i=1; i<=size-k ; i++)
        {
            prev = curr;
            curr = curr.next;
        }
        prev.next = null; //to seperate parts

        //last step:As new head is curr, so update head 
        n = curr;
        while(n!=null && n.next!=null)
        {
            n = n.next;
        }
        n.next = head;
        head = curr;

        return head;
    }
}