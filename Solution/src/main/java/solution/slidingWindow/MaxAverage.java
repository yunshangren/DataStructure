package solution.slidingWindow;

import org.junit.Test;

/**
 * @author Acer
 * @create 2022/10/18 20:14
 */
public class MaxAverage {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        int right = k;
        double sum = 0;
        for (int i = 0; i < right; i++) {
            sum += nums[i];
        }
        double avg = sum / k;
        while (right < nums.length) {
            sum += nums[right];
            sum -= nums[left];
            avg = Math.max(avg, sum / k);
            left++;
            right++;
        }
        return avg;
    }

    @Test
    public void test(){
        int[] arr = {1,12,-5,-6,50,3};
        System.out.println(findMaxAverage(arr,4));
    }
}
