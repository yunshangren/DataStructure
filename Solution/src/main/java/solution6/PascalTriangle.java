package solution6;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Acer
 * @create 2023/3/18 15:55
 */
public class PascalTriangle {
    // 1 <= numRows <= 30
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> path = new LinkedList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    path.add(1);
                } else {
                    path.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }

            }
            res.add(path);
        }
        return res;
    }
}
