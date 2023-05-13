package solution9;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/4/12 9:22
 */
public class ReversePairs {
    int[] temp;
    int res = 0;

    public int reversePairs(int[] nums) {
        mergeSort(nums);
        return res;
    }

    public void mergeSort(int[] nums) {
        temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    public void merge(int[] nums, int left, int mid, int right) {
        int p1 = left;
        int p2 = mid + 1;
        int index = left;
        while (p1 <= mid && p2 <= right) {
            if (nums[p1] <= nums[p2]) {
                temp[index++] = nums[p1++];
            } else {
                temp[index++] = nums[p2++];
                res += mid - p1 + 1;
            }
        }
        while (p1 <= mid) {
            temp[index++] = nums[p1++];
        }
        while (p2 <= right) {
            temp[index++] = nums[p2++];
        }
        System.arraycopy(temp, left, nums, left, right - left + 1);
    }

    @Test
    public void test() {
        int[] arr = {7,5,6,4,2,1,1};
        System.out.println(reversePairs(arr));
    }
}
