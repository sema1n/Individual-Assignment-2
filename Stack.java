package assignment.singlylinkedlist;

public class Stack {
	// Class representing a Stack using a linked list structure

	    // Inner class to represent each node in the stack
	    private static class Node {
	        private int data; // Stores the data of the node
	        private Node next; // Reference to the next node in the stack

	        // Constructor to initialize the node with data
	        private Node(int data) {
	            this.data = data;
	            this.next = null; // Initially, the next node is null
	        }
	    }

	    private Node top; // Reference to the top of the stack

	    // Constructor to initialize the stack
	    public Stack() {
	        this.top = null; // Initially, the stack is empty
	    }

	    // Method to push an element onto the stack
	    public void push(int data) {
	        Node newNode = new Node(data);
	        newNode.next = top; // Link the new node to the current top
	        top = newNode; // Update the top to the new node
	    }

	    // Method to pop an element from the stack
	    public int pop() {
	        if (top == null) {
	            throw new RuntimeException("Stack is empty. Cannot pop."); // Throw an exception if the stack is empty
	        }
	        int data = top.data; // Get the data from the top node
	        top = top.next; // Update the top to the next node
	        return data; // Return the popped data
	    }

	    // Method to peek at the top element of the stack without removing it
	    public int peek() {
	        if (top == null) {
	            throw new RuntimeException("Stack is empty. Cannot peek."); // Throw an exception if the stack is empty
	        }
	        return top.data; // Return the data from the top node
	    }

	    // Method to check if the stack is empty
	    public boolean isEmpty() {
	        return top == null; // Return true if the top is null, otherwise false
	    }

	    // Main method for testing the stack operations
	    public static void main(String[] args) {
	        Stack stack = new Stack(); // Create a new stack
	        stack.push(10); // Push 10 onto the stack
	        stack.push(20); // Push 20 onto the stack
	        stack.push(30); // Push 30 onto the stack

	        // Display the top element
	        System.out.println("Top element is: " + stack.peek()); // Should print 30

	        // Pop an element and display it
	        System.out.println("Popped element is: " + stack.pop()); // Should print 30

	        // Display the top element
	        System.out.println("Top element is: " + stack.peek()); // Should print 20

	        stack.pop(); // Pop 20
	        stack.pop(); // Pop 10

	        // Check if the stack is empty
	        System.out.println("Is stack empty? " + stack.isEmpty()); // Should print true
	    }
	}
