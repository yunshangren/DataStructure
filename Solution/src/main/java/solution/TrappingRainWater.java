package solution;

import org.junit.Test;

/**
 * @author Acer
 * @create 2022/10/20 14:42
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int leftCur = 1;
        int rightCur = height.length - 2;
        int sum = 0;
        while (leftCur <= rightCur) {
            if (leftMax <= rightMax) {
                sum += Math.max(leftMax - height[leftCur], 0);
                leftMax = Math.max(leftMax, height[leftCur++]);
            } else {
                sum += Math.max(rightMax - height[rightCur], 0);
                rightMax = Math.max(rightMax, height[rightCur--]);
            }
        }
        return sum;
    }

    @Test
    public void test(){
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(arr));
    }
}
