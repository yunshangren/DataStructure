package solution7;

/**
 * @author Acer
 * @create 2023/3/23 19:50
 */
public class NumIdenticalPairs {
    public int numIdenticalPairs(int[] nums) {
        int res = 0;
        int[] arr = new int[101];
        for (int num : nums) {
            res += arr[num]++;
        }
        return res;
    }
}
