package solution;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Acer
 * @create 2022/10/20 9:05
 */
public class SmallestK {
    public int[] smallestK(int[] arr, int k) {
        if(k > arr.length || k == 0){
            return new int[]{};
        }
        if(k == arr.length){
            return arr;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            queue.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if(arr[i] <= queue.peek()){
                queue.add(arr[i]);
                queue.poll();
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;

    }

    @Test
    public void test(){
        int[] arr = {9,8,3,1,8,8,2,0,4};
        int[] ans = smallestK(arr, 5);
        System.out.println(Arrays.toString(ans));
    }
}
