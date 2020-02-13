package DataStructures;

public class DoublyLinkedList {
    private Node head; //left side of list
    private Node current; //right side of list
    private int size; //size of list

    private class Node {
        int data;
        Node prev;
        Node next;

        private Node(Node prev, Node next) {
            this.data = Integer.MIN_VALUE;
            this.prev = prev;
            this.next = next;
        }

        private Node(int data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    public DoublyLinkedList() {
        this.head = this.current = new Node(null, null);
        //this.current = this.head;
        size = 0;
    }

    public DoublyLinkedList(int data) {
        this.head = this.current = new Node(data, null, null);
        //head.prev = head.next = current.prev = current.next = null;
        size = 1;
    }

    public DoublyLinkedList(int[] data) {
        this.head = this.current = new Node( null, null);
        add(data);
    }

    //ADD
    public void add(int data) {
        if(size == 0) {
            this.head.data = data;
        } else {
            Node added = new Node(data, this.current, null);
            this.current.next = added;
            this.current = added;
        }
        this.size++;
    }

    public void add(int[] data) {
        for(int i = 0; i < data.length; i++)
            add(data[i]);
    }

    public void addFront(int data) {
        if(size == 0) {
            this.head.data = data;
        } else {
            Node added = new Node(data, null, head);
            this.head.prev = added;
            this.head = added;
        }
        this.size++;
    }

    public void addFront(int[] data) {
        for(int i = 0; i < data.length; i++)
            addFront(data[i]);
    }

    public void insert(int data, int index) {
        if (index < this.size && index > 0) {
            Node traveller = this.head;
            for(int i = 0; i < index-1; i++)
                traveller = traveller.next;
            Node added = new Node(data, traveller, traveller.next);
            traveller.next.prev = traveller.next = added;
            size++;
        } else if (index == 0)
            addFront(data);
        else if (index == size)
            add(data);
        else
            System.out.println("Error: Out of Bounds");
    }

    //DELETE
    public void deleteLast() {
        this.current.prev.next = null;
        this.current = this.current.prev;
        this.size--;
    }

    public void deleteFirst() {
        this.head.next.prev = null;
        this.head = this.head.next;
        this.size--;
    }

    public void delete(int data) {
        Node traveller = this.current;

        while(traveller.data != data && traveller != null)
            traveller = traveller.prev;
        if (traveller.data == data) {
            traveller.prev.next = traveller.next;
            traveller.next.prev = traveller.prev;
            this.size--;
        } else {
            System.out.println("Error: Value Not Found");
        }
    }

    //PRINT
    public void print() {
        Node traveller = this.head;
        System.out.print("List: ");
        while(traveller != null){
            System.out.print(traveller.data + " ");
            traveller = traveller.next;
        }
        System.out.println("");
    }

    public void printReverse() {
        Node traveller = this.current;
        System.out.print("Reverse List: ");
        while(traveller != null) {
            System.out.print(traveller.data + " ");
            traveller = traveller.prev;
        }
        System.out.println("");
    }

    //GET
    public int get(int index) {
        if (index < this.size - 1 && index > 0) {
            Node traveller = this.head;
            for(int i = 0; i < index; i++)
                traveller = traveller.next;
            return traveller.data;
        } else if (index == 0) {
            return head.data;
        } else if (index == size -1) {
            return current.data;
        } else {
            System.out.println("Error: Out of Bounds");
            return 0;
        }
    }

    //SIZE
    public int getSize() {
        return this.size;
    }
}
