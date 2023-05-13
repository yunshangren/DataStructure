package solution6;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/3/17 10:25
 */
public class SearchSortedArray {
    public int search(int[] nums, int target) {
        int start = -1;
        int end = -1;
        int mid;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                right = mid - 1;
                start = mid;
            }
        }

        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
                end = mid;
            }
        }

        return start == -1 ? 0 : end - start + 1;
    }

    @Test
    public void test() {
        int[] arr = {5, 7, 7, 8, 8, 10};
        System.out.println(search(arr, 6));
    }
}
