package assignment.singlylinkedlist;

// Node class to represent each element in the linked list
class Node {
    int value; // Stores the data of the node
    Node next; // Reference to the next node in the list

    public Node(int value) {
        this.value = value;
        this.next = null; // Initially, the next node is null
    }
}

// SinglyLinkedList class to manage the linked list operations
class SinglyLinkedList {
    private Node head; // Reference to the head of the list

    public SinglyLinkedList() {
        this.head = null; // Initially, the head is null
    }

    // Method to insert a new node at the end of the linked list
    public void insert(int value) {
        Node newNode = new Node(value);
        if (head == null) { // If the list is empty, set the new node as the head
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) { // Traverse to the end of the list
            temp = temp.next;
        }
        temp.next = newNode; // Append the new node at the end
    }

    // Method to insert a node at a specified position in the list
    public void insertAtPos(int value, int pos) {
        Node newNode = new Node(value);
        // Insert at the head if the position is 0
        if (pos == 0) {
            newNode.next = head;
            head = newNode; // Update head to point to the new node
            return;
        }
        // Traverse the list to find the position to insert
        Node current = head;
        int currentPosition = 0;
        while (current != null && currentPosition < pos - 1) {
            current = current.next;
            currentPosition++;
        }
        // If the position is out of bounds
        if (current == null) {
            System.out.println("Position out of bounds");
            return;
        }
        // Insert the new node at the specified position
        newNode.next = current.next;
        current.next = newNode;
    }

    // Method to delete a node at a specified position in the list
    public void deleteAtPosition(int position) {
        // If the list is empty or the position is invalid
        if (head == null || position < 0) {
            System.out.println("Position out of bounds");
            return;
        }
        // If the position is 0, delete the head node
        if (position == 0) {
            head = head.next; // Update head to point to the next node
            return;
        }
        // Traverse the list to find the node just before the target position
        Node current = head;
        for (int i = 0; i < position - 1; i++) {
            if (current == null || current.next == null) {
                System.out.println("Position out of bounds");
                return;
            }
            current = current.next;
        }
        // If the next node is null, the position is out of bounds
        if (current.next == null) {
            System.out.println("Position out of bounds");
            return;
        }
        // Delete the node at the specified position by updating the link
        current.next = current.next.next;
    }

    // Method to delete the node that occurs after a given node in the list
    public void deleteAfterNode(Node givenNode) {
        if (givenNode == null || givenNode.next == null) { // Check if the given node or its next is null
            System.out.println("Given node is null or it is the last node.");
            return;
        }
        Node nodeToDelete = givenNode.next;
        givenNode.next = nodeToDelete.next; // Skip the node to be deleted
        nodeToDelete = null; // This will delete the node from memory
    }

    // Method to search for a node with a specific value in the list
    public boolean searchNode(int value) {
        Node temp = head; // Start from the head node
        while (temp != null) { // Traverse the list
            if (temp.value == value) {
                return true; // Node with the specified value found
            }
            temp = temp.next;
        }
        return false; // Node with the specified value not found
    }

    // Method to display the linked list
    public void printList() {
        Node current = head; // Start from the head node
        while (current != null) { // Loop through the list until the end
            System.out.print(current.value + " -> "); // Print the data of the current node
            current = current.next; // Move to the next node
        }
        System.out.println("null"); // Indicate the end of the list
    }

    // Main method to test the linked list methods
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        // Insert nodes at various positions
        list.insertAtPos(0, 0); // Insert at the head
        list.insertAtPos(1, 1); // Insert value 1 at position 1
        list.insertAtPos(2, 2); // Insert value 2 at position 2
        list.insertAtPos(3, 3); // Insert value 3 at position 3
        list.insertAtPos(4, 4); // Insert value 4 at position 4
        list.insertAtPos(-1, 0); // Insert value -1 at position 0 (new head)

        // Print the list after insertions
        System.out.println("List after insertions:");
        list.printList(); // Expected output: -1 -> 0 -> 1 -> 2 -> 3 -> 4 -> null

        // Search for a node with value 3
        int valueToSearch = 3;
        boolean found = list.searchNode(valueToSearch);
        System.out.println("Node with value " + valueToSearch + " found: " + found); // Expected output: true

        // Delete node at position 3
        list.deleteAtPosition(3);
        System.out.println("List after deleting node at position 3:");
        list.printList(); // Expected output: -1 -> 0 -> 1 -> 3 -> 4 -> null

        // Add more nodes
        list.insert(5);
        list.insert(6);
        System.out.println("List after adding more nodes:");
        list.printList(); // Expected output: -1 -> 0 -> 1 -> 3 -> 4 -> 5 -> 6 -> null

        // Delete the node after the node with value 1
        Node node = list.head;
        while (node != null && node.value != 1) { // Find the node with value 1
            node = node.next;
        }
        list.deleteAfterNode(node); // Delete the node after the found node
        System.out.println("List after deleting node after node with value 1:");
        list.printList(); // Expected output: -1 -> 0 -> 1 -> 4 -> 5 -> 6 -> null
    }
}
