package solution4;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/3/6 10:53
 */
public class DecodeWays {
    public int numDecodings(String s) {
        char[] arr = s.toCharArray();
        if (arr[0] == '0') {
            return 0;
        }
        int n = arr.length;;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int x = arr[i] - '0';
            if(x > 0 && x < 10){
                dp[i] += dp[i - 1];
            }
            int y = 10 * (arr[i - 1] - '0') + x;
            if(y > 9 && y < 27){
                dp[i] += i > 1 ? dp[i - 2] : 1;
            }
        }
        return dp[n - 1];
    }

    public int dfs(char[] arr, int index){
        if(index == arr.length){
            return 1;
        }
        if(index > arr.length){
            return 0;
        }
        int i = arr[index] - '0';
        if(i == 0){
            if(index == 0){
                return 0;
            }else{
                return dfs(arr,index + 1);
            }
        }else if(i == 1){
            if(index == arr.length - 1){
                return 1;
            }else{
                return dfs(arr, index + 1) + dfs(arr, index + 2);
            }
        }else if(i == 2){
            if(index == arr.length - 1){
                return 1;
            }else if(arr[index + 1] - '0' < 7){
                return dfs(arr, index + 1) + dfs(arr, index + 2);
            }else{
                return dfs(arr, index + 1);
            }
        }else{
            return dfs(arr, index + 1);
        }
    }



    @Test
    public void test(){
        String s = "12125259";
        System.out.println(numDecodings(s));
    }
}
