package LinkedList;

public class DoublyLinkedList {

    private int size;
    private Node head, tail;

    static class Node {
        private int value;
        private Node next;
        private Node prev;

        Node(int value) {
            this.value = value;
        }

        Node(int value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    public DoublyLinkedList() {
        this.size = 0;
    }

    /**
     * @param order - 0 means head to tail, 1 means tail to head
     */
    public void display(int order) {
        if (order == 0) {
            Node start = head;
            while (start != null) {
                System.out.print(start.value + " -> ");
                start = start.next;
            }
            System.out.println("TAIL");
            return;
        }

        Node start = tail;
        while (start != null) {
            System.out.print(start.value + " -> ");
            start = start.prev;
        }
        System.out.println("HEAD");
        return;
    }

    public void addFirst(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        size++;
    }

    public void addLast(int value) {
        Node newNode = new Node(value);

        if (tail == null) {
            head = tail = newNode;
            size++;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    public void add(int value, int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException(index);

        if (index == 0) {
            addFirst(value);
            return;
        }

        if (index == size - 1) {
            addLast(value);
            return;
        }

        // traverse from the start
        if (index <= (size / 2)) {
            Node temp = head;
            
            for (int i=1; i<index; i++) {
                temp = temp.next;
            }

            Node newNode = new Node(value, temp, temp.next);
            temp.next.prev = newNode;
            temp.next = newNode;
            
            size++;
        } else {
             Node temp = tail;
            
            for (int i=size-2; i>index; i++) {
                temp = temp.prev;
            }

            Node newNode = new Node(value, temp.prev, temp);
            temp.prev.next = newNode;
            temp.prev = newNode;
            
            size++;
        }
    }

}