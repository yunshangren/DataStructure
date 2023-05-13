package solution10;

/**
 * @author Acer
 * @create 2023/4/13 14:48
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int carry = 0;
        int p1 = chars1.length - 1;
        int p2 = chars2.length - 1;
        StringBuilder builder = new StringBuilder();
        while (p1 >= 0 || p2 >= 0) {
            int sum = carry;
            if (p1 >= 0) {
                sum += chars1[p1--] - '0';
            }
            if (p2 >= 0) {
                sum += chars2[p2--] - '0';
            }
            carry = sum > 9 ? 1 : 0;
            sum %= 10;
            builder.append(sum);
        }
        if (carry == 1) {
            builder.append(1);
        }
        return builder.reverse().toString();
    }

    public int[] plusOne(int[] digits) {
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            carry = digits[i] > 9 ? 1 : 0;
            if (carry == 0) {
                break;
            }
            digits[i] %= 10;
        }
        if (carry == 1) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }
}
