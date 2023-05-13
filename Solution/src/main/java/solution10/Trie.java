package solution10;

/**
 * @author Acer
 * @create 2023/4/16 21:28
 */
public class Trie {
    static class TrieNode {
        int pass;
        int end;
        TrieNode[] next;

        public TrieNode() {
            pass = 0;
            end = 0;
            next = new TrieNode[26];
        }
    }

    private TrieNode root;


    public Trie() {
        root = new TrieNode();
    }


    public void insert(String word) {
        if (word == null) {
            return;
        }
        char[] chars = word.toCharArray();
        TrieNode node = root;
        node.pass++;
        for (char c : chars) {
            int index = c - 'a';
            if (node.next[index] == null) {
                node.next[index] = new TrieNode();
            }
            node = node.next[index];
            node.pass++;
        }
        node.end++;
    }

    public void delete(String word) {
        if (word == null) {
            return;
        }
        char[] chars = word.toCharArray();
        TrieNode node = root;
        node.pass--;
        for (char c : chars) {
            int index = c - 'a';
            if(--node.next[index].pass == 0){
                node.next[index] = null;
                return;
            }
            node = node.next[index];
        }
        node.end--;
    }

    public boolean search(String word) {
        if (word == null) {
            return false;
        }
        char[] chars = word.toCharArray();
        TrieNode node = root;
        for (char c : chars) {
            int index = c - 'a';
            if (node.next[index] == null) {
                return false;
            }
            node = node.next[index];
        }
        return node.end > 0;
    }

    public boolean startsWith(String prefix) {
        if (prefix == null) {
            return false;
        }
        char[] chars = prefix.toCharArray();
        TrieNode node = root;
        for (char c : chars) {
            int index = c - 'a';
            if (node.next[index] == null) {
                return false;
            }
            node = node.next[index];
        }
        return node.pass > 0;
    }
}
