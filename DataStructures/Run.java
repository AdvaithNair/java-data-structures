package DataStructures;

public class Run {
    public static void main(String[] args) {
        //LinkedList Run
        /*
        System.out.println("--------------------------------------------");
        System.out.println("Linked List Implementation:");
        System.out.println("--------------------------------------------");
        LinkedList list = new LinkedList(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.printList();
        System.out.println("Size: " + list.getSize());
        list.deleteLast();
        list.printList();
        list.deleteValue(4);
        list.printList();
        list.deleteValue(2);
        list.printList();
        list.deleteAt(1);
        list.printList();
        System.out.println("Size: " + list.getSize());
        System.out.println("Value at Index 2: " + list.get(2));
        list.insert(4, 4);
        list.printList();
        */

        //Doubly LinkedList Run
        /*
        System.out.println("\n--------------------------------------------");
        System.out.println("Doubly Linked List Implementation:");
        System.out.println("--------------------------------------------");
        int[] data1 = {3, 2, 4};
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(data1);
        doublyLinkedList.add(2);
        doublyLinkedList.addFront(9);
        doublyLinkedList.print();
        doublyLinkedList.printReverse();
        doublyLinkedList.deleteLast();
        doublyLinkedList.print();
        doublyLinkedList.deleteFirst();
        doublyLinkedList.print();
        doublyLinkedList.delete(2);
        doublyLinkedList.print();
        int[] data2 = {7, 9, 8};
        doublyLinkedList.add(data2);
        doublyLinkedList.print();
        System.out.println("Size: " + doublyLinkedList.getSize());
        doublyLinkedList.insert(1, 5);
        doublyLinkedList.print();
        System.out.println("Size: " + doublyLinkedList.getSize());
        System.out.println("Value At Index 5: " + doublyLinkedList.get(5));
        */

        //Array Stack Run
        /*
        System.out.println("\n--------------------------------------------");
        System.out.println("Array Stack Implementation:");
        System.out.println("--------------------------------------------");
        ArrayStack arrayStack = new ArrayStack(3);
        arrayStack.push(1);
        int[] data3 = {3, 2, 4};
        arrayStack.push(data3);
        arrayStack.printStack();
        System.out.println("\tPeek: " + arrayStack.peek());
        arrayStack.printStack();
        System.out.println("\tSize: " + arrayStack.getSize());
        System.out.println("\tPopped Value: " + arrayStack.pop());
        arrayStack.printStack();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        System.out.println("\tPeek: " + arrayStack.peek());
        arrayStack.printStack();


        //Stack Run

        System.out.println("\n--------------------------------------------");
        System.out.println("Stack Implementation:");
        System.out.println("--------------------------------------------");
        Stack stack = new Stack();
        stack.push(2);
        stack.push(3);
        int[] data4 = {4, 2, 3, 4};
        stack.push(data4);
        System.out.println("Popped: " + stack.pop());
        stack.printStack();
        System.out.println("Peek: " + stack.peek());


        //Queue Run

        System.out.println("\n--------------------------------------------");
        System.out.println("Queue Implementation:");
        System.out.println("--------------------------------------------");
        Queue q = new Queue(3);
        q.add(4);
        q.add(6);
        q.add(7);
        q.printQueue();
        System.out.println("\tSize: " + q.getSize());
        q.remove();
        q.printQueue();
        q.remove();
        System.out.println("\tElement: " + q.element());
        q.printQueue();
        System.out.println("\tSize: " + q.getSize());


        //Binary Tree Run

        System.out.println("\n--------------------------------------------");
        System.out.println("Binary Tree Implementation:");
        System.out.println("--------------------------------------------");
        int[] data5 = {0, 1, 6, 7, 3, 4, 3};
        BinaryTree bTree = new BinaryTree(5);
        bTree.insert(2);
        bTree.insert(data5);
        bTree.traverseAll();
        bTree.printTree();
        bTree.printCounts();
        System.out.println("Does Tree Contain 2: " + bTree.contains(2));
        System.out.println("How Far in the Tree is 4: " + bTree.findDepth(4));
        System.out.println("Root Children: " + bTree.childCount());
        bTree.delete(6);
        bTree.printTree();

        BinaryTree sorter = new BinaryTree();
        sorter.sort(data5);


        //Trie Run

        System.out.println("\n--------------------------------------------");
        System.out.println("Trie Implementation:");
        System.out.println("--------------------------------------------");
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("world");
        trie.searchWord("wor");
        trie.searchWord("world");
        trie.searchWord("trie");
        trie.searchFragment("wor");
        trie.searchFragment("world");
        trie.searchFragment("trie");
*/
        //Min Heap Run
        System.out.println("\n--------------------------------------------");
        System.out.println("Min Heap Implementation:");
        System.out.println("--------------------------------------------");
        Heap minHeap = new Heap(true, 10);
        int[] input = {10, 30, 15, 5};
        minHeap.insert(input);
        minHeap.print();
        minHeap.printRecursive();
        minHeap.remove();


        //Max Heap Run
        System.out.println("\n--------------------------------------------");
        System.out.println("Max Heap Implementation:");
        System.out.println("--------------------------------------------");
        Heap maxHeap = new Heap(true, 10);
        int[] input2 = {10, 30, 15, 5};
        minHeap.insert(input);
        minHeap.print();
        //minHeap.printRecursive();
        minHeap.remove();
    }
}
