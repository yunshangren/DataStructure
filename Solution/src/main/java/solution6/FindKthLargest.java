package solution6;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/3/20 14:29
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int par = partition(nums, left, right);
            if (par > k) {
                right = par - 2;
            } else if (par < k) {
                left = par;
            } else {
                return nums[par - 1];
            }
        }
        return -1;
    }

    public int partition(int[] arr, int left, int right) {
        int randomIndex = (int) (left + (Math.random() * (right - left)));
        swap(arr, right, randomIndex);
        int res = left;
        int num = arr[right];
        for (int i = left; i <= right; i++) {
            if (arr[i] > num) {
                swap(arr, res++, i);
            }
        }
        swap(arr,res++,right);
        return res;
    }

    public void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    public void test(){
        int[] arr = {9,8,3,1,8,8,2,0,4};
        for (int i = 0; i < arr.length; i++) {
            System.out.println();
        }
    }
}
