package solution6;

/**
 * @author Acer
 * @create 2023/3/19 16:23
 */
public class RandomPickWithWeight {
    int sum = 0;
    int[] preSum;


    public RandomPickWithWeight(int[] w) {
        int n = w.length;
        preSum = new int[n + 1];
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            preSum[i + 1] = sum;
        }
    }

    public int pickIndex() {
        int randomNumber = (int) (Math.random() * sum);
        return binarySearch(preSum, randomNumber);
    }

    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        int res = 0;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                res = mid;
                right = mid - 1;
            } else {
                return mid + 1;
            }
        }
        return res;
    }


}
