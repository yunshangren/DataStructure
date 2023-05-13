package solution.listnode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Acer
 * @create 2022/10/28 16:14
 */
public class NextLargerNodes {

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode p = head;
        while (p != null){
            list.add(p.val);
            p = p.next;
        }
        int[] res = new int[list.size()];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < list.size(); i++) {
            while (!deque.isEmpty() && list.get(i) > list.get(deque.peekLast())){
                res[deque.pollLast()] = list.get(i);
            }
            deque.addLast(i);
        }
        return res;
    }

}
