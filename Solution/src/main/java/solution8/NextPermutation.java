package solution8;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Acer
 * @create 2023/4/3 13:40
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            reverseArray(nums, 0, n - 1);
            return;
        }
        int firstBiggerIndex = binarySearch(nums, index + 1, n - 1, nums[index]);
        swap(nums, index, firstBiggerIndex);
        reverseArray(nums, index + 1, n - 1);
    }

    public void reverseArray(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }

    public int binarySearch(int[] nums, int left, int right, int target) {
        int res = 0;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] <= target) {
                right = mid - 1;
            } else {
                res = mid;
                left = mid + 1;
            }
        }
        return res;

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void test() {
        int[] arr = {2, 3, 1};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
}
