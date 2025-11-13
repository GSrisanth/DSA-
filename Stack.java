
 public class Stack{

    //array to store elements
    private int [] arr;

    //maximum size of the array
    private int capacity;
    
    //index of top element
    private int top;
    
    //constructor
    public Stack(int cap){
        capacity = cap;
        arr = new int[capacity];
        top = -1;
    }

    //push operation
    public void push(int x){
        if(top == capacity-1){
            System.out.println("Stack overflow");
            return;
        }
        arr[++top] = x;

    }

    //pop operation 
    public int pop(){
        if(top== -1){
            System.out.println("Stack underflow");
            return -1;

        }
        return arr[top--];
    }

    //top or peek operation
    public int peek(){
        if(top == -1){
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[top];
    }

    //is Empty Operation
    public boolean isEmpty(){
        return top == -1;
    }

    //isFull operation
    public boolean isFull(){
        return top == capacity -1;
    }
 }

//main methood

 class Main{
    public static void main(String [] args){
        Stack st = new Stack(4);
        
        //pushingf operation
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);

        //popping one element
        System.out.println("Popped " + st.pop());
        
        //checking top element
        System.out.println("Top element is " + st.peek());

        //checking if stack is empty
        System.out.println("is the stack empty : " + (st.isEmpty() ? "yes" : "no") );

        //checking if stack is full
        System.out.println("is the Stack full : " + (st.isFull() ? "yes": "no") );


    }

 }