package solution8;

/**
 * @author Acer
 * @create 2023/3/31 19:14
 */
public class DistinctSubseqII {
    public int distinctSubseqII(String s) {
        int[] arr = new int[26];
        int res = 1;
        int m = 1000000007;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            // 纯新增 = 上一个总和 - 上一个c字符新增
            int newAdd = (res - arr[c - 'a'] + m) % m;
            res = (res + newAdd) % m;
            arr[c - 'a'] = (arr[c - 'a'] + newAdd) % m;
        }
        return (res - 1 + m) % m;
    }
}
