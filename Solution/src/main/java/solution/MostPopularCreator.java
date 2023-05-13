package solution;

import org.junit.Test;

import java.util.*;

/**
 * @author Acer
 * @create 2022/11/1 16:32
 */
public class MostPopularCreator {
    static class Info {
        String id;
        int view;

        public Info(String id, int view) {
            this.id = id;
            this.view = view;
        }

    }

    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        HashMap<String, Info> map = new HashMap<>();
        HashMap<String, Integer> sumMap = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        int max = 0;
        int n = creators.length;
        for (int i = 0; i < n; i++) {
            String key = creators[i];
            if (!map.containsKey(key)
                    || views[i] > map.get(key).view
                    || (views[i] == map.get(key).view && ids[i].compareTo(map.get(key).id) < 0)) {
                map.put(key, new Info(ids[i], views[i]));
            }
            sumMap.put(key, sumMap.getOrDefault(key, 0) + views[i]);
        }

        Set<String> keySet = sumMap.keySet();
        List<String> list = new ArrayList<>();
        for (String key : keySet) {
            max = Math.max(max, sumMap.get(key));
        }
        for (String key : keySet) {
            if (sumMap.get(key) == max) {
                list.add(key);
            }
        }
        for (String key : list) {
            List<String> temp = new ArrayList<>();
            temp.add(key);
            temp.add(map.get(key).id);
            res.add(temp);
        }
        return res;
    }

    @Test
    public void test() {
        String[] creators = {"alice", "bob", "alice", "chris"};
        String[] ids = {"a", "two", "aa", "four"};
        int[] views = {5, 10, 5, 4};
        List<List<String>> res = mostPopularCreator(creators, ids, views);
        for (List<String> list : res) {
            System.out.println(list);
        }
    }

    @Test
    public void test1() {

    }
}
