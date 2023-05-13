package solution8;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/4/3 16:31
 */
public class MaskingPersonalInformation {
    public String maskPII(String s) {
        return Character.isLetter(s.charAt(0)) ? maskEmail(s) : maskPhone(s);
    }

    public String maskEmail(String s) {
        // s 是由大小写英文字母，恰好一个 '@' 字符，以及 '.' 字符组成
        int atIndex = s.indexOf('@');
        s = s.toLowerCase();
        StringBuilder builder = new StringBuilder();
        builder.append(s.charAt(0));
        builder.append("*".repeat(5));
        if (atIndex != 1) {
            builder.append(s.charAt(atIndex - 1));
        }
        builder.append(s.substring(atIndex));
        return builder.toString();
    }

    public String maskPhone(String s) {
        // s 是由数字、空格、字符 '('、')'、'-' 和 '+' 组成
        int n = s.length();
        int lastFour = 0;
        int four = 4;
        int localNum = 0;
        int local = 10;
        int countryCodeLen = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (Character.isDigit(s.charAt(i))) {
                if (--four == 0) {
                    lastFour = i;
                }
                if (--local == 0) {
                    localNum = i;
                }
                if(i < localNum){
                    countryCodeLen++;
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        if (countryCodeLen > 0) {
            builder.append("+");
            builder.append("*".repeat(countryCodeLen));
            builder.append("-");
        }
        builder.append("***-***-");
        for (int i = lastFour; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    @Test
    public void test(){
        String s = "86-(10)12345678";
        System.out.println(maskPII(s));
    }
}
