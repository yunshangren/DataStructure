package solution3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Acer
 * @create 2023/2/28 10:02
 */
public class MergeSimilarItems {

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(items1, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(items2, Comparator.comparingInt(o -> o[0]));
        int p1 = 0;
        int p2 = 0;
        while (p1 < items1.length && p2 < items2.length) {
            if (items1[p1][0] == items2[p2][0]) {
                List<Integer> list = new ArrayList<>();
                list.add(items1[p1][0]);
                list.add(items1[p1][1] + items2[p2][1]);
                ret.add(list);
                p1++;
                p2++;
            } else if (items1[p1][0] < items2[p2][0]) {
                List<Integer> list = new ArrayList<>();
                list.add(items1[p1][0]);
                list.add(items1[p1][1]);
                ret.add(list);
                p1++;
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(items2[p2][0]);
                list.add(items2[p2][1]);
                ret.add(list);
                p2++;
            }
        }
        while (p1 < items1.length) {
            List<Integer> list = new ArrayList<>();
            list.add(items1[p1][0]);
            list.add(items1[p1][1]);
            ret.add(list);
            p1++;
        }
        while (p2 < items2.length) {
            List<Integer> list = new ArrayList<>();
            list.add(items2[p2][0]);
            list.add(items2[p2][1]);
            ret.add(list);
            p2++;
        }
        return ret;
    }
}
