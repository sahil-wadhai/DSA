class CycleInList
{
    static class ListNode 
    {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    /*
      Algorithm : slow pointer and fast pointer concept 
      slow pointer - moves one step forward at time
      fast pointer - moves two step forward at a time 

      if fast pointer and slow pointer meets at a point it means cycle is present
      note: to understand it draw circular linkedlist and try the algorithm
    */
    public boolean hasCycle(ListNode head) 
    {
        ListNode slow = head;
        ListNode fast = head;
        do
        {
            if(fast==null || fast.next==null)
            {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }while(slow!=fast);
        return true;
    }
}