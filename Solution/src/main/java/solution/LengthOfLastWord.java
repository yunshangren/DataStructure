package solution;

/**
 * @author Acer
 * @create 2022/10/31 20:45
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int len = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != ' ') {
                len++;
            }else if(len != 0){
                break;
            }
        }
        return len;
    }
}
