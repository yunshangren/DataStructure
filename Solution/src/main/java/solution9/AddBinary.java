package solution9;

/**
 * @author Acer
 * @create 2023/4/6 19:46
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        char[] chars1 = a.toCharArray();
        char[] chars2 = b.toCharArray();
        int p1 = chars1.length - 1;
        int p2 = chars2.length - 1;
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        while ((p1 >= 0 && chars1[p1] != ' ') || (p2 >= 0 && chars2[p2] != ' ')) {
            int sum = carry;
            if (p1 >= 0 && chars1[p1] != ' ') {
                sum += chars1[p1--] - '0';
            }

            if (p2 >= 0 && chars2[p2] != ' ') {
                sum += chars2[p2--] - '0';
            }
            carry = sum >= 2 ? 1 : 0;
            sum = sum >= 2 ? sum - 2 : sum;
            builder.append(sum);
        }
        if (carry == 1) {
            builder.append(1);
        }
        return builder.reverse().toString();
    }
}
