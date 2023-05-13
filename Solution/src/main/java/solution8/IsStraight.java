package solution8;

/**
 * @author Acer
 * @create 2023/3/29 10:38
 */
public class IsStraight {
    public boolean isStraight(int[] nums) {
        int[] visited = new int[14];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num != 0 && visited[num] == 0) {
                visited[num]++;
                max = Math.max(max, num);
                min = Math.min(min, num);
            } else if (num != 0) {
                return false;
            }
        }
        return max - min <= 4;
    }
}
