package solution10;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author Acer
 * @create 2023/4/13 15:34
 */
public class WordLengthMaxProduct {
    public int maxProduct(String[] words) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int mask = getMask(word);
            if (map.containsKey(mask)) {
                if (word.length() > map.get(mask)) {
                    map.put(mask, word.length());
                }
            } else {
                map.put(mask, word.length());
            }
        }
        int res = 0;
        for (Integer i : map.keySet()) {
            for (Integer j : map.keySet()) {
                if ((i & j) == 0) {
                    res = Math.max(res, map.get(i) * map.get(j));
                }
            }
        }
        return res;
    }

    public int getMask(String s) {
        int mask = 0;
        for (int i = 0; i < s.length(); i++) {
            mask |= 1 << (s.charAt(i) - 'a');
        }
        return mask;
    }

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        String[] words = {"bdcecbcadca", "caafd", "bcadc", "eaedfcd", "fcdecf", "dee", "bfedd", "ffafd", "eceaffa", "" +
                "caabe", "fbdb", "acafbccaa", "cdc", "ecfdebaafde", "cddbabf", "adc", "cccce", "cbbe", "beedf", "fafbfdcb",
                "ceecfabedbd", "aadbedeaf", "cffdcfde", "fbbdfdccce", "ccada", "fb", "fa", "ec", "dddafded", "accdda", "acaad",
                "ba", "dabe", "cdfcaa", "caadfedd", "dcdcab", "fadbabace", "edfdb", "dbaaffdfa", "efdffceeeb", "aefdf", "fbadcfcc",
                "dcaeddd", "baeb", "beddeed", "fbfdffa", "eecacbbd", "fcde", "fcdb", "eac", "aceffea", "ebabfffdaab", "eedbd", "fdeed",
                "aeb", "fbb", "ad", "bcafdabfbdc", "cfcdf", "deadfed", "acdadbdcdb", "fcbdbeeb", "cbeb", "acbcafca", "abbcbcbaef",
                "aadcafddf", "bd", "edcebadec", "cdcbabbdacc", "adabaea", "dcebf", "ffacdaeaeeb", "afedfcadbb", "aecccdfbaff",
                "dfcfda", "febb", "bfffcaa", "dffdbcbeacf", "cfa", "eedeadfafd", "fcaa", "addbcad", "eeaaa", "af", "fafc",
                "bedbbbdfae", "adfecadcabe", "efffdaa", "bafbcbcbe", "fcafabcc", "ec", "dbddd", "edfaeabecee", "fcbedad",
                "abcddfbc", "afdafb", "afe", "cdad", "abdffbc", "dbdbebdbb"};
        System.out.println(maxProduct(words));
    }
}

