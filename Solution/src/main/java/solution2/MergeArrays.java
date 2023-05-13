package solution2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Acer
 * @create 2023/2/23 14:17
 */
public class MergeArrays {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {

        List<int[]> list = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            // 第一个id大
            if (nums1[p1][0] > nums2[p2][0]) {
                list.add(new int[]{nums2[p2][0], nums2[p2][1]});
                p2++;
            } else if (nums1[p1][0] < nums2[p2][0]) {
                list.add(new int[]{nums1[p1][0], nums1[p1][1]});
                p1++;
            } else {
                list.add(new int[]{
                        nums1[p1][0],
                        nums1[p1][1] + nums2[p2][1]
                });
                p1++;
                p2++;
            }
        }
        while (p1 < nums1.length) {
            list.add(new int[]{nums1[p1][0], nums1[p1][1]});
            p1++;
        }
        while (p2 < nums2.length) {
            list.add(new int[]{nums2[p2][0], nums2[p2][1]});
            p2++;
        }
        // 把list直接转为二维数组
        return list.toArray(new int[list.size()][]);
    }
}
