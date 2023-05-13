package solution4;

import java.util.HashSet;
import java.util.List;

/**
 * @author Acer
 * @create 2023/3/6 15:48
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        int[] memo = new int[s.length()];
        return dfs(s,dict,memo,0);
    }

    public boolean dfs(String s, HashSet<String> dict, int[] memo, int index) {
        if (index == s.length()) {
            return true;
        }
        if (memo[index] == -1) {
            return false;
        }
        for (int i = index + 1; i <= Math.min(index + 20,s.length()); i++) {
            if(!dict.contains(s.substring(index,i))){
                continue;
            }
            if(dfs(s,dict,memo,i)){
                return true;
            }
        }
        memo[index] = -1;
        return false;
    }

}
