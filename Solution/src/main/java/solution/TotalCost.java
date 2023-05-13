package solution;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @author Acer
 * @create 2022/11/8 10:44
 */
public class TotalCost {
    public long totalCost(int[] costs, int k, int candidates) {
        long res = 0;
        if (costs.length <= candidates << 1) {
            PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
            for (int cost : costs) {
                if (queue.size() < k) {
                    queue.add(cost);
                } else if (cost < queue.peek()) {
                    queue.poll();
                    queue.add(cost);
                }
            }
            for (int i = 0; i < k; i++) {
                res += queue.poll();
            }
            return res;
        }
        int left = candidates;
        int right = costs.length - candidates - 1;
        PriorityQueue<Integer> q1 = new PriorityQueue<>();
        PriorityQueue<Integer> q2 = new PriorityQueue<>();
        for (int i = 0; i < candidates; i++) {
            q1.add(costs[i]);
        }
        for (int i = costs.length - candidates; i < costs.length; i++) {
            q2.add(costs[i]);
        }
        while (k > 0 && left <= right) {
            if (q1.peek() <= q2.peek()) {
                res += q1.poll();
                q1.add(costs[left++]);
            } else {
                res += q2.poll();
                q2.add(costs[right--]);
            }
            k--;
        }

        while (k-- > 0) {
            if (!q1.isEmpty() && !q2.isEmpty()) {
                res += q1.peek() <= q2.peek() ? q1.poll() : q2.poll();
            } else if (q1.isEmpty()) {
                res += q2.poll();
            }else{
                res += q1.poll();
            }

        }
        return res;
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int[] res = new int[k];
        if (k == 0) {
            return res;
        }
        for (int num : arr) {
            if (queue.size() < k) {
                queue.add(num);
            } else if (num < queue.peek()) {
                queue.poll();
                queue.add(num);
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    @Test
    public void test() {
        int[] arr = {57, 33, 26, 76, 14, 67, 24, 90, 72, 37, 30};
        long cost = totalCost(arr, 11, 2);
        System.out.println(cost);
    }
}
