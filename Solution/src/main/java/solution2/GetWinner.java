package solution2;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/2/23 16:14
 */
public class GetWinner {
    public int getWinner(int[] arr, int k) {
        // 输掉的数字不可能是要找的值
        int winner = arr[0];
        int cnt = 0;
        for (int i = 1; i < arr.length && cnt < k; i++) {
            if(winner > arr[i]){
                cnt++;
            }else{
                winner = arr[i];
                cnt = 1;
            }
        }
        return winner;
    }

    @Test
    public void test(){
        int[] arr = {2,1,3,5,4,6,7};
        System.out.println(getWinner(arr,2));
    }
}
