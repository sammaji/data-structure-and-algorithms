package trees;

import java.util.LinkedList;
import java.util.Queue;

public class binary_search_tree {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(12);
        tree.insert(7);
        tree.insert(19);
        tree.insert(13);
        tree.insert(11);

        tree.bfs();
    }
}

class Node {
    int value;
    Node left, right;

    Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        this.root = null;
    }

    BinarySearchTree(int value) {
        this.root = new Node(value);
    }

    void insert(int value) {
        if (this.root == null) {
            this.root = new Node(value);
            return;
        }
        
        this.root = insert(value, this.root);
    }

    Node insert(int value, Node subtree) {
        if (subtree == null) {
            return new Node(value);
        }
        else if (value < subtree.value) {
            subtree.left = insert(value, subtree.left);
        }
        else {
            subtree.right = insert(value, subtree.right);
        }

        return subtree;
    }

    void bfs() {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.value + " ");

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }
}