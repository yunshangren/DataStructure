package solution;

import org.junit.Test;

/**
 * @author Acer
 * @create 2022/10/20 14:48
 */
public class WashingMachines {
    public int findMinMoves(int[] machines) {
        int sum = 0;
        int n = machines.length;
        for (int machine : machines) {
            sum += machine;
        }
        if (sum % n != 0) {
            return -1;
        }
        int leftSum = 0;
        int leftNeed = 0; // 正数表示需要输出的数量，负数表示需要输入的数量
        int rightNeed = 0;
        int avg = sum / n;
        int minOps = Math.abs(avg - machines[0]);
        for (int i = 1; i < n; i++) {
            leftSum += machines[i - 1];
            leftNeed = leftSum - avg * i;
            rightNeed = sum - leftSum - machines[i] - avg * (n - i - 1);
            if (leftNeed < 0 && rightNeed < 0) {
                minOps = Math.max(minOps, (-leftNeed - rightNeed));
            } else {
                minOps = Math.max(minOps, (Math.max(Math.abs(leftNeed), Math.abs(rightNeed))));
            }
        }
        return minOps;
    }

    @Test
    public void test() {
        int[] arr = {1, 0, 5};
        int minMoves = findMinMoves(arr);
        System.out.println(minMoves);
    }
}
