package solution;

import org.junit.Test;

/**
 * @author Acer
 * @create 2022/11/2 19:57
 */
public class Search {
    public boolean search(int[] nums, int target) {
        int rotate = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i - 1]){
                rotate = i;
                break;
            }
        }
        boolean res1 = binarySearch(nums, 0, rotate - 1, target);
        boolean res2 = binarySearch(nums, rotate, nums.length - 1, target);
        return res1 || res2;
    }

    public boolean binarySearch(int[] arr, int start, int end, int target){
        while (start <= end){
            int mid = start + ((end - start) >> 1);
            if(arr[mid] < target){
                start = mid + 1;
            }else if(arr[mid] > target){
                end = mid - 1;
            }else{
                return true;
            }
        }
        return false;
    }

    @Test
    public void test(){
        int[] arr = {1,0,1,1,1};
        System.out.println(search(arr,0));
    }
}
