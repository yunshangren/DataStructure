package solution3;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/2/27 19:55
 */
public class MaxScoreWords {
    String[] words;
    int[] score;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        this.words = words;
        this.score = score;
        int[] letterCount = new int[26];
        for (char letter : letters) {
            letterCount[letter - 'a']++;
        }
        return process(0, letterCount);
    }

    public int process(int cur, int[] letterCount) {
        if (cur == words.length) {
            return 0;
        }
        String word = words[cur];
        int res = process(cur + 1, letterCount);
        int[] tmp = letterCount.clone();
        int s = 0;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (tmp[index] == 0) {
                return res;
            } else {
                tmp[index]--;
                s += score[index];
            }
        }
        return Math.max(res, s + process(cur + 1, tmp));
    }

    /*public boolean canSpell(String word, int[] letterCount) {
        int[] temp = new int[26];
        for (int i = 0; i < word.length(); i++) {
            temp[word.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (temp[i] > letterCount[i]) {
                return false;
            }
        }
        return true;
    }*/

    @Test
    public void test() {
        String[] words = {"dog", "cat", "dad", "good"};
        char[] letters = {'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'};
        int[] score = {1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(maxScoreWords(words, letters, score));
    }
}
