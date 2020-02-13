package DataStructures;

public class LinkedList {
    private Node head; //first node
    private Node current; //most recent node
    private int size; //updaing size of list

    class Node {
        private int data;
        private Node prev; //pointer to prev node, head has null pointer

        public Node (int data, Node prev) {
            this.data = data;
            this.prev = prev;
        }
    }

    public LinkedList() {
        this.head = this.current = new Node(0, null); //essentially null head/current node
        size = 0; //no data passed in
    }

    public LinkedList(int data) {
        this.head = this.current = new Node(data, null); //head node with data, also updating it to current as well
        size = 1; //size one because of data
    }

    //ADD
    public void add(int data) {
        Node added = new Node(data, this.current); //creates new node linking to current
        this.current = added; //current is updated to this added array
        size++; //increment size when added
    }

    public void add(int[] data) {
        for(int i = 0; i < data.length; i++)
            add(data[i]); //add every element in the array
    }

    public void insert(int data, int index) {
        Node traveller; //traversal node

        if(index < this.size && index >= 1) {
            traveller = current; //insert is the current now
            for(int i = 1; i < this.size - index; i++)
                traveller = traveller.prev; //for every element up until, move to the next one
            Node added = new Node(data, traveller.prev); //add the new node
            traveller.prev = added;//link the node before to the new node
        } else if (index == 0) {
            traveller = new Node(data, null);
            this.head.prev = this.head = traveller; //make the new node the head and link accordingly
        } else if (index == this.size) {
            traveller = new Node(data, current);
            this.current = traveller; //make the new node the current and link accordingly
        } else
            System.out.println("Error: Value Not Found");
    }

    //DELETE
    public void deleteLast() {
        this.current = this.current.prev; //the new current is the previous one
        size--; //decrement size for deletion
    }

    public void deleteValue(int data) {
        if (current.data == data)
            deleteLast(); //delete last element if the last element corresponds with the value
        else {
            Node current = this.current; //current traversal node
            Node next = this.current.prev; //next traversal node (one down from current)
            while(next != null && next.data != data) {
                current = next;
                next = next.prev; //while the data isn't found or reach the head, move both traversal nodes down one
            } if (next.data == data) {
                current.prev = next.prev;
                next.prev = null; //if the loop exits due to the data matching up, delete the current node
                size--; //decrement
            } else
                System.out.println("Error: Value Not Found");
        }
    }

    public void deleteAt(int index) {
        Node traveller = this.current; //traversal node is current

        if (index >= 0 && index < size - 1) {
            for(int i = 2; i < size - index; i++)
                traveller = traveller.prev; // move traversal the amount of elements
            traveller.prev = traveller.prev.prev; // delete the node before the traversal node by skipping it in the chain
            size--;
        } else if (index == size - 1)
            deleteLast(); //if last element, delete it
        else
            System.out.println("Error: Value Not Found");

    }

    //GET VALUE
    public int get(int index) {
        Node traveller = this.current; //traversal node

        if (index >= 0 && index < size) {
            for(int i = 1; i < size - index; i++)
                traveller = traveller.prev; //travel to the indicated node
            return traveller.data;
        } else {
            System.out.println("Error: Value Not Found");
            return 0; //error prompt
        }
    }

    //PRINT
    public void printList() {
        Node traveller = this.current; //traversal node

        System.out.print("List: ");
        while (traveller != null) {
            System.out.print(traveller.data + " ");
            traveller = traveller.prev; //while traveller hasn't reached the head, print the data and decrement nodes
        } System.out.println("");
    }

    //SIZE
    public int getSize(){
        return this.size; //returns the current size of the array
    }
}