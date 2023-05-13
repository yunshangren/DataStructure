package solution9;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Acer
 * @create 2023/4/10 13:38
 */
public class StackOfPlates {
    LinkedList<Stack<Integer>> list = new LinkedList<>();
    int stackSize;

    public StackOfPlates(int cap) {
        stackSize = cap;
    }

    public void push(int val) {
        if(stackSize <= 0){
            return;
        }
        if (list.size() == 0 || list.getLast().size() == stackSize) {
            list.add(new Stack<>());
        }
        list.getLast().push(val);
    }

    public int pop() {
        if (list.size() == 0 || list.getLast().size() == 0 || stackSize <= 0) {
            return -1;
        }
        int temp = list.getLast().pop();
        if (list.getLast().size() == 0) {
            list.removeLast();
        }
        return temp;
    }

    public int popAt(int index) {
        if (index < 0 || index >= list.size() || stackSize <= 0) {
            return -1;
        }
        int temp = list.get(index).pop();
        if (list.get(index).size() == 0) {
            list.remove(index);
        }
        return temp;
    }
}
