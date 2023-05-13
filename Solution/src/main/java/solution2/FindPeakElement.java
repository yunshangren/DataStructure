package solution2;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/2/21 14:16
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if(nums[mid] < nums[mid + 1]){
                left = mid + 1;
            }else{
                right = mid;
            }

        }
        return left;
    }

    @Test
    public void test() {
        int[] arr = {1, 2};
        System.out.println(findPeakElement(arr));
    }
}
