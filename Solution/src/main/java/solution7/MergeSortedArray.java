package solution7;

import java.util.Arrays;

/**
 * @author Acer
 * @create 2023/3/24 18:06
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}
