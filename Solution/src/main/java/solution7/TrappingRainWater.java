package solution7;

/**
 * @author Acer
 * @create 2023/3/24 14:29
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int res = 0;
        int n = height.length;
        int leftMax = height[0];
        int rightMax = height[n - 1];
        int left = 1;
        int right = n - 2;
        while (left <= right) {
            if (leftMax <= rightMax) {
                if (leftMax >= height[left]) {
                    res += leftMax - height[left];
                } else {
                    leftMax = height[left];
                }
                left++;
            } else {
                if (rightMax >= height[right]) {
                    res += rightMax - height[right];
                } else {
                    rightMax = height[right];
                }
                right--;
            }
        }
        return res;
    }
}
