package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Acer
 * @create 2022/11/1 16:12
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int twoSum = nums[i] + nums[j];
                int left = j + 1;
                int right = nums.length - 1;

                if (twoSum + nums[left] > 0 || twoSum + nums[right] < 0) {
                    continue;
                }

                while (left <= right) {
                    int mid = left + ((right - left) >> 1);
                    if (twoSum + nums[mid] < 0) {
                        left = mid + 1;
                    } else if (twoSum + nums[mid] > 0) {
                        right = mid - 1;
                    } else {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[mid]);
                        res.add(temp);
                        break;
                    }
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {-1, -1, 0, 1};
        List<List<Integer>> res = threeSum(nums);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }

    public int averageValue(int[] nums) {
        int cnt = 0;
        int sum = 0;
        for (int i : nums) {
            if ((i & -i) == i && i % 3 == 0) {
                cnt++;
                sum += i;
            }
        }
        return sum / cnt;
    }
}
