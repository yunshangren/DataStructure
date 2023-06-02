package solution12;

/**
 * @author Acer
 * @create 2023/6/2 13:26
 */
public class VowelStrings {
    //  统计范围内的元音字符串数
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] res = new int[queries.length];
        // 搞个类似前缀和的数组，记录0 ~ i范围内有多少个符合要求
        int n = words.length;
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            count[i] = (isVowelString(words[i]) ? 1 : 0) + (i == 0 ? 0 : count[i - 1]);
        }
        for (int i = 0; i < queries.length; i++) {
            int[] arr = queries[i];
            res[i] = count[arr[1]] - (arr[0] == 0 ? 0 : count[arr[0] - 1]);
        }
        return res;
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public boolean isVowelString(String s) {
        int n = s.length();
        return isVowel(s.charAt(0)) && isVowel(s.charAt(n - 1));
    }
}
