package solution10;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Acer
 * @create 2023/4/17 14:02
 */
public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max = 0;
        for (int i : arr1) {
            max = Math.max(max, i);
        }
        int[] count = new int[max + 1];
        for (int i : arr1) {
            count[i]++;
        }
        int index = 0;
        for (int i : arr2) {
            for (int j = 0; j < count[i]; j++) {
                arr1[index++] = i;
            }
            count[i] = 0;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                for (int j = 0; j < count[i]; j++) {
                    arr1[index++] = i;
                }
            }
        }
        return arr1;
    }

    @Test
    public void test() {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
    }
}
