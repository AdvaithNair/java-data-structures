package DataStructures;

//This Stack is Array Based
public class ArrayStack {
    private int[] array;
    private int top;
    private int capacity;

    public ArrayStack () {
        array = new int[1000];
        capacity = 1000;
        top = -1;
    }

    public ArrayStack (int size) {
        array = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int data) {
        if(!isFull())
            array[++this.top] = data;
        else
            System.out.println("Error: Stack Overflow");
    }

    public void push(int[] data) {
        for(int i = 0; i < data.length; i++)
            push(data[i]);
    }

    public int pop() {
        if(!isEmpty()) {
            int popVal = array[this.top];
            array[this.top--] = 0;
            return popVal;
        }
        else {
            System.out.println("Error: Stack Underflow");
            return 0;
        }
    }

    public int pop(int times) {
        int value = 0;
        for (int i = 0; i < times; i++)
            value = pop();
        return value;
    }

    public int peek() {
        if(!isEmpty())
            return array[this.top];
        System.out.println("Error: Stack Underflow");
        return 0;
    }

    public void clear() {
        while(!isEmpty())
            array[this.top--] = 0;
    }

    public int getSize(){
        return this.top + 1;
    }

    public void printStack() {
        System.out.print("Stack: ");
        for(int i = 0; i < getSize(); i++) {
            System.out.print(this.array[i] + " ");
        }
        System.out.println("");
    }

    private boolean isEmpty () {
        return (top < 0);
    }

    private boolean isFull() {
       return (top == this.capacity - 1);
    }
}
