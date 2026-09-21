import java.io.*;

public class DoublyLinkedList implements Serializable {
    Node head;
    Node tail;
    transient Node current;

    public void add(Employee emp) {
        Node newNode = new Node(emp);
        if (head == null) {
            head = tail = current = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Employee added successfully.");
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            temp.data.display();
            temp = temp.next;
        }
    }

    public void displayFirst() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        current = head;
        current.data.display();
    }

    public void displayLast() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }
        current = tail;
        current.data.display();
    }

    public void displayNext() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (current == null) current = head;
        else if (current.next != null) current = current.next;
        else System.out.println("(End of list reached)");
        current.data.display();
    }

    public void displayPrev() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (current == null) current = tail;
        else if (current.prev != null) current = current.prev;
        else System.out.println("(Beginning of list reached)");
        current.data.display();
    }

    public int getCount() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public Employee[] toArray() {
        int n = getCount();
        Employee[] arr = new Employee[n];
        Node temp = head;
        int i = 0;
        while (temp != null) {
            arr[i++] = temp.data;
            temp = temp.next;
        }
        return arr;
    }
}