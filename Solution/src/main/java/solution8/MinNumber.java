package solution8;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/3/29 10:08
 */
public class MinNumber {
    public String minNumber(int[] nums) {
        int n = nums.length;
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        for (int i = 1; i < n; i++) {
            int index = i;
            while (index > 0 && (strs[index] + strs[index - 1]).compareTo(strs[index - 1] + strs[index]) < 0) {
                String temp = strs[index];
                strs[index] = strs[index - 1];
                strs[index - 1] = temp;
                index--;

            }
        }
        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            builder.append(str);
        }
        return builder.toString();
    }

    @Test
    public void test() {
        int[] arr = {1, 2, 3, 1};
        System.out.println(minNumber(arr));
    }
}
