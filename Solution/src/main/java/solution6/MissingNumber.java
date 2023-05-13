package solution6;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/3/17 10:53
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        if (nums[0] != 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] > mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    @Test
    public void test(){
        int[] arr = {0,1,2,3,4,5,6,7,9};
        System.out.println(missingNumber(arr));
    }
}
