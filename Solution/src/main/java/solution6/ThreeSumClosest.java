package solution6;

import java.util.Arrays;

/**
 * @author Acer
 * @create 2023/3/21 18:38
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        if (n == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        int closet = Integer.MAX_VALUE;
        Arrays.sort(nums);
        if (nums[0] + nums[1] + nums[2] >= target) {
            return nums[0] + nums[1] + nums[2];
        }
        if (nums[n - 1] + nums[n - 2] + nums[n - 3] <= target) {
            return nums[n - 1] + nums[n - 2] + nums[n - 3];
        }
        for (int i = 0; i < n - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return target;
                } else if (sum > target) {
                    closet = sum - target < Math.abs(closet - target) ? sum : closet;
                    while (k < n - 1 && nums[k - 1] == nums[k]) {
                        k--;
                    }
                } else {
                    closet = target - sum < Math.abs(closet - target) ? sum : closet;
                    while (j > i + 1 && nums[j] == nums[j - 1]){
                        j++;
                    }
                }
            }
        }
        return closet;
    }

    public int closetTarget(int[] nums, int left, int right, int target) {
        int more = 0;
        int less = 0;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                less = mid;
                left = mid + 1;
            } else if (nums[mid] > target) {
                more = mid;
                right = mid - 1;
            } else {
                return nums[mid];
            }
        }
        return target - nums[less] < nums[more] - target ? nums[less] : nums[more];
    }


}
