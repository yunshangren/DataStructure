package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Acer
 * @create 2022/11/7 16:34
 */
public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            num = num % n == 0 ? n - 1 : (num % n) - 1;
            nums[num] += n;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public int countSegments(String s) {
        String[] strs = s.split(" ");
        int res = 0;
        for (String str : strs) {
            if(!"".equals(str)){
                res++;
            }
        }
        return res;
    }
}
