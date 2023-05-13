package solution11;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/4/28 10:45
 */
public class NumTilePossibilities {
    int res = 0;

    public int numTilePossibilities(String tiles) {
        int[] count = new int[26];
        for (char c : tiles.toCharArray()) {
            count[c - 'A']++;
        }
        dfs(count);
        return res;
    }

    public void dfs(int[] count) {
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                res++;
                count[i]--;
                dfs(count);
                count[i]++;
            }
        }
    }

    @Test
    public void test() {
        String tiles = "AAB";
        System.out.println(numTilePossibilities(tiles));
    }
}
