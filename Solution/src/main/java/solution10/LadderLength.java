package solution10;

import org.junit.Test;

import java.util.*;

/**
 * @author Acer
 * @create 2023/4/16 13:50
 */
public class LadderLength {
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dic = new HashSet<>(wordList);
        int step = 0;
        if (!dic.contains(endWord)) {
            return step;
        }
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        step++;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                visited.add(s);
                if (s.equals(endWord)) {
                    return step;
                }
                for (String t : dic) {
                    if (!visited.contains(t) && check(s, t)) {
                        queue.add(t);
                    }
                }
            }
            step++;
        }
        return 0;
    }

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dic = new HashSet<>(wordList);
        if (!dic.contains(endWord)) {
            return 0;
        }
        HashSet<String> beginSet = new HashSet<>();
        HashSet<String> endSet = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        int step = 1;
        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            // 在双向 BFS 算法中，如果我们每次都选择一个较小的集合进行扩散，
            // 那么占用的空间增长速度就会慢一些，效率就会高一些。
            if (beginSet.size() > endSet.size()) {
                HashSet<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            HashSet<String> temp = new HashSet<>();
            for (String s : beginSet) {
                if (endSet.contains(s)) {
                    return step;
                }
                visited.add(s);
                for (String t : dic) {
                    if (!visited.contains(t) && check(s, t)) {
                        temp.add(t);
                    }
                }
            }
            beginSet = temp;
            step++;
        }
        return 0;
    }

    public boolean check(String s, String t) {
        int diff = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }

    @Test
    public void test() {
        String s = "hot";
        String t = "dog";
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dog");
        System.out.println(ladderLength1(s, t, list));
    }
}
