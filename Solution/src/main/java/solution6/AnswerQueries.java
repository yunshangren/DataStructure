package solution6;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Acer
 * @create 2023/3/17 13:27
 */
public class AnswerQueries {
    // 求和小于等于target的最长子序列的长度
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] preSum = new int[nums.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = binarySearch(preSum, queries[i]);
        }
        return res;
    }

    public int binarySearch(int[] nums, int target) {
        int res = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                res = mid;
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] arr = {4,5,2,1};
        int[] queries = {3,10,21};
        System.out.println(Arrays.toString(answerQueries(arr,queries)));

    }
}
