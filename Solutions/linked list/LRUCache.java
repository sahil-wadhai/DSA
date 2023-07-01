/*
  get :
  -> get the Node containing data for the key.
  -> put the Node in front of the 'head'
  -> if key does not exist return -1

  put:
  -> If putting new node breaks the capacity, remove least recently used node
  -> least recently node is the node most nearer to 'tail'
  -> Make a new node and put it in the the linked list

  Note:
    To make quick access to nodes,Hashmap is used
*/
import java.util.*;
class LRUCache 
{
    static class ListNode
    {
        int key;
        int value;
        ListNode prev;
        ListNode next;
        ListNode()
        {
            this.prev = null;
            this.next = null;
        }
        ListNode(int key , int value)
        {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    
    int capacity;
    HashMap<Integer,ListNode> map;
    ListNode head;
    ListNode tail; 
    public LRUCache(int capacity) 
    {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) 
    {
        if(!map.containsKey(key))
        {
            return -1;
        }
        ListNode node = this.map.get(key);
        int value = node.value;

        this.remove(key); //remove node from its current possition
        
        this.put(key,value);//put the node in the front of 'head'
        return value;
    }
    
    public void put(int key, int value) 
    {
        //makes new node and puts it in front of head
        if(map.containsKey(key))
        {
            this.remove(key);
        }
        if(this.map.size()>=this.capacity)
        {
            //if capacity breaks remove least recently used node
            ListNode leastRecent = this.tail.prev;
            this.remove(leastRecent.key);
        }

        ListNode node = new ListNode(key,value);

        node.prev = head;
        node.next = head.next;
        this.head.next.prev = node;
        this.head.next = node;
        this.map.put(key,node);
    }

    private void remove(int key) //function for erasing the node
    {
        if(!map.containsKey(key))
        {
            return;
        }
        ListNode node = this.map.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.prev = null;
        node.next = null;
        this.map.remove(key);
    }
}


/**
 * Your LRUCache example:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */