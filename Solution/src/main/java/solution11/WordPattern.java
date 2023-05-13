package solution11;

import java.util.HashMap;

/**
 * @author Acer
 * @create 2023/5/3 14:15
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        HashMap<String, Character> wordPatternMap = new HashMap<>();
        HashMap<Character, String> patternWordMap = new HashMap<>();
        String[] words = s.split(" ");
        char[] chars = pattern.toCharArray();
        if (chars.length != words.length) {
            return false;
        }
        for (int i = 0; i < chars.length; i++) {
            if (wordPatternMap.containsKey(words[i]) && wordPatternMap.get(words[i]) != chars[i]) {
                return false;
            }
            if (patternWordMap.containsKey(chars[i]) && !patternWordMap.get(chars[i]).equals(words[i])) {
                return false;
            }
            wordPatternMap.putIfAbsent(words[i], chars[i]);
            patternWordMap.putIfAbsent(chars[i], words[i]);
        }
        return true;
    }
}
