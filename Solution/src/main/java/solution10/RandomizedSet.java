package solution10;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Acer
 * @create 2023/4/13 20:12
 */
public class RandomizedSet {
    // 插入、删除和随机访问都是 O(1) 的容器
    Map<Integer, Integer> valueIndexMap;
    Map<Integer, Integer> indexValueMap;
    int size;
    Random random;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        size = 0;
        valueIndexMap = new HashMap<>();
        indexValueMap = new HashMap<>();
        random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (valueIndexMap.containsKey(val)) {
            return false;
        }
        valueIndexMap.put(val, size);
        indexValueMap.put(size, val);
        size++;
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!valueIndexMap.containsKey(val)) {
            return false;
        }
        int deleteIndex = valueIndexMap.get(val);
        int lastIndex = --size;
        int lastIndexValue = indexValueMap.get(lastIndex);

        valueIndexMap.put(lastIndexValue, deleteIndex);
        valueIndexMap.remove(val);

        indexValueMap.put(deleteIndex, lastIndexValue);
        indexValueMap.remove(lastIndex);

        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return indexValueMap.get(random.nextInt(size));
    }


}
