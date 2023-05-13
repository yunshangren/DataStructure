package solution11;

/**
 * @author Acer
 * @create 2023/4/28 10:30
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] stack = new int[n];
        int size = 0;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            while (size > 0 && temperatures[i] > temperatures[stack[size - 1]]) {
                res[stack[size - 1]] = i - stack[size - 1];
                size--;
            }
            stack[size++] = i;
        }
        for (int i = 0; i < size; i++) {
            res[stack[i]] = 0;
        }
        return res;
    }
}
