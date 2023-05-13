package solution;

import org.junit.Test;

import java.util.*;

/**
 * @author Acer
 * @create 2022/10/31 20:02
 */
public class Merge {
    public int[][] merge1(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        Deque<Integer> deque = new ArrayDeque<>();
        for (int[] interval : intervals) {
            if(deque.isEmpty() || interval[0] > deque.peekLast()){
                deque.addLast(interval[0]);
                deque.addLast(interval[1]);
            }else if(interval[0] <= deque.peekLast() && interval[1] > deque.peekLast()){
                deque.pollLast();
                deque.addLast(interval[1]);
            }
        }
        int size = deque.size() / 2;
        int[][] res = new int[size][2];
        for (int i = 0; i < size; i++) {
            res[i][0] = deque.pollFirst();
            res[i][1] = deque.pollFirst();
        }
        return res;
    }

    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            if(res.isEmpty()){
                res.add(interval);
            }else{
                int[] ints = res.get(res.size() - 1);
                if(interval[0] > ints[1]){
                    res.add(interval);
                }else{
                    ints[1] = Math.max(ints[1],interval[1]);
                }
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    @Test
    public void test(){

    }
}
