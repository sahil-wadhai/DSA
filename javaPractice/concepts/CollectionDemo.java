import java.util.*;

public class CollectionDemo {
    public static void main(String[] args) {
        // ********** 1. ArrayList Operations (Dynamic Array) **********
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Apple"); // O(1) Amortized, O(n) Worst (if resize occurs)
        arrayList.add("Banana");
        arrayList.add("Cherry");
        System.out.println("ArrayList: " + arrayList);

        arrayList.set(1, "Blueberry"); // O(1)
        arrayList.remove("Cherry"); // O(n) (Shift required)
        System.out.println("ArrayList after update & remove: " + arrayList);
        System.out.println("Element at index 0: " + arrayList.get(0)); // O(1)

        // ********** 2. LinkedList Operations (Doubly Linked List) **********
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(10); // O(1)
        linkedList.add(20);
        linkedList.add(30);
        System.out.println("\nLinkedList: " + linkedList);

        linkedList.addFirst(5); // O(1)
        linkedList.addLast(40); // O(1)
        System.out.println("After addFirst & addLast: " + linkedList);

        linkedList.removeFirst(); // O(1)
        linkedList.removeLast(); // O(1)
        System.out.println("After removeFirst & removeLast: " + linkedList);

        System.out.println("First element: " + linkedList.getFirst()); // O(1)
        System.out.println("Last element: " + linkedList.getLast()); // O(1)

        // ********** 3. HashSet Operations **********
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Red"); // O(1) (Average), O(n) (Worst)
        hashSet.add("Green");
        hashSet.add("Blue");
        System.out.println("\nHashSet: " + hashSet);

        hashSet.remove("Green"); // O(1) (Average), O(n) (Worst)
        System.out.println("HashSet after removal: " + hashSet);
        System.out.println("Contains 'Red'? " + hashSet.contains("Red")); // O(1)

        // ********** 4. TreeSet Operations **********
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(50); // O(log n)
        treeSet.add(10);
        treeSet.add(30);
        System.out.println("\nTreeSet: " + treeSet);

        treeSet.remove(10); // O(log n)
        System.out.println("TreeSet after removal: " + treeSet);
        System.out.println("First element: " + treeSet.first()); // O(log n)

        // ********** 5. HashMap Operations **********
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "One"); // O(1) (Average), O(n) (Worst)
        hashMap.put(2, "Two");
        hashMap.put(3, "Three");
        System.out.println("\nHashMap: " + hashMap);

        hashMap.put(2, "Updated Two"); // O(1)
        hashMap.remove(3); // O(1)
        System.out.println("HashMap after update & remove: " + hashMap);
        System.out.println("Value for key 1: " + hashMap.get(1)); // O(1)

        // keySet(), values(), entrySet()
        System.out.println("Keys: " + hashMap.keySet()); // O(n)
        System.out.println("Values: " + hashMap.values()); // O(n)
        System.out.println("Entries: " + hashMap.entrySet()); // O(n)

        // ********** 6. TreeMap Operations **********
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(101, "A"); // O(log n)
        treeMap.put(102, "B");
        treeMap.put(103, "C");
        System.out.println("\nTreeMap: " + treeMap);

        treeMap.put(102, "Updated B"); // O(log n)
        treeMap.remove(103); // O(log n)
        System.out.println("TreeMap after update & remove: " + treeMap);
        System.out.println("Value for key 101: " + treeMap.get(101)); // O(log n)

        // ********** 7. Stack Operations (LIFO) **********
        Stack<String> stack = new Stack<>();
        stack.push("Alpha"); // O(1)
        stack.push("Beta");
        stack.push("Gamma");
        System.out.println("\nStack: " + stack);

        stack.pop(); // O(1)
        System.out.println("Stack after pop: " + stack);
        System.out.println("Top element: " + stack.peek()); // O(1)

        // ********** 8. Queue Operations (FIFO) **********
        Queue<String> queue = new LinkedList<>();
        queue.add("Item1"); // O(1)
        queue.add("Item2");
        queue.add("Item3");
        System.out.println("\nQueue: " + queue);

        queue.poll(); // O(1)
        System.out.println("Queue after poll: " + queue);
        System.out.println("Front element: " + queue.peek()); // O(1)

        // ********** 9. PriorityQueue Operations (Min Heap) **********
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(100); // O(log n)
        priorityQueue.add(50);
        priorityQueue.add(75);
        System.out.println("\nPriorityQueue: " + priorityQueue);

        priorityQueue.poll(); // O(log n)
        System.out.println("PriorityQueue after poll: " + priorityQueue);
        System.out.println("Top priority element: " + priorityQueue.peek()); // O(1)

        // ********** 10. Double-Ended Queue (Deque) Operations **********
        Deque<String> deque = new LinkedList<>();
        deque.addFirst("Front"); // O(1)
        deque.addLast("Back"); // O(1)
        deque.addFirst("NewFront"); // O(1)
        deque.addLast("NewBack"); // O(1)
        System.out.println("\nDeque: " + deque);

        deque.removeFirst(); // O(1)
        deque.removeLast(); // O(1)
        System.out.println("After removeFirst & removeLast: " + deque);

        System.out.println("First Element: " + deque.getFirst()); // O(1)
        System.out.println("Last Element: " + deque.getLast()); // O(1)
    }
}
