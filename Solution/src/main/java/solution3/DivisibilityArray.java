package solution3;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Acer
 * @create 2023/2/28 10:39
 */
public class DivisibilityArray {
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        int[] div = new int[n];
        long temp = 0;
        for (int i = 0; i < n; i++) {
            temp = temp * 10 + word.charAt(i) - '0';
            temp %= m;
            if(temp == 0)
                div[i] = 1;
        }
        return div;
    }

    @Test
    public void test(){
        String word = "529282143571";
        System.out.println(Arrays.toString(divisibilityArray(word,4)));
    }
}
