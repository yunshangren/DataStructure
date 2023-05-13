package solution;

import org.junit.Test;

/**
 * @author Acer
 * @create 2022/11/3 10:54
 */
public class FindMin {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid = left + ((right - left) >> 1);
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }



    @Test
    public void test(){
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(findMin(arr));
    }
}
