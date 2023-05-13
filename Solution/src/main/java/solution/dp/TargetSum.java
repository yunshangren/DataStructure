package solution.dp;

import org.junit.Test;

/**
 * @author Acer
 * @create 2022/11/6 16:18
 */
public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        return process(nums,target,0);
    }

    public int process(int[] nums, int target, int step){
        if(step == nums.length){
            return target == 0 ? 1 : 0;
        }
        return process(nums,target - nums[step],step + 1)
                + process(nums,target + nums[step],step + 1);

    }

    @Test
    public void test(){
        int[] arr = {1,1,1,1,1};
        System.out.println(findTargetSumWays(arr,3));
    }
}
