package solution.slidingWindow;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Acer
 * @create 2022/10/20 18:26
 */
public class LetterCombinations {


    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtrack(digits, res, new StringBuilder(), 0, map);
        return res;
    }

    public void backtrack(String digits, List<String> res, StringBuilder builder, int index, HashMap<Character, String> map) {
        if (builder.length() == digits.length()) {
            res.add(builder.toString());
            return;
        }
        String letters = map.get(digits.charAt(index));
        for (int i = 0; i < letters.length(); i++) {
            builder.append(letters.charAt(i));
            backtrack(digits, res, builder, index + 1, map);
            builder.deleteCharAt(builder.length() - 1);
        }

    }

    @Test
    public void test() {
        String s = "23";
        List<String> list = letterCombinations(s);
        System.out.println(list);
    }


}
