/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ReverseNodesInGroup
{
    static class ListNode 
    {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseKGroup(ListNode head, int k) 
    {
        if(head==null || head.next==null)
        {
            return head;
        }

        //Find Size of the list
        ListNode n = head;
        int size = 0;
        while(n!=null)
        {
            size++;
            n = n.next;
        }

        //keep calculting left and right to reverse part of linked list
        for(int i = k; i<=size ; i+=k)
        {
            int left = Math.abs(i-k)+1;
            int right = i;
            head = reverseBetween(head,left,right);
        }
        return head;
    }
    private ListNode reverseBetween(ListNode head, int left , int right)
    {
        if(left==right)
        {
            return head;
        }
        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;

        for(int i=1 ; i<left ; i++)
        {
            prev = curr;
            curr = curr.next;
        }
        ListNode justBefore = prev;
        ListNode newEnd = curr;

        prev = null;
        ListNode next = curr.next;
        for(int i=left ; i<right && next!=null ; i++)
        {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;
        newEnd.next=next;

        if(justBefore!=null)
        {
            justBefore.next = curr;
        }
        else
        {
            head = curr;
        }
        return head;
    }
}