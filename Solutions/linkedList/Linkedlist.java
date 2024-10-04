public class Linkedlist
{
    Node head;
    static class Node{
        int data;
        Node next;
        Node(int d)
        {
            this.data=d;
            next=null;
        }
    }

    void insert(int d)
    {
        Node n = new Node(d);
        n.next = null;
        if(this.head==null)
        {
            this.head = n;
        }
        else
        {
            Node p = this.head;
            while(p.next != null)
            {
                p = p.next;
            }
            p.next = n;
        }
    }

    void print()
    {
        Node p = this.head;
        while(p!=null)
        {
            System.out.println(p.data);
            p = p.next;
        }
    }
    public static void main(String[] args) {
        Linkedlist list = new Linkedlist();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.print();
    }
}