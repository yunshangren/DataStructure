package solution5;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Acer
 * @create 2023/3/14 14:00
 */
public class MyStack {
    Queue<Integer> pushQueue;
    Queue<Integer> popQueue;

    public MyStack() {
        pushQueue = new LinkedList<>();
        popQueue = new LinkedList<>();
    }

    public void push(int x) {
        pushQueue.add(x);
    }

    // 每次调用 pop 和 top 都保证栈不为空
    public int pop() {
        while (pushQueue.size() > 1) {
            popQueue.add(pushQueue.poll());
        }
        int res = pushQueue.poll();
        Queue<Integer> temp = pushQueue;
        pushQueue = popQueue;
        popQueue = temp;
        return res;
    }

    public int top() {
        int res = pop();
        push(res);
        return res;
    }

    public boolean empty() {
        return pushQueue.isEmpty() && popQueue.isEmpty();
    }
}
