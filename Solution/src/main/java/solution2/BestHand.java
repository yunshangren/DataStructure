package solution2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Acer
 * @create 2023/2/20 13:16
 */
public class BestHand {
    public String bestHand(int[] ranks, char[] suits) {
        // 判断是否是同花
        HashSet<Character> suitSet = new HashSet<>();
        for (char suit : suits) {
            suitSet.add(suit);
        }
        if (suitSet.size() == 1) {
            return "Flush";
        }
        // 判断是否有三条
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int rank : ranks) {
            map.put(rank, map.getOrDefault(rank, 0) + 1);
        }
        if (map.size() < 3) {
            return "Three of a Kind";
        }
        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            if (map.get(key) == 3) {
                return "Three of a Kind";
            }
        }
        //
        if (map.size() != ranks.length) {
            return "Pair";
        } else {
            return "High Card";
        }
    }
}
