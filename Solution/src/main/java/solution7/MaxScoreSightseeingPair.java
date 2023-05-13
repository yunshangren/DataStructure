package solution7;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/3/22 9:53
 */
public class MaxScoreSightseeingPair {
    public int maxScoreSightseeingPair(int[] values) {
        int res = 0;
        int max = values[0]; // values[i] + i
        for (int j = 1; j < values.length; j++) {
            res = Math.max(res, max + values[j] - j);
            max = Math.max(max, values[j] + j);
        }
        return res;
    }
    public int maxScoreSightseeingPair1(int[] values) {
        int n = values.length;
        int res = 0;
        int max = values[0]; // values[i] + i
        for(int j = 1; j < n; j++){
            res = Math.max(res,values[j] - j + max);
            max = Math.max(max,values[j] + j);
        }
        return res;
    }

    @Test
    public void test(){
        int[] arr = {8,1,5,2,6};
        System.out.println(maxScoreSightseeingPair1(arr));
        System.out.println(maxScoreSightseeingPair(arr));
    }
}
