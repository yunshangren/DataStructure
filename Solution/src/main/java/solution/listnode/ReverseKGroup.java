package solution.listnode;

/**
 * @author Acer
 * @create 2023/3/23 18:32
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        for (int i = 0; i < k; i++) {
            if (p2 == null) {
                return p1;
            }
            p2 = p2.next;
        }
        ListNode newHead = reverse(p1, p2);
        p1.next = reverseKGroup(p2, k);
        return newHead;
    }

    public ListNode reverse(ListNode p1, ListNode p2) {
        if (p1 == null || p1.next == null) {
            return p1;
        }
        ListNode pre = null;
        ListNode cur = p1;
        while (cur != p2) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
