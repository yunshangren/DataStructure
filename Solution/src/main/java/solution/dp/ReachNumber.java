package solution.dp;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Acer
 * @create 2022/11/4 9:47
 */
public class ReachNumber {
    public int reachNumber(int target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int i = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                Integer cur = queue.poll();
                if(cur == target){
                    return i - 1;
                }
                queue.add(cur - i);
                queue.add(cur + i);
            }
            i++;
        }
        return -1;
    }

    @Test
    public void test(){
        System.out.println(reachNumber(2));
    }


}
