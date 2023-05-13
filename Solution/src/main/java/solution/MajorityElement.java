package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Acer
 * @create 2022/11/2 11:03
 */
public class MajorityElement {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int c1 = nums[0];
        int c2 = nums[0];
        int v1 = 0;
        int v2 = 0;
        for (int num : nums) {
            if (c1 == num) {
                v1++;
                continue;
            }
            if (c2 == num) {
                v2++;
                continue;
            }

            if (v1 == 0) {
                c1 = num;
                v1++;
                continue;
            }
            if (v2 == 0) {
                c2 = num;
                v2++;
                continue;
            }
            v1--;
            v2--;
        }
        v1 = 0;
        v2 = 0;
        for (int num : nums) {
            if (c1 == num) {
                v1++;
            } else if (c2 == num) {
                v2++;
            }
        }
        if (v1 > nums.length / 3) {
            res.add(c1);
        }
        if (v2 > nums.length / 3) {
            res.add(c2);
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {3, 2, 3};
        List<Integer> res = majorityElement(nums);
        System.out.println(res);
    }
}
