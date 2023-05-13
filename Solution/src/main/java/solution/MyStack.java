package solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Acer
 * @create 2022/10/21 14:07
 */
public class MyStack {
    // 两个队列构成一个栈
    Queue<Integer> pushQueue;
    Queue<Integer> popQueue;
    public MyStack() {
        pushQueue = new LinkedList<>();
        popQueue = new LinkedList<>();
    }

    public void push(int x) {
        pushQueue.add(x);
    }

    public int pop() {
        while (pushQueue.size() > 1){
            popQueue.add(pushQueue.poll());
        }
        int value = pushQueue.poll();
        Queue<Integer> temp = popQueue;
        popQueue = pushQueue;
        pushQueue = temp;
        return value;
    }

    public int top() {
        int value = pop();
        push(value);
        return value;
    }

    public boolean empty() {
        return pushQueue.size() == 0;
    }
}
