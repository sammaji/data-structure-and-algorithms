package LinkedList;

public class SinglyLinkedList {

    public static class Node {
        private int value;
        private Node next;

        Node(int value) {
            this.value = value;
        }

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return this.value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNextNode() {
            return this.next;
        }

        public void setNextNode(Node next) {
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;

    public SinglyLinkedList() {
    }

    public SinglyLinkedList(int value) {
        this.addLast(value);
    }

    public SinglyLinkedList(int[] values) {
        for (int value : values) {
            this.addLast(value);
        }
    }

    public void add(int value, int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(
                    "Index " + index + " does not exist on LinkedList of size " + this.size);
        }

        if (index == 0) {
            this.addFirst(value);
            return;
        }

        if (index == this.size - 1) {
            this.addLast(value);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.getNextNode();
        }

        Node node = new Node(value, temp.getNextNode());
        temp.setNextNode(node);
    }

    public void addLast(int value) {
        Node nextNode = new Node(value);

        if (tail == null || head == null) {
            head = tail = nextNode;
            size++;
            return;
        }

        tail.next = nextNode;
        tail = nextNode;
        size++;
    }

    public void addFirst(int value) {
        Node nextNode = new Node(value);
        nextNode.setNextNode(this.head);
        head = nextNode;

        if (this.tail == null) {
            this.tail = this.head;
        }

        this.size++;
    }


    public void delete(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(index);
        }

        if (index == 0) {
            this.deleteFirst();
            return;
        }

        if (index == this.size -1 ) {
            this.deleteLast();
            return;
        }

        Node temp = head;
        for (int i=1; i<index; i++) {
            temp = temp.next;
        }

        Node nextNode = temp.next;
        temp.next = temp.next.next;
        nextNode.next = null;
    }

    public void deleteFirst() {
        if (head == null) {
            return;
        }

        Node currentFirst = head;
        head = currentFirst.next;
        currentFirst.next = null;
    }

    public void deleteLast() {
        if (head == null) {
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;

        while(temp.next.next != null) {
            temp = temp.next;
        }

        tail = temp;
        temp.next = null;
    }

    public int getHead() {
        return this.head.getValue();
    }

    public Node getHeadNode() {
        return this.head;
    }

    public int getTail() {
        return this.tail.getValue();
    }

    public int length() {
        return this.size;
    }

    public void display() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }

        System.out.print("END");
    }

    public int[] toArray() {
        int[] array = new int[this.size];

        int index = 0;
        Node current = this.head;

        while (current != null || index < this.size) {
            array[index] = current.getValue();
            current = current.getNextNode();
            index++;
        }

        return array;
    }
}
