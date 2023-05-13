package solution9;

import java.util.Arrays;

/**
 * @author Acer
 * @create 2023/4/7 14:31
 */
public class CheckPermutation {
    public boolean checkPermutation(String s1, String s2) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (char c : s1.toCharArray()) {
            arr1[c - 'a']++;
        }
        for (char c : s2.toCharArray()) {
            arr2[c - 'a']++;
        }
        return Arrays.equals(arr1, arr2);
    }
}
