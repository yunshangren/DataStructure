package solution4;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Acer
 * @create 2023/3/3 10:23
 */
public class GetFolderNames {
    public String[] getFolderNames(String[] names) {
        HashMap<String, Integer> map = new HashMap<>();
        int n = names.length;
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            String name = names[i];
            if (!map.containsKey(name)) {
                res[i] = name;
                map.put(name, 1);
            } else {
                int k = map.get(name);
                String str;
                while (map.containsKey(str = addSuffix(name, k))) {
                    k++;
                }
                res[i] = str;
                map.put(name, map.get(name) + 1);
                map.put(str, 1);
            }
        }
        return res;
    }

    public String addSuffix(String name, int k) {
        return name + "(" + k + ")";
    }

    @Test
    public void test() {
        String[] names = {"kaido", "kaido(1)", "kaido", "kaido(1)"};
        System.out.println(Arrays.toString(getFolderNames(names)));
    }
}
