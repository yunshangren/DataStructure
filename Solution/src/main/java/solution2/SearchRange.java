package solution2;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/2/20 18:57
 */
public class SearchRange {
    // 非递减顺序排列的整数数组 nums
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0 || nums[0] > target) {
            return new int[]{-1, -1};
        }

        int left = 0;
        int right = nums.length - 1;
        int start = -1;
        int end = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                // 找到target第一个出现的位置，
                right = mid - 1;
                start = mid;
            }
        }

        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
                end = mid;
            }
        }
        return new int[]{start, end};


    }

    @Test
    public void test() {
        int a = 5;
        int b = 7;
        System.out.println(a + ((b - a) >> 1));
    }


}
