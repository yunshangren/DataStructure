package solution.listnode;

/**
 * @author Acer
 * @create 2023/4/4 22:31
 */
public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        int cnt = 1;
        while (p.next != null) {
            cnt++;
            p = p.next;
        }
        p.next = head;
        k %= cnt;
        k = cnt - k;
        while (k-- > 0){
            p = p.next;
            head = head.next;
        }
        p.next = null;
        return head;
    }
}
