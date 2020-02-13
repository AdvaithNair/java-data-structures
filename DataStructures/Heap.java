package DataStructures;

public class Heap {
    private int[] heap; //Heap element storage

    private int size; //Current Size
    private int maxSize; //Max Capacity

    private static final int FRONT = 1; //First element, as heap[0] is int min

    private boolean isMinHeap; //Check Heap Status

    public Heap(boolean isMinHeap) {
        this.maxSize = 100;
        this.size = 0; //Current Size is 0

        this.heap = new int[this.maxSize + 1]; //Extra element for int min at 0
        this.isMinHeap = isMinHeap;

        if(isMinHeap)
            this.heap[0] = Integer.MIN_VALUE;
        else
            this.heap[0] = Integer.MAX_VALUE;
    }

    public Heap(boolean isMinHeap, int maxSize) {
        this.maxSize = maxSize;
        this.size = 0; //Current Size is 0

        this.heap = new int[this.maxSize + 1]; //Extra element for int min at 0
        this.isMinHeap = isMinHeap;

        if(isMinHeap)
            this.heap[0] = Integer.MIN_VALUE;
        else
            this.heap[0] = Integer.MAX_VALUE;
    }

    //Return Node's Parent
    private int parent (int pos) {
        return pos / 2;
    }

    //Return Node's Left Child
    private int leftChild (int pos) {
        return 2 * pos;
    }

    //Return Node's Right Child
    private int rightChild (int pos) {
        return 2 * pos + 1;
    }

    //Checks Leaf Status (Anything in the second half)
    private boolean isLeaf(int pos) {
        return pos >= (this.size / 2) && pos <= this.size;
    }

    private void swap(int nodeOne, int nodeTwo) {
        int temp = this.heap[nodeOne];
        this.heap[nodeOne] = this.heap[nodeTwo];
        this.heap[nodeTwo] = temp;
    }

    //Heapifies Given Node
    private void minHeapify(int pos) {
        if (!isLeaf(pos)) {
            if (this.heap[pos] > this.heap[leftChild(pos)] || this.heap[pos] > this.heap[rightChild(pos)]) { //if children are bigger
                if (this.heap[leftChild(pos)] < this.heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    private void maxHeapify(int pos) {
        if (!isLeaf(pos)) {
            if (this.heap[pos] < this.heap[leftChild(pos)] || this.heap[pos] < this.heap[rightChild(pos)]) { //if children are bigger
                if (this.heap[leftChild(pos)] > this.heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    //Inserts Node and Adjusts Heap
    public void insert(int data) {
        if (this.size >= this.maxSize) {
            System.out.println("Error: Heap Overflow");
            return;
        }
        this.heap[++this.size] = data;
        int current = this.size;

        //Sink Down
        if(isMinHeap) {
            while (this.heap[current] < this.heap[parent(current)]) {
                swap(current, parent(current));
                current = parent(current);
            }
        } else {
            while (this.heap[current] > this.heap[parent(current)]) {
                swap(current, parent(current));
                current = parent(current);
            }
        }
    }

    //Inserts multiple elements
    public void insert(int[] data) {
        for(int i = 0; i < data.length; i++)
            insert(data[i]);
    }

    //Print Heap
    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print("[" + this.heap[2 * i] + " " + this.heap[i] + " " + this.heap[2 * i + 1] + "]");
            System.out.println();
        }
    }

    //Recursive Print
    private String printTree(int pos) {
        if(pos >= this.size)
            return Integer.toString(this.heap[pos]);
        return ("[" + printTree(2 * pos) + ", " + this.heap[pos] + ", " + printTree(2 * pos + 1) + "]");
    }

    //Public Call to Recursive Print
    public void printRecursive() {
        System.out.println("Min Heap: " + printTree(FRONT));
    }

    //Fully Heapifies
    public void minHeap() {
        for (int pos = (size / 2); pos >= 1; pos--) {
            minHeapify(pos);
        }
    }

    //Remove Node and Heapify
    public int remove() {
        int removed = this.heap[FRONT];
        this.heap[FRONT] = this.heap[size--];
        if(this.isMinHeap)
            minHeapify(FRONT);
        else
            maxHeapify(FRONT);
        return removed;
    }
}
