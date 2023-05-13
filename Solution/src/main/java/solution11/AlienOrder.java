package solution11;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Acer
 * @create 2023/4/18 14:39
 */
public class AlienOrder {
    List<List<Character>> adj = new ArrayList<>();
    StringBuilder builder = new StringBuilder();
    boolean[] visited = new boolean[26];
    boolean[] onPath = new boolean[26];
    boolean[] occur = new boolean[26];
    boolean hasCycle = false;
    boolean error = false;

    public String alienOrder(String[] words) {
        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<>());
        }
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                occur[word.charAt(i) - 'a'] = true;
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            buildAdj(words[i], words[i + 1]);
            if (error) {
                return "";
            }
        }
        for (char c = 'a'; c <= 'z'; c++) {
            if (occur[c - 'a']) {
                dfs(c);
                if (hasCycle) {
                    return "";
                }
            }
        }
        return builder.reverse().toString();
    }

    public void buildAdj(String s, String t) {
        int index = 0;
        int minLen = Math.min(s.length(), t.length());
        while (index < minLen && s.charAt(index) == t.charAt(index)) {
            index++;
        }
        if (index < minLen) {
            adj.get(s.charAt(index) - 'a').add(t.charAt(index));
        } else if (s.length() != minLen) {
            error = true;
        }
    }

    public void dfs(char c) {
        int index = c - 'a';
        if (onPath[index]) {
            hasCycle = true;
        }
        if (visited[index] || hasCycle) {
            return;
        }
        onPath[index] = true;
        visited[index] = true;
        for (Character d : adj.get(index)) {
            dfs(d);
        }
        onPath[index] = false;
        builder.append(c);
    }

    @Test
    public void test() {
        String[] words = {"abc", "ab"};
        System.out.println(alienOrder(words));

    }
}
