package solution.singleStack;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Acer
 * @create 2022/10/28 16:53
 */
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i],i);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < res.length; i++) {
            int index = map.get(nums1[i]);
            res[i] = -1;
            for (int j = index + 1; j < nums2.length; j++) {
                if(nums2[j] > nums1[i]){
                    res[i] = nums2[j];
                    break;
                }
            }
        }
        return res;
    }
    @Test
    public void test(){
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] res = nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }
}
