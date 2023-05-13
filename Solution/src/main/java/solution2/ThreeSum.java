package solution2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Acer
 * @create 2023/2/22 15:20
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int diff = -nums[i] - nums[j];
                int left = j + 1;
                int right = nums.length - 1;
                if (diff < nums[left] || diff > nums[right]) {
                    continue;
                }
                while (left <= right) {
                    int mid = left + ((right - left) >> 1);
                    if (nums[mid] == diff) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[mid]);
                        res.add(temp);
                        break;
                    } else if (nums[mid] < diff) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[n - 1] < 0) {
            return res;
        }

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int k = n - 1;
            for (int j = i + 1; j < k; j++) {
                if (nums[i] + nums[j] + nums[k] < 0 || (j > i + 1 && nums[j] == nums[j - 1])) {
                    continue;
                }
                while (k > j && nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                }
                if (j == k) {
                    break;
                }
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] arr = {-4, -3, -1, -1, 0, 1, 2, 4};
        System.out.println(threeSum1(arr));
    }
}
