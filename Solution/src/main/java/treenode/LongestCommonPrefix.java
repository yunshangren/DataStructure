package treenode;

import org.junit.Test;

/**
 * @author Acer
 * @create 2022/11/1 9:21
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        boolean flag = true;
        int index = 0;
        while (flag) {
            for (String str : strs) {
                if (index == str.length() || str.charAt(index) != strs[0].charAt(index)) {
                    flag = false;
                    break;
                }
            }
            index++;
        }
        return strs[0].substring(0, index - 1);
    }

    @Test
    public void test() {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
