package solution8;

/**
 * @author Acer
 * @create 2023/4/4 10:52
 */
public class SingleNumbers {
    // 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次,出这两个只出现一次的数字
    public int[] singleNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        /*int div = res & (-res);*/
        int div = res & (~res + 1);
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & div) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(~i + 1);
        }
    }
}
