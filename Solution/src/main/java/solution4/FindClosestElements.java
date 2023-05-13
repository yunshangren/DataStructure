package solution4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Acer
 * @create 2023/3/3 13:23
 */
public class FindClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int n = arr.length;
        int right = getIndex(arr, x);
        int left = right - 1;
        while (k-- > 0) {
            if (left < 0) {
                right++;
            } else if (right == n) {
                left--;
            } else if (x - arr[left] <= arr[right] - x) {
                left--;
            } else {
                right++;
            }
        }
        for (int i = left + 1; i < right; i++) {
            res.add(arr[i]);
        }
        return res;


    }

    // [0, ans)区间 arr[i] <= target
    //[ans,n)区间，arr[i] > target
    public int getIndex(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }


    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int i : chalk) {
            sum += i;
        }
        k %= sum;
        for(int i = 0; i < chalk.length; i++){
            if(k >= chalk[i]){
                k -= chalk[i];
            }else{
                return i;
            }
        }
        return -1;
    }
    @Test
    public void test() {
        int[] arr = {1, 2, 5, 9, 86, 456};

    }
}
