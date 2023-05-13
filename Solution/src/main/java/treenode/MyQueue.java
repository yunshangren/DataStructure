package treenode;

import org.junit.Test;

import java.util.Stack;

/**
 * @author Acer
 * @create 2022/10/27 19:11
 */
public class MyQueue {
    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void appendTail(int value) {
        pushStack.push(value);
        if(popStack.isEmpty()){
            while (!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
    }

    public int deleteHead() {
        if (popStack.isEmpty()){
            return -1;
        }
        int res = popStack.pop();
        if(popStack.isEmpty()){
            while (!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }

        return res;
    }

    @Test
    public void test(){
        MyQueue queue = new MyQueue();
        queue.appendTail(5);
        queue.appendTail(2);
        queue.deleteHead();
        queue.deleteHead();
    }
}
