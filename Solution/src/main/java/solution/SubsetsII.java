package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 1; i <= nums.length; i++) {
            backtrack(nums,res,list,0,i);
        }
        return res;
    }

    public void backtrack(int[] nums, List<List<Integer>> res, List<Integer> list, int startIndex, int size) {
        if(size == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if(i > startIndex && nums[i] == nums[i - 1]){
                continue;
            }
            if(size > 0){
                list.add(nums[i]);
                backtrack(nums,res,list,i + 1,size - 1);
                list.remove(list.size() - 1);
            }
        }
    }

    @Test
    public void test(){
        int[] nums = {4,4,4,1,4};
        List<List<Integer>> lists = subsetsWithDup(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
