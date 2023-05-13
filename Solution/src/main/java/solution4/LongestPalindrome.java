package solution4;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/3/6 18:08
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 1) {
            return s;
        }
        char[] arr = new char[(len << 1) + 1];
        len = arr.length;
        for (int i = 0; i < len; i++) {
            arr[i] = i % 2 != 0 ? s.charAt(i >> 1) : '#';
        }
        int center = 0;
        int maxLen = 1;
        for (int i = 1; i < len; i++) {
            int curLen = 1;
            int radius = 1;
            while (i - radius >=0 && i + radius < len && arr[i - radius] == arr[i + radius]){
                curLen += 2;
                radius++;
            }

            if(curLen > maxLen){
                center = i;
                maxLen = curLen;
            }
        }
        int r = maxLen >> 1;
        StringBuilder builder = new StringBuilder();
        for (int i = center - r; i <= center + r; i++) {
            if(arr[i] != '#'){
                builder.append(arr[i]);
            }
        }
        return builder.toString();
    }

    @Test
    public void test() {
        String s = "abb";
        System.out.println(longestPalindrome(s));
    }
}
