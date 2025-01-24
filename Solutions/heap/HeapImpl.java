import java.util.*;

public class HeapImpl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of heap");
        int n = sc.nextInt();
        MinHeap heap = new MinHeap(n);

        for(int i=0 ; i<n ; i++){
            heap.add(sc.nextInt());
            heap.print();
        }
        System.out.println("Pop element 1/0 : ");
        int c = sc.nextInt();
        while(c != 0){
            heap.pop();
            heap.print();
            c = sc.nextInt();
        }
        sc.close();
    }
}

class MinHeap{
    private int size;
    private ArrayList<Integer> heapTree;
    private int pointer;
    MinHeap(int size){
        this.size = size;
        this.heapTree = new ArrayList<>(size);
        pointer = 0;
    }
    private int getParent(int i){
        return (i-1)/2 >= 0 ? (i-1)/2 : -1;
    }
    private int getLeftChild(int i){
        return (i*2)+1 < pointer ? (i*2)+1 : -1; 
    }
    private int getRightChild(int i){
        return (i*2)+2 < pointer ? (i*2)+2 : -1; 
    }
    private void swap(int i1, int i2){
        int temp = heapTree.get(i1);
        heapTree.set(i1, heapTree.get(i2) );
        heapTree.set(i2, temp);
    }

    void add(int e){
        if(pointer >= size){
            System.out.println("Heap Capacity is full.");
            return;
        }
        heapTree.add(e);
        int temp = pointer;
        
        while( getParent(temp)>=0 && heapTree.get(getParent(temp)) > e ){
            swap(temp, getParent(temp));
            temp = getParent(temp);
        }
        this.pointer++;
    }

    int pop(){
        if(pointer==0){
            System.out.println("Heap is already empty.");
            return -1;
        }

        int res = this.peek();
        heapTree.set(0, heapTree.get(this.pointer-1));

        int temp = 0;
        while( ( getLeftChild(temp) != -1 && heapTree.get(temp) > heapTree.get(getLeftChild(temp) ) || 
        (getRightChild(temp)!= -1 && heapTree.get(temp)>heapTree.get(getRightChild(temp)) )) )
        {
            if( heapTree.get(getLeftChild(temp)) < heapTree.get(getRightChild(temp))){
                swap(temp, getLeftChild(temp));
                temp = getLeftChild(temp);
            }
            else{
                swap(temp, getRightChild(temp));
                temp = getRightChild(temp);
            }
        }
        pointer--;
        return res;
    }

    void print(){
        for(int i = 0; i<pointer ; i++){
            int e = heapTree.get(i);
            System.out.print(e + " ");
        }
        System.out.println();
    }

    int peek(){
        return heapTree.get(0);
    }
}