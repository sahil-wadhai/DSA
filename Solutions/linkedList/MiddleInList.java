public class MiddleInList {
  static class ListNode 
  {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  static ListNode getMiddle(ListNode head)
  {
    if(head == null)
    {
      return null;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    //fast is one step ahead at start beacause if list size is even
    //there will be two middles so if we put fast ahead at start 
    //when loop ends slow will be at first middle 
    while(fast!=null && fast.next!=null)
    {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
}
