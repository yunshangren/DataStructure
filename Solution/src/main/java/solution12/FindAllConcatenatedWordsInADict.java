package solution12;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Acer
 * @create 2023/5/31 16:16
 */
public class FindAllConcatenatedWordsInADict {
    static class Trie {
        Trie[] next = new Trie[26];
        boolean isWord = false;
    }

    Trie root = new Trie();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        for (String word : words) {
            if (dfs(word, new boolean[word.length()], 0)) {
                res.add(word);
            } else {
                insert(word);
            }
        }
        return res;
    }

    public void insert(String word) {
        Trie node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.next[index] == null) {
                node.next[index] = new Trie();
            }
            node = node.next[index];
        }
        node.isWord = true;
    }

    public boolean dfs(String word, boolean[] visited, int index) {
        if (index == word.length()) {
            return true;
        }
        if (visited[index]) {
            return false;
        }
        visited[index] = true;
        Trie node = root;
        for (int i = index; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.next[c - 'a'] == null) {
                return false;
            }
            node = node.next[c - 'a'];
            if (node.isWord) {
                if (dfs(word, visited, i + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void test() {
        String[] words = {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
        System.out.println(findAllConcatenatedWordsInADict(words));
    }
}
