package solution2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Acer
 * @create 2023/2/18 16:43
 */
public class FindSolution {
    public List<List<Integer>> findSolution1(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i < 1001; i++) {
            for (int j = 1; j < 1001; j++) {
                if (customfunction.f(i, j) == z) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    res.add(temp);
                }
            }
        }
        return res;
    }

    public List<List<Integer>> findSolution2(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        for (int x = 1; x < 1001; x++) {
            int left = 1;
            int right = 1000;
            while (left <= right) {
                int y = (left + right) >> 1;
                int value = customfunction.f(x, y);
                if (value == z) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(x);
                    temp.add(y);
                    res.add(temp);
                    break;
                }
                if (value < z) {
                    left = y + 1;
                } else {
                    right = y - 1;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> findSolution3(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        int y = 1000;
        for (int x = 1; x < 1001; x++) {

        }
        return res;
    }
}


