package solution10;

/**
 * @author Acer
 * @create 2023/4/17 9:25
 */
public class MagicDictionary {
    static class TrieNode {
        boolean isWord;
        TrieNode[] next;

        public TrieNode() {
            isWord = false;
            next = new TrieNode[26];
        }
    }

    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.next[index] == null) {
                node.next[index] = new TrieNode();
            }
            node = node.next[index];
        }
        node.isWord = true;
    }

    public boolean searchWord(String word) {
        return dfs(word, 0, false, root);
    }

    public boolean dfs(String word, int index, boolean hasDiff, TrieNode node) {
        if (index == word.length()) {
            return node.isWord && hasDiff;
        }
        int idx = word.charAt(index) - 'a';
        if (node.next[idx] != null) {
            if (dfs(word, index + 1, hasDiff, node.next[idx])) {
                return true;
            }
        }
        if (!hasDiff) {
            for (int i = 0; i < 26; i++) {
                if (i != idx && node.next[i] != null) {
                    if (dfs(word, index + 1, true, node.next[i])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public MagicDictionary() {

    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            insert(s);
        }
    }

    public boolean search(String searchWord) {
        return searchWord(searchWord);
    }
}
