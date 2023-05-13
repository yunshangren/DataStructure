package solution11;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/4/18 9:34
 */
public class SingleNonDuplicate {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (mid > 0 && nums[mid] == nums[mid - 1]) {
                if ((mid & 1) == 0) {
                    right = mid - 2;
                } else {
                    left = mid + 1;
                }
            } else if (mid < n - 1 && nums[mid] == nums[mid + 1]) {
                if ((mid & 1) == 0) {
                    left = mid + 2;
                } else {
                    right = mid - 1;
                }
            } else {
                return nums[mid];
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 4, 8, 8, 9};
        System.out.println(singleNonDuplicate(arr));
    }
}
