package solution2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Acer
 * @create 2023/2/23 19:03
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            res.add(i ^ (i >> 1));
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(grayCode(3));
        System.out.println(grayCode(4));
        System.out.println(grayCode(5));
    }
}
