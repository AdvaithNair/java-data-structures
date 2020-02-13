package DataStructures;

public class Queue {
    private Node head;
    private Node current;
    int size;

    class Node{
        int data;
        Node prev;

        public Node (Node prev) {
            this.prev = prev;
        }

        public Node (int data, Node prev) {
            this.data = data;
            this.prev = prev;
        }
    }

    public Queue() {
        head = new Node(null);
        current = head;
        size = 0;
    }

    public Queue(int data) {
        head = new Node(data, null);
        current = head;
        size = 1;
    }

    public void add(int data) {
        if (isEmpty()) {
            head = new Node(data, null);
            current = head;
        }
        else{
            Node next = new Node(data, current);
            current = next;
        }
        size++;
    }

    public int remove() {
        if(!isEmpty()) {
            int popVal = head.data;
            Node travel = this.current;
            for(int i = 0; i < size - 2; i++) {
                travel = travel.prev;
            }
            travel.prev = null;
            head = travel;
            size--;
            return popVal;
        }
        else {
            System.out.println("Error: Stack Underflow");
            return 0;
        }
    }


    public int element() {
        if(!isEmpty())
            return head.data;
        System.out.println("Error: Stack Underflow");
        return 0;
    }

    public int getSize(){
        return this.size;
    }

    public void printQueue() {
        Node travel = this.current;
        System.out.print("Queue: ");
        while(travel != null) {
            System.out.print(travel.data + " ");
            travel = travel.prev;
        }
        System.out.println("");
    }

    private boolean isEmpty () {
        return (size == 0);
    }
}
