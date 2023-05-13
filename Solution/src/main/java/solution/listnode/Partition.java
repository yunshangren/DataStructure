package solution.listnode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Acer
 * @create 2023/4/7 18:30
 */
public class Partition {
    public ListNode partition(ListNode head, int x) {
        ListNode p = head;
        List<Integer> list = new ArrayList<>();
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }

        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < x) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                index++;
            }
        }

        p = head;
        index = 0;
        while (p != null) {
            p.val = arr[index++];
            p = p.next;
        }
        return head;
    }

    @Test
    public void test() {
        Integer a = 1000;
        Integer b = 8545;
        a.equals(b);
    }
}
