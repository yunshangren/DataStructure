package solution9;

import java.util.Stack;

/**
 * @author Acer
 * @create 2023/4/10 14:04
 */
public class MyQueue {
    Stack<Integer> pushStack;
    Stack<Integer> popStack;
    /** Initialize your data structure here. */
    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        pushStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(popStack.isEmpty()){
            while (!pushStack.isEmpty()){
                popStack.add(pushStack.pop());
            }
        }
        return popStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(popStack.isEmpty()){
            while (!pushStack.isEmpty()){
                popStack.add(pushStack.pop());
            }
        }
        return popStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }

}
