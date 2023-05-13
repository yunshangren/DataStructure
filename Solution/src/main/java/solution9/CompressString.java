package solution9;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/4/7 15:33
 */
public class CompressString {
    public String compressString(String S) {
        StringBuilder builder = new StringBuilder();
        if (S.length() == 0) {
            return S;
        }
        int cur = 0;
        int cnt = 1;
        int index = 1;
        while (index < S.length()) {
            if (S.charAt(cur) == S.charAt(index)) {
                index++;
                cnt++;
            } else {
                builder.append(S.charAt(cur));
                builder.append(cnt);
                cur = index;
                cnt = 0;

                if (builder.length() > S.length()) {
                    return S;
                }
            }
        }
        builder.append(S.charAt(cur));
        builder.append(cnt);
        return builder.length() <= S.length() ? builder.toString() : S;
    }

    @Test
    public void test() {
        String s = "aabcccccaa";
        System.out.println(compressString(s));
    }
}
