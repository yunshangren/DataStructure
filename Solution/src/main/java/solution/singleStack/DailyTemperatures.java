package solution.singleStack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Acer
 * @create 2022/10/28 17:01
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!deque.isEmpty() && temperatures[i] > temperatures[deque.peekLast()]){
                int index = deque.pollLast();
                res[index] = i - index;
            }
            deque.addLast(i);
        }
        return res;
    }
}
