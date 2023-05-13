package solution2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Acer
 * @create 2023/2/23 19:07
 */
public class CircularPermutation {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            list.add(i ^ (i >> 1));
        }
        List<Integer> res = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) == start){
                index = i;
                break;
            }
        }
        for (int i = index; i < list.size(); i++) {
            res.add(list.get(i));
        }
        for (int i = 0; i < index; i++) {
            res.add(list.get(i));
        }
        return res;
    }

    public List<Integer> circularPermutation1(int n, int start){
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            // 格雷码的公式（i ^ (i >> 1)) 再^start,可以指定p[0] == start
            res.add(i ^ (i >> 1) ^ start);
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(circularPermutation(2,3));
        System.out.println(circularPermutation1(2,3));

    }
}
