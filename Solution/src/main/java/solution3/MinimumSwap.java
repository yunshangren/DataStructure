package solution3;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/2/25 16:07
 */
public class MinimumSwap {
    public int minimumSwap(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return -1;
        }
        int diff = 0;
        int xCnt = 0;
        for (int i = 0; i < s1.length(); i++) {

            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
                if(s1.charAt(i) == 'x'){
                    xCnt++;
                }
            }
        }

        if (diff % 2 != 0) {
            return -1;
        }
        return (diff >> 1) + xCnt % 2;

    }



    @Test
    public void test(){
        String s1 = "xxyyxyxyxx";
        String s2 = "xyyxyxxxyx";
        System.out.println(minimumSwap(s1,s2));
    }
}
