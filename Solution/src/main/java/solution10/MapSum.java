package solution10;

/**
 * @author Acer
 * @create 2023/4/17 9:45
 */
public class MapSum {
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

    TrieNode root = new TrieNode();

    public MapSum() {

    }

    public void insert(String key, int val) {
        int temp = search(key);
        if (temp == 0) {
            TrieNode node = root;
            root.pass += val;
            for (char c : key.toCharArray()) {
                int index = c - 'a';
                if (node.next[index] == null) {
                    node.next[index] = new TrieNode();
                }
                node = node.next[index];
                node.pass += val;
            }
            node.end = val;
        } else {
            update(key, temp, val);
        }

    }

    private void update(String key, int src, int val) {
        TrieNode node = root;
        root.pass += val - src;
        for (char c : key.toCharArray()) {
            int index = c - 'a';
            node = node.next[index];
            node.pass += val - src;
        }
        node.end = val;
    }

    public int search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.next[index] == null) {
                return 0;
            }
            node = node.next[index];
        }
        return node.end;
    }

    public int sum(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (node.next[index] == null) {
                return 0;
            }
            node = node.next[index];
        }
        return node.pass;
    }
}
