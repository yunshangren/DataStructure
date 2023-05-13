package solution11;

import org.junit.Test;
import tool.Tools;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Acer
 * @create 2023/5/11 14:49
 */
public class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = i;
            arr[i][1] = intervals[i][0];
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[1]));
        int[] res = new int[n];
        for (int i = 0; i < intervals.length; i++) {
            res[i] = binarySearch(arr, intervals[i][1]);
        }
        return res;
    }

    public int binarySearch(int[][] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        if (target > arr[right][1]) {
            return -1;
        }
        int res = 0;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (arr[mid][1] < target) {
                left = mid + 1;
            } else if (arr[mid][1] > target) {
                res = mid;
                right = mid - 1;
            } else {
                return arr[mid][0];
            }
        }
        return arr[res][0];
    }

    @Test
    public void test() {
        String s = "[[3,4],[2,3],[1,2]]";
        int[][] mat = Tools.stringToMatrix(s);
        System.out.println(Arrays.toString(findRightInterval(mat)));

    }

}
