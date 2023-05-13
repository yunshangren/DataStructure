package solution8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Acer
 * @create 2023/3/29 16:37
 */
public class PrefixesDivBy5 {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> res = new ArrayList<>();
        int prefix = 0;
        int n = nums.length;
        for (int num : nums) {
            prefix = ((prefix << 1) + num) % 5;
            res.add(prefix == 0);
        }
        return res;
    }


}
