package solution8;

/**
 * @author Acer
 * @create 2023/3/31 11:58
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int candidate = 0;
        for (int num : nums) {
            if (cnt == 0) {
                candidate = num;
                cnt++;
            } else if (num == candidate) {
                cnt++;
            } else {
                cnt--;
            }
        }
        if (cnt == 0) {
            return -1;
        }
        cnt = 0;
        for (int num : nums) {
            if (num == candidate) {
                cnt++;
            }
        }
        return cnt > (nums.length >> 1) ? candidate : -1;
    }
}
