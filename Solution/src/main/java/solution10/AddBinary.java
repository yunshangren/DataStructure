package solution10;

/**
 * @author Acer
 * @create 2023/4/12 20:32
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        char[] chars1 = a.toCharArray();
        char[] chars2 = b.toCharArray();
        int p1 = chars1.length - 1;
        int p2 = chars2.length - 1;
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        while (p1 >= 0 || p2 >= 0) {
            int sum = carry;
            if (p1 >= 0) {
                sum += chars1[p1--] == '1' ? 1 : 0;
            }
            if (p2 >= 0) {
                sum += chars2[p2--] == '1' ? 1 : 0;
            }
            carry = sum > 1 ? 1 : 0;
            sum = sum > 1 ? sum - 2 : sum;
            builder.append(sum);
        }
        if (carry == 1) {
            builder.append(1);
        }
        return builder.reverse().toString();
    }
}
