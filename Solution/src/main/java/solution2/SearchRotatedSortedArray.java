package solution2;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/2/20 20:04
 */
public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            // 看看mid在左边的递增区间还是在右边的递增区间
            // 左边区间
            if (nums[mid] >= nums[left]) {
                if (nums[left] <= target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 右边区间
                if (nums[right] >= target && nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return nums[left] == target ? left : -1;
    }

    @Test
    public void test(){
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(search(arr,3));
    }
}
