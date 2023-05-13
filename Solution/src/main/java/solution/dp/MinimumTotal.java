package solution.dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Acer
 * @create 2022/11/4 18:00
 */
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0 ; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if(i == n - 1){
                    dp[i][j] = triangle.get(i).get(j);
                }else{
                    dp[i][j] = Math.min(
                            triangle.get(i).get(j) + dp[i + 1][j],
                            triangle.get(i).get(j) + dp[i + 1][j + 1]
                    );
                }
            }
        }
        return dp[0][0];
    }

    public int process(List<List<Integer>> triangle, int step, int index){
        if(index >= triangle.get(step).size()){
            return 0;
        }
        if(step == triangle.size() - 1){
            return triangle.get(step).get(index);
        }
        return Math.min(
                triangle.get(step).get(index) + process(triangle,step + 1,index),
                triangle.get(step).get(index) + process(triangle,step + 1,index + 1)
        );

    }
    @Test
    public void test(){
        int[][] arr = {
                {2},
                {3,4},
                {6,5,7},
                {4,1,8,3}
        };
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                list.add(arr[i][j]);
            }
            triangle.add(list);
        }
        System.out.println(minimumTotal(triangle));
    }

}
