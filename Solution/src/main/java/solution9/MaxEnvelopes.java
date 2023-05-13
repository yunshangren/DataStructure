package solution9;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Acer
 * @create 2023/4/11 14:11
 */
public class MaxEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o2[1] - o1[1]);
        int n = envelopes.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = envelopes[i][1];
        }
        return lengthOfLIS(arr);
    }

    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int left = 0;
            int right = res;
            while (left < right) {
                int mid = left + ((right - left) >> 1);
                if (tails[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            tails[left] = num;
            if (res == right) {
                res++;
            }
        }
        return res;

    }

    @Test
    public void test() {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(arr));
    }
}
