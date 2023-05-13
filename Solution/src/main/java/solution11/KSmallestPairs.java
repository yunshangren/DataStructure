package solution11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Acer
 * @create 2023/5/5 14:24
 */
public class KSmallestPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(((o1, o2) -> o2[0] + o2[1] - o1[0] - o1[1]));
        List<List<Integer>> res = new ArrayList<>();
        for (int i : nums1) {
            for (int j : nums2) {
                if (queue.size() < k) {
                    queue.add(new int[]{i, j});
                } else if (i + j < queue.peek()[0] + queue.peek()[1]) {
                    queue.poll();
                    queue.add(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            ArrayList<Integer> list = new ArrayList<>();
            list.add(arr[0]);
            list.add(arr[1]);
            res.add(list);
        }

        Collections.reverse(res);
        return res;
    }
}
