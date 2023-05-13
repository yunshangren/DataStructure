package solution;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Acer
 * @create 2022/10/20 9:17
 */
public class TopKFrequent {
    static class Info{
        int val;
        int cnt;

        public Info(int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] res = new int[k];
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Info> queue = new PriorityQueue<>((Comparator.comparingInt(o -> o.cnt)));
        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            if(queue.size() < k){
                queue.add(new Info(key,map.get(key)));
            }else{
                if(map.get(key) >= queue.peek().cnt){
                    queue.add(new Info(key,map.get(key)));
                    queue.poll();
                }
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll().val;
        }
        return res;
    }
}
