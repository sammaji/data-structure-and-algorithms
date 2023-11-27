package trees;

public class BtNode {
    int value;
    BtNode left, right;

    BtNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    BtNode(int value, BtNode left, BtNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    static int findHeight(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(findHeight(node.left), findHeight(node.right));
    }

    /**
     * @return height if tree is balanced else -1
     */
    static int findBalancedHeight(Node node) {
        if (node == null) return 0;
        int lh = findBalancedHeight(node);
        int rh = findBalancedHeight(node);
        if (lh == -1 || rh == -1 || Math.abs(lh - rh) > 1) return -1;
        return 1 + Math.max(lh, rh);
    }
}
