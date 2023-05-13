package solution6;

import org.junit.Test;

import java.util.HashSet;

/**
 * @author Acer
 * @create 2023/3/21 15:25
 */
public class WordCount {
    public int wordCount(String[] startWords, String[] targetWords) {
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (String word : startWords) {
            int mask = 0;
            for (int i = 0; i < word.length(); i++) {
                mask |= 1 << (word.charAt(i) - 'a');
            }
            set.add(mask);
        }

        for (String target : targetWords) {
            int mask = 0;
            char[] chars = target.toCharArray();
            for (char c : chars) {
                mask |= 1 << (c - 'a');
            }
            for (char c : chars) {
                if (set.contains(mask ^ (1 << (c - 'a')))) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }

    //startWords 和 targetWords 中的每个字符串都仅由小写英文字母组成
    public boolean canGet(String word, String target) {
        int[] need = new int[26];
        int needCnt = 0;
        for (int i = 0; i < target.length(); i++) {
            if (need[target.charAt(i) - 'a']++ == 0) {
                needCnt++;
            }
        }
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (need[index] == 0) {
                return false;
            }
            if (--need[index] == 0) {
                needCnt--;
            }
        }
        return needCnt == 1;
    }

    @Test
    public void test() {
        String[] s1 = {"ant", "act", "tack"};
        String[] s2 = {"tack", "act", "acti"};
        System.out.println(wordCount(s1, s2));
    }
}
