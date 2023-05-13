package solution8;

import org.junit.Test;

import java.util.*;

/**
 * @author Acer
 * @create 2023/4/3 19:01
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        while (right < n) {
            while (!queue.isEmpty() && nums[right] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.addLast(right);
            if (right - left + 1 == k) {
                res[left] = left < queue.peekFirst() ? nums[queue.peekFirst()] : nums[queue.pollFirst()];
                left++;
            }
            right++;
        }
        return res;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int[] arr = new int[n];
        int head = 0;
        int tail = 0;
        while (right < n) {
            while (head < tail && nums[right] >= nums[arr[tail - 1]]) {
                tail--;
            }
            arr[tail++] = right;
            if (right - left + 1 == k) {
                res[left] = left < arr[head] ? nums[arr[head]] : nums[arr[head++]];
                left++;
            }
            right++;
        }
        return res;
    }

    @Test
    public void test() {
        int[] arr = {1,3,-1,-3,5,3,6,-1,-2,-5,8,8,9,4,7};
        System.out.println(Arrays.toString(maxSlidingWindow(arr, 3)));
        System.out.println(Arrays.toString(maxSlidingWindow2(arr, 3)));
    }
}
