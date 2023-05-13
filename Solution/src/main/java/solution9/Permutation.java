package solution9;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Acer
 * @create 2023/4/10 9:24
 */
public class Permutation {
    StringBuilder builder = new StringBuilder();
    boolean[] visited;
    List<String> list = new ArrayList<>();

    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        visited = new boolean[chars.length];
        dfs(chars);
        return list.toArray(new String[list.size()]);
    }

    public void dfs(char[] chars) {
        if (builder.length() == chars.length) {
            list.add(builder.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if(i > 0 && chars[i] == chars[i - 1] && visited[i - 1]){
                continue;
            }
            if(!visited[i]){
                builder.append(chars[i]);
                visited[i] = true;
                dfs(chars);
                builder.deleteCharAt(builder.length() - 1);
                visited[i] = false;
            }
        }
    }

    @Test
    public void test() {
        String s = "abbc";
        System.out.println(Arrays.toString(permutation(s)));
    }
}
