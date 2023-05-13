package solution.slidingWindow;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Acer
 * @create 2022/10/28 11:13
 */
public class SlidingWindowMaxValue {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null) {
            return null;
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            int value = nums[i];
            while (!deque.isEmpty() && value >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.addLast(i);
        }
        int left = 0;
        int right = k - 1;
        while (right < nums.length){
            int value = nums[right];
            while (!deque.isEmpty() && value >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.add(right);
            right++;
            res[left] = nums[left == deque.peekFirst() ? deque.pollFirst() : deque.peekFirst()];
            left++;
        }
        return res;
    }

    @Test
    public void test(){
        int[] arr = {1,5,8,1,2,5,8,3,-1,-3,5,3,6,7};
        int[] res = maxSlidingWindow(arr, 3);
        System.out.println(Arrays.toString(res));
    }
}
