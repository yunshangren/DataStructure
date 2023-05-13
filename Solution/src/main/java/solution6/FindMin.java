package solution6;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/3/18 10:37
 */
public class FindMin {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int mid;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right -= 1;
            }
        }
        return nums[left];
    }

    @Test
    public void test() {
        int[] arr = {3, 1, 3};
        System.out.println(findMin(arr));
    }
}
