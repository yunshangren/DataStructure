package solution10;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/4/13 18:42
 */
public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] leftPre = new int[n + 1];
        int[] rightPre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            leftPre[i + 1] = leftPre[i] + nums[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            rightPre[i] = rightPre[i + 1] + nums[i];
        }
        int res = -1;
        for (int i = 0; i < n; i++) {
            // 对于nums数组中，下标为i的元素，leftPre[i] 是它左边元素的总和，rightPre[i + 1] 是他右边元素的总和
            if (leftPre[i] == rightPre[i + 1]) {
                res = i;
                break;
            }
        }
        return res;
    }

    @Test
    public void test(){
        int[] arr = {-1,-1,0,0,-1,-1};
        System.out.println(pivotIndex(arr));
    }
}
