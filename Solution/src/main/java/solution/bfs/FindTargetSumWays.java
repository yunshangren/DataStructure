package solution.bfs;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Acer
 * @create 2022/11/4 11:00
 */
public class FindTargetSumWays {
    public int findTargetSumWays(int[] nums, int target) {
        int curLevel = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(-nums[curLevel]);
        queue.add(nums[curLevel]);
        int ways = 0;
        while (curLevel != nums.length) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int num = queue.poll();
                if (curLevel == nums.length - 1 && num == target) {
                    ways++;
                }
                if (curLevel < nums.length - 1) {
                    queue.add(num - nums[curLevel + 1]);
                    queue.add(num + nums[curLevel + 1]);
                }
            }
            curLevel++;
        }
        return ways;
    }


    public int integerBreak(int n) {
        if(n < 4){
            return n - 1;
        }
        int num = n / 3;
        int mod = n % 3;
        int res;
        if(mod == 0){
            res = (int) Math.pow(3,num);
        }else if(mod == 1){
            res = (int) (Math.pow(3,num - 1) * 4);
        }else{
            res = (int) (Math.pow(3,num) * 2);
        }
        return res;
    }
    @Test
    public void test() {
        int[] nums = {27,33,4,43,31,44,47,6,6,11,39,37,15,16,8,19,48,17,18,39};
        System.out.println(findTargetSumWays(nums, 24));
    }
}
