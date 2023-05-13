package solution.singleStack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Acer
 * @create 2022/11/7 18:52
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null) {
            return null;
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            int num = nums[i];
            if (!deque.isEmpty() && num >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }

        int left = 0;
        int right = k - 1   ;
        while (right < nums.length) {
            int num = nums[right];
            while (!deque.isEmpty() && num >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.add(right);
            right++;
            res[left++] = left < deque.peekFirst() ? nums[deque.peekFirst()] : nums[deque.pollFirst()];

        }
        return res;
    }
}
