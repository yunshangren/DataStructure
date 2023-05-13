package solution11;

import java.util.*;

/**
 * @author Acer
 * @create 2023/4/28 9:20
 */
public class DinnerPlates {
    List<Deque<Integer>> list;
    int capacity;
    TreeSet<Integer> notFull;

    public DinnerPlates(int capacity) {
        list = new ArrayList<>();
        this.capacity = capacity;
        notFull = new TreeSet<>();
    }

    public void push(int val) {
        if (notFull.isEmpty()) {
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(val);
            list.add(stack);
            if (stack.size() < capacity) {
                notFull.add(list.size() - 1);
            }
        } else {
            int index = notFull.first();
            Deque<Integer> stack = list.get(index);
            stack.push(val);
            if (stack.size() == capacity) {
                notFull.pollFirst();
            }
        }
    }

    public int pop() {
        return popAtStack(list.size() - 1);
    }

    public int popAtStack(int index) {
        if (index < 0 || index >= list.size() || list.get(index).isEmpty()) {
            return -1;
        }
        Deque<Integer> stack = list.get(index);
        int res = stack.pop();
        if (index == list.size() - 1 && stack.isEmpty()) {
            while (!list.isEmpty() && list.get(list.size() - 1).isEmpty()) {
                notFull.remove(list.size() - 1);
                list.remove(list.size() - 1);
            }
        } else {
            notFull.add(index);
        }
        return res;
    }
}
