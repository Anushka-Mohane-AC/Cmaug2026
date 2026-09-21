import java.io.*;

public class Node implements Serializable {
    Employee data;
    Node prev;
    Node next;

    public Node(Employee data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}