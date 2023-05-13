package solution4;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Acer
 * @create 2023/3/2 16:53
 */
public class TriangleNumber {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = nums.length - 1; j > i + 1; j--) {
                int diff = nums[j] - nums[i];
                int index = search(nums, i + 1, j - 1, diff);
                res += index == -1 ? 0 : j - index;
            }
        }
        return res;
    }

    public int search(int[] nums, int left, int right, int target) {
        if (nums[right] <= target) {
            return -1;
        }
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int search1(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        if(nums[right] <= target){
            return -1;
        }
        int mid = 0;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if(nums[mid] <= target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return mid;
    }

    @Test
    public void test() {
        int[] arr = {1, 1, 3, 4};
        System.out.println(search1(arr,4));
    }
}
