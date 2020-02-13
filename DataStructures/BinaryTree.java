package DataStructures;

public class BinaryTree {
    private Node root;
    private int count;
    private int test;

    private class Node{
        int data;
        int stacker;
        Node left, right;

        Node() {
            this.left = this.right = null;
            count = 0;
            stacker = 1;
        }

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
            count = 0;
            stacker = 1;
        }
    }

    public BinaryTree() {
        root = new Node();
    }

    public BinaryTree(int data) {
        root = new Node(data);
    }

    //INSERTION
    private Node insert(int value, Node node) {
        if (node == null)
            return new Node(value);

        if(value < node.data)
            node.left = insert(value, node.left);
        else if (value > node.data)
            node.right = insert(value,node.right);
        else if (value == node.data)
            node.stacker++;
        return node;

    }

    public void insert(int value) {
        root = insert(value, root);
    }

    public void insert(int[] values) {
        for(int i = 0; i < values.length; i++) {
            insert(values[i]);
        }
    }

    //FIND
    private boolean contains(int value, Node node) {
        if(node == null)
            return false;
        if(node.data == value)
            return true;
        return value < node.data
                ? contains(value, node.left)
                : contains(value, node.right);
    }

    public boolean contains(int value) {
        return contains(value, root);
    }

    private int findDepth(int value, Node node) {
        if(contains(value)) {
            if (node.data != value) {
                this.count++;
                if (value < node.data)
                    findDepth(value, node.left);
                else
                    findDepth(value, node.right);
            }
        }
        return this.count;
    }

    public int findDepth(int value) {
        return findDepth(value, root);
    }

    private Node findParentNode(int value, Node node) {
        if(contains(value)) {
            if (node.data != value && node != null) {
                if (value < node.data) {
                    if (value < node.left.data)
                        findParentNode(value, node.left.left);
                    else
                        findParentNode(value, node.left.right);
                } else {
                    if (value < node.right.data)
                        findParentNode(value, node.right.left);
                    else
                        findParentNode(value, node.right.right);
                }
            }
            return node;
        }
        else
            return null;
    }

    private int findSmallest(Node node) {
        return node.left == null ? root.data : findSmallest(root.left);
    }

    //DELETION
    private Node delete(int value, Node node) {
        if (node == null || !contains(value))
            return null;
        if (value == node.data){
            if (node.left == null && node.right == null)
                return null;
            if (node.right == null)
                return node.left;
            if (node.left == null)
                return node.right;
            int smallestValue = findSmallest(node.right);
            node.data = smallestValue;
            node.right = delete(smallestValue, node.right);
            return node;

        }
        if (node.data > value) {
            node.left = delete(value, node.left);
            return node;
        }
        node.right = delete(value, node.right);
        return node;
    }

    public void delete(int value) {
        root = delete(value, root);
    }


    //TRAVERSALS
    private void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left); //Left, Root, Right
            System.out.print(node.data + " ");
            traverseInOrder(node.right);
        }
    }

    public void traverseInOrder(String input) {
        System.out.print(input);
        traverseInOrder(root);
        System.out.println("");
    }

    private void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " "); //Root, Left, Right
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public void traversePreOrder() {
        System.out.print("Pre-Order Traversal: ");
        traversePreOrder(root);
        System.out.println("");
    }

    private void traversePostOrder(Node node) {
        if (node != null) {
            traversePreOrder(node.left); //Left, Right, Root
            traversePreOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    public void traversePostOrder() {
        System.out.print("Post-Order Traversal: ");
        traversePostOrder(root);
        System.out.println("");
    }

    public void traverseAll() {
        traverseInOrder("In-Order Traversal: ");
        traversePreOrder();
        traversePostOrder();
    }

    //PRINTS
    private String printTree(Node node) {
        if (node == null)
            return "N";
        return ("[" + printTree(node.left) + ", " + node.data + ", " + printTree(node.right) + "]");
    }

    public void printTree() {
        System.out.println("Tree: " + printTree(root));
    }

    private String printCounts(Node node) {
        if (node == null)
            return "N";
        return ("[" + printCounts(node.left) + ", " + node.stacker + ", " + printCounts(node.right) + "]");
    }

    public void printCounts() {
        System.out.println("Counts: " + printCounts(root));
    }

    //MISC
    private int childCount(Node node) {
        int count = 0;
        if(node == null)
            return 0;
        if(node.left != null)
            count++;
        if(node.right != null)
            count++;
        return count;
    }

    public int childCount() {
        return childCount(root.left.right);
    }

    public void sort(int[] array) {
        insert(array);
        traverseInOrder("Sorted: ");
    }

}
