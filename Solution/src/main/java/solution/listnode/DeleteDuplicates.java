package solution.listnode;

/**
 * @author Acer
 * @create 2023/2/22 14:30
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode newHead = pre;
        ListNode p = head;

        while (p != null && p.next != null) {
            if (p.val != p.next.val) {
                if (pre != p) {
                    pre.next = p;
                    pre = p;
                }
                p = p.next;
            } else {
                int value = p.val;
                while (p != null && p.val == value) {
                    p = p.next;
                }
                if (p == null || p.next == null || p.val != p.next.val) {
                    pre.next = p;
                    pre = p;
                }
            }
        }
        return newHead.next;
    }
}
