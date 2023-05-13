package solution8;

/**
 * @author Acer
 * @create 2023/3/29 18:42
 */
public class SortEvenOdd {
    public int[] sortEvenOdd(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return nums;
        }
        for (int i = 2; i < n; i++) {
            int index = i;
            if (index % 2 == 0) {
                while (index > 0 && nums[index] < nums[index - 2]) {
                    swap(nums, index, index - 2);
                    index -= 2;
                }
            } else {
                while (index > 1 && nums[index] > nums[index - 2]) {
                    swap(nums, index, index - 2);
                    index -= 2;
                }
            }
        }
        return nums;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
