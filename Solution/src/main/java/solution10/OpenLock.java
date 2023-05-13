package solution10;

import org.junit.Test;

import java.util.*;

/**
 * @author Acer
 * @create 2023/4/12 15:46
 */
public class OpenLock {


    public int openLock1(String[] deadends, String target) {
        HashSet<String> set = new HashSet<>();
        Collections.addAll(set, deadends);
        HashSet<String> visited = new HashSet<>();
        String s = "0000";
        if (set.contains(s)) {
            return -1;
        }
        int step = 0;
        visited.add(s);
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String temp = queue.poll();
                if (target.equals(temp)) {
                    return step;
                }
                for (int j = 0; j < s.length(); j++) {
                    String s1 = plusOne(temp, j);
                    if (!set.contains(s1) && !visited.contains(s1)) {
                        queue.add(s1);
                        visited.add(s1);
                    }
                    String s2 = minusOne(temp, j);
                    if (!set.contains(s2) && !visited.contains(s2)) {
                        queue.add(s2);
                        visited.add(s2);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public int openLock2(String[] deadends, String target) {
        HashSet<String> dead = new HashSet<>(Arrays.asList(deadends));
        String begin = "0000";
        if (dead.contains(begin)) {
            return -1;
        }
        if(target.equals(begin)){
            return 0;
        }
        HashSet<String> beginSet = new HashSet<>();
        HashSet<String> endSet = new HashSet<>();
        HashSet<String> visited = new HashSet<>();

        beginSet.add(begin);
        endSet.add(target);
        int step = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                HashSet<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            HashSet<String> temp = new HashSet<>();
            for (String s : beginSet) {
                for (int i = 0; i < s.length(); i++) {
                    String s1 = plusOne(s, i);
                    if (!dead.contains(s1) && !visited.contains(s1)) {
                        temp.add(s1);
                    }
                    String s2 = minusOne(s, i);
                    if (!dead.contains(s2) && !visited.contains(s2)) {
                        temp.add(s2);
                    }
                    if (endSet.contains(s1) || endSet.contains(s2)) {
                        return step;
                    }
                }
                visited.add(s);
            }
            step++;
            beginSet = temp;
        }
        return -1;
    }


    public String plusOne(String s, int index) {
        char[] chars = s.toCharArray();
        int temp = chars[index] - '0';
        temp = (temp + 1) % 10;
        chars[index] = (char) ('0' + temp);
        return new String(chars);
    }

    public String minusOne(String s, int index) {
        char[] chars = s.toCharArray();
        int temp = chars[index] - '0';
        temp = (temp + 9) % 10;
        chars[index] = (char) ('0' + temp);
        return new String(chars);
    }

    @Test
    public void test() {
        String[] strs = {"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        System.out.println(openLock1(strs, "8888"));

    }

}
