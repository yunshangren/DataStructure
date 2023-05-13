package solution8;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Acer
 * @create 2023/4/3 14:26
 */
public class PrevPermOpt1 {
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return arr;
        }
        int index = -1;
        // 如果arr全是非降序(左 <= 右)，那么无法得到一个更小的序列
        // 如果存在一个 左 > 右,则可以得到
        for (int i = n - 1; i > 0; i--) {
            if (arr[i - 1] > arr[i]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return arr;
        }
        // [index,n-1] 全是 左 <= 右
        // 找到一个小于arr[index - 1] 的最大的中最左的
        int temp = binarySearch(arr, index, n - 1, arr[index - 1]);
        temp = arr[temp] == arr[index - 1]
                ? binarySearch(arr, index, temp - 1, arr[temp - 1]) : temp;
        swap(arr, temp, index - 1);
        return arr;


    }

    public int binarySearch(int[] nums, int left, int right, int target) {
        int res = 0;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                res = mid;
                left = mid + 1;
            } else {
                res = mid;
                right = mid - 1;
            }
        }
        return res;

    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    public void test() {
        int[] arr = {1, 9, 4, 6, 7};
        arr = prevPermOpt1(arr);
        System.out.println(Arrays.toString(arr));


    }
}
