package solution10;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author Acer
 * @create 2023/4/14 9:30
 */
public class ReplaceWords {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        HashSet<String> set = new HashSet<>(dictionary);
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 1; j <= word.length(); j++) {
                if (set.contains(word.substring(0, j))) {
                    words[i] = word.substring(0, j);
                    break;
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            builder.append(word);
            builder.append(" ");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    @Test
    public void test() {
        String[] dictionary = {"cat", "bat", "rat"};
        List<String> list = new ArrayList<>(Arrays.asList(dictionary));
        String sentence = "the cattle was rattled by the battery";
        System.out.println(replaceWords(list, sentence));
    }
}
