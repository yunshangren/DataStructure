package solution10;

import java.util.*;

/**
 * @author Acer
 * @create 2023/4/17 10:41
 */
public class InsertInterval {
    public int[][] insert1(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        list.add(newInterval);
        list.sort(Comparator.comparingInt(o -> o[0]));
        List<int[]> res = new ArrayList<>();
        for (int[] arr : list) {
            if (res.isEmpty()) {
                res.add(arr);
            } else {
                int[] temp = res.get(res.size() - 1);
                if (arr[0] > temp[1]) {
                    res.add(arr);
                } else {
                    temp[1] = Math.max(temp[1], arr[1]);
                }
            }
        }
        return res.toArray(new int[res.size()][]);
    }


}
