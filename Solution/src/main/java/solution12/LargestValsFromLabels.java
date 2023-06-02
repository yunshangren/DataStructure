package solution12;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Acer
 * @create 2023/5/23 13:12
 */
public class LargestValsFromLabels {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        int[][] mat = new int[n][2];
        for (int i = 0; i < n; i++) {
            mat[i][0] = values[i];
            mat[i][1] = labels[i];
        }
        Arrays.sort(mat, (o1, o2) -> o2[0] - o1[0]);
        HashMap<Integer, Integer> labelCountMap = new HashMap<>();
        int sum = 0;
        for (int[] arr : mat) {
            if (numWanted == 0) {
                break;
            }
            if (labelCountMap.containsKey(arr[1]) && labelCountMap.get(arr[1]) == useLimit) {
                continue;
            }
            labelCountMap.put(arr[1], labelCountMap.getOrDefault(arr[1], 0) + 1);
            sum += arr[0];
            numWanted--;
        }
        return sum;
    }

    @Test
    public void test() {
        int[] values = {5, 4, 3, 2, 1};
        int[] labels = {1, 1, 2, 2, 3};
        System.out.println(largestValsFromLabels(values, labels, 3, 1));
    }
}
