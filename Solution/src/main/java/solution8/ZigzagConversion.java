package solution8;

/**
 * @author Acer
 * @create 2023/3/31 16:41
 */
public class ZigzagConversion {
    public String convert(String s, int numRows) {
        int n = s.length();
        if (numRows == 1 || numRows >= n) {
            return s;
        }

        StringBuilder builder = new StringBuilder();
        int period = (numRows - 1) << 1;
        for (int i = 0; i < numRows; i++) {
            int index = i;
            if (i == 0 || i == numRows - 1) {
                while (index < n) {
                    builder.append(s.charAt(index));
                    index += period;
                }
            } else {
                int secondIndex = period - i;
                while (index < n || secondIndex < n) {
                    if (index < n) {
                        builder.append(s.charAt(index));
                        index += period;
                    }
                    if (secondIndex < n) {
                        builder.append(s.charAt(secondIndex));
                        secondIndex += period;
                    }
                }
            }
        }
        return builder.toString();
    }
}
