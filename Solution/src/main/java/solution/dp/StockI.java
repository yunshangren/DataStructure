package solution.dp;

import org.junit.Test;

/**
 * @author Acer
 * @create 2022/11/6 14:39
 */
public class StockI {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int maxProfit = 0;
        int buyPrice = -1;

        for (int i = 0; i < prices.length; i++) {
            if (i + 1 < prices.length && prices[i] < prices[i + 1] && buyPrice == -1) {
                buyPrice = prices[i];
            }
            if (buyPrice != -1 && ((i + 1 < prices.length && prices[i] > prices[i + 1])
                    || (i == prices.length - 1 && prices[i] >= prices[i - 1]))) {
                maxProfit += prices[i] - buyPrice;
                buyPrice = -1;
            }
        }
        return maxProfit;
    }

    @Test
    public void test() {
        int[] arr = {1,9,6,9,1,7,1,1,5,9,9,9};
        System.out.println(maxProfit(arr));
    }
}
