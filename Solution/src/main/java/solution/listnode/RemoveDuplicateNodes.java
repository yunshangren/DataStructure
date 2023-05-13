package solution.listnode;

import java.util.HashSet;

/**
 * @author Acer
 * @create 2023/4/7 18:02
 */
public class RemoveDuplicateNodes {
    public ListNode removeDuplicateNodes(ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        ListNode cur = head;
        set.add(head.val);
        while (cur.next != null) {
            if (!set.contains(cur.next.val)) {
                cur = cur.next;
                set.add(cur.val);
            } else {
                cur.next = cur.next.next;
            }
        }
        return head;
    }
}
