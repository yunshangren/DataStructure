package solution5;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Acer
 * @create 2023/3/13 15:48
 */
public class SortArray {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int[] par = partition(arr, left, right);
        quickSort(arr, left, par[0] - 1);
        quickSort(arr, par[1] + 1, right);
    }

    public int[] partition(int[] arr, int left, int right) {
        int randomIndex = (int) (left + (Math.random() * (right - left + 1)));
        swap(arr, randomIndex, right);
        int num = arr[right];
        int p1 = left;
        int p2 = right;
        int cur = left;
        while (cur <= p2) {
            if (arr[cur] > num) {
                swap(arr, cur, p2--);
            } else if (arr[cur] < num) {
                swap(arr, cur++, p1++);
            } else {
                cur++;
            }
        }
        return new int[]{p1, p2};
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
        int[] arr = {9, 8, 3, 1, 8, 8, 2, 0, 4};
        System.out.println(Arrays.toString(sortArray(arr)));
    }
}
