package solution8;

/**
 * @author Acer
 * @create 2023/4/4 21:43
 */
public class MyAtoi {
    public int myAtoi(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int index = 0;
        //1. 丢弃无用的前导空格
        while (index < n && chars[index] == ' ') {
            index++;
        }
        //2. 如果s全是空格， index == n
        if (index == n) {
            return 0;
        }
        //3. 判断正负
        int sign = 1;
        if(chars[index] == '-'){
            sign = -1;
            index++;
        }else if(chars[index] == '+'){
            index++;
        }
        // 4. 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾
        int res = 0;
        for (int i = index; i < n; i++) {
            char c = chars[i];
            if (c < '0' || c > '9') {
                break;
            }
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && c - '0' > 7)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && c - '0' > 8)) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + sign * (c - '0');
        }
        return res;
    }
}
