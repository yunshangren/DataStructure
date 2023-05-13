package solution5;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/3/13 11:34
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        // 1 <= k <= nums.length <= 10^5
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int par = partition(nums,left,right);
            if(par < k){
                left = par;
            }else if(par > k){
                right = par - 2;
            }else {
                return nums[par - 1];
            }
        }
        return -1;
    }

    public int partition(int[] arr, int left, int right) {
        int randomIndex = (int) (left + Math.random() * (right - left + 1));
        swap(arr, right, randomIndex);
        int num = arr[right];
        int p = left;
        for (int i = left; i <= right; i++) {
            if (arr[i] > num) {
                swap(arr, i, p++);
            }
        }
        swap(arr, p, right);
        return p + 1;
    }

    public int partition1(int[] arr, int left, int right) {
        int randomIndex = (int) (left + Math.random() * (right - left + 1));
        int num = arr[randomIndex];
        int p1 = left;
        int p2 = right;
        int cur = left;
        while (cur <= p2) {
            if (arr[cur] > num) {
                swap(arr, cur++, p1++);
            } else if (arr[cur] < num) {
                swap(arr, cur, p2--);
            } else {
                cur++;
            }
        }
        return p1;
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
    public void test() {
        int[] arr = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(arr, 2));

    }
}
