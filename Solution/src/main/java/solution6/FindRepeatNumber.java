package solution6;

/**
 * @author Acer
 * @create 2023/3/17 10:06
 */
public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while (i < nums.length){
            int index = nums[i];
            if(i != index && index == nums[index]){
                return index;
            }
            if(i == index){
                i++;
                continue;
            }
            nums[i] = nums[index];
            nums[index] = index;
        }
        return -1;
    }
}
