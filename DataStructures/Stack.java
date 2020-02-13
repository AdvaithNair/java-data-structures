package DataStructures;

public class Stack {
    private Node head;
    private Node current;

    class Node {
        private int data;
        private Node prev;

        private Node() {
            this.data = Integer.MIN_VALUE;
        }

        private Node(int data) {
            this.data = data;
        }
    }

    public Stack() {
        this.head = this.current = new Node();
        head.prev = null;
    }

    public Stack(int data) {
        this.head = this.current = new Node(data);
        head.prev = null;
    }

    //PUSH
    public void push(int data) {
        if(head.data == Integer.MIN_VALUE) {
            head.data = data;
        } else {
            Node next = new Node(data);
            next.prev = current;
            current = next;
        }
    }

    public void push(int[] data) {
        for(int i = 0; i < data.length; i++)
            push(data[i]);
    }

    //POP
    public int pop() {
        int popper = current.data;
        current = current.prev;
        return popper;
    }

    //PEEK
    public int peek() {
        return current.data;
    }

    //PRINT
    public void printStack() {
        Node next = current;
        System.out.print("Stack: ");
        while(next != null) {
            System.out.print(next.data + " ");
            next = next.prev;
        }
        System.out.println("");
    }
}
