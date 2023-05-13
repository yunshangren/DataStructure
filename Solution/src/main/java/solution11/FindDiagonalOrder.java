package solution11;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Acer
 * @create 2023/5/3 16:01
 */
public class FindDiagonalOrder {
    public int[] findDiagonalOrder1(List<List<Integer>> nums) {
        int n = 0;
        int maxCol = 0;
        for (List<Integer> num : nums) {
            n += num.size();
            maxCol = Math.max(maxCol, num.size());
        }
        int[] res = new int[n];
        int index = 0;
        int col = 0;
        for (int i = 0; i < maxCol + nums.size(); i++) {
            int row = i;
            while (row >= 0 && col < maxCol) {
                if (row < nums.size() && col < nums.get(row).size()) {
                    res[index++] = nums.get(row).get(col);
                }
                row--;
                col++;
            }
            col = 0;
        }
        return res;
    }


    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                list.add(new int[]{i + j, j, nums.get(i).get(j)});
            }
        }
        list.sort(((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]));
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i)[2];
        }
        return res;

    }

    @Test
    public void test() {
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(new ArrayList<>());
        for (int i = 1; i < 5; i++) {
            nums.get(0).add(i);
        }
        System.out.println(Arrays.toString(findDiagonalOrder1(nums)));
    }
}
