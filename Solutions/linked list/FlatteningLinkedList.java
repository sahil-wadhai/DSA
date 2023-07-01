class FlatteningLinkedList
{
    class ListNode
    {
        int data;
        ListNode next;
        ListNode bottom;
        
        ListNode(int d)
        {
          data = d;
          next = null;
          bottom = null;
        }
    }

    public ListNode flatten(ListNode root)
    {
        // Your code here
        if(root.next==null)
        {
            return root;
        }
        ListNode l1 = root;
        ListNode l2 = root.next;
        while(l2!=null)
        {
            l1 = merge(l1,l2);
            l2 = l2.next;
        }
        return l1;
    }
    
    private ListNode merge(ListNode list1  , ListNode list2)
    {
        ListNode newHead = new ListNode(0);
        ListNode tail = newHead;
        
        while(list1!=null && list2!=null)
        {
            if(list1.data<=list2.data)
            {
                tail.bottom = list1;
                list1 = list1.bottom;
            }
            else
            {
                tail.bottom = list2;
                list2 = list2.bottom;
            }
            tail = tail.bottom;
        }
        if(list1!=null)
        {
            tail.bottom = list1;
        }
        if(list2!=null)
        {
            tail.bottom = list2;
        }
        return newHead.next;  
    }
}