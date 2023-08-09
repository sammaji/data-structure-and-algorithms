public class Main {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseList(ListNode head) {

        ListNode temp = head;

        while (temp.next != null) {
            temp.next.next = temp;
            temp = temp.next;
        }

        return temp;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        ListNode n1 = new ListNode(12);
        ListNode n2 = new ListNode(9);
        ListNode n3 = new ListNode(81);
        ListNode n4 = new ListNode(29);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;

        ListNode rev = reverseList(head);
        System.out.println(rev.val);
        System.out.println(rev.next.val);
        System.out.println(rev.next.next.val);
    }
}
