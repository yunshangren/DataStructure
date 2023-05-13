package solution8;

/**
 * @author Acer
 * @create 2023/4/4 14:56
 */
public class MinOperations {
    public int minOperations(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int res1 = 0; // 1在奇数位，0在偶数位
        int res2 = 0; // 1在偶数位，0在奇数位
        for (int i = 0; i < n; i++) {
            // 奇数位
            if ((i & 1) == 1) {
                if (chars[i] == '0') {
                    res1++;
                }else{
                    res2++;
                }
            } else {
                if(chars[i] == '1'){
                    res1++;
                }else{
                    res2++;
                }
            }
        }
        return Math.min(res1, res2);
    }
}
