package trees;

import java.util.*;

public class BinaryTree {
    public static void main(String[] args) {
        BtNode node = new BtNode(10,
            new BtNode(2, new BtNode(13, new BtNode(5), null), new BtNode(9)),
            new BtNode(5, null, new BtNode(5))
            );

        BinaryTree tree = new BinaryTree(node);
//        tree.dfsInorder();

        System.out.println(BinaryTree.maxHeight(tree.getRoot()));
    }

    BtNode tree;

    BinaryTree(int value) {
        this.tree = new BtNode(value);
    }

    BinaryTree(int value, BtNode left, BtNode right) {
        this.tree = new BtNode(value, left, right);
    }
    
    BinaryTree(BtNode root) {
        this.tree = root;
    }

    BtNode getRoot() {
        return this.tree;
    }

    void dfsPreorder() {
        if (this.tree == null) return;
        Stack<BtNode> stack = new Stack<>();
        stack.push(this.tree);
        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int i=0; i<size; i++) {
                BtNode node = stack.pop();
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
                System.out.printf("%d, ", node.value);
            }
        }
    }

    void dfsInorder() {
        if (this.tree == null) return;
        Stack<BtNode> stack = new Stack<>();
        stack.add(this.tree);

        while(!stack.isEmpty()) {
            int size = stack.size();
            BtNode node = stack.pop();
            for (int i=0; i<size; i++) {
                if (node.left != null) stack.push(node.left);
                if (node.right != null) stack.push(node.right);
                System.out.print(node.value);
            }
        }
    }

    void dfsPostorder() {
        dfsPostorder(this.tree);
    }

    private void dfsInorder(BtNode subtree) {
        if (subtree == null) return;

        dfsInorder(subtree.left);
        System.out.printf("%d ", subtree.value);
        dfsInorder(subtree.right);
    }

    private void dfsPostorder(BtNode subtree) {
        if (subtree == null) return;

        dfsPostorder(subtree.left);
        dfsPostorder(subtree.right);
        System.out.printf("%d ", subtree.value);
    }

    List<List<Integer>> bfs() {
        List<List<Integer>> lst = new LinkedList<>();
        if (this.tree == null) return lst;

        Queue<BtNode> queue = new LinkedList<BtNode>();
        queue.offer(tree);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> subLst = new LinkedList<>();
            for (int i=0; i<levelSize; i++) {
                BtNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                subLst.add(node.value);
            }
        }

        return lst;
    }

    static int maxHeight(BtNode node) {
        if (node == null) return 0;
        return 1 + Math.max(maxHeight(node.left), maxHeight(node.right));
    }

    static int checkIfBalanced(BtNode node) {
        if (node == null) return 0;
        int lf = checkIfBalanced(node);
        int rf = checkIfBalanced(node);
        if (lf == -1 || rf == -1 || Math.abs(lf - rf) > 1) return -1;
        return 1 + Math.max(lf, rf);
    }

    boolean isBalanced() {
        return false;
    }

    void display() {
        if (this.tree == null) return;

        Queue<BtNode> queue = new LinkedList<BtNode>();
        queue.offer(tree);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i=0; i<levelSize; i++) {
                BtNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                System.out.printf(i == levelSize-1 ? "%d": "%d, ", node.value);
            }
            System.out.println();
        }
    }
}
