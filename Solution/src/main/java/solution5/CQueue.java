package solution5;

import org.junit.Test;

import java.util.Stack;

/**
 * @author Acer
 * @create 2023/3/14 10:21
 */
public class CQueue {
    // 两个栈实现一个队列
    Stack<Integer> pushStack;
    Stack<Integer> popStack;
    public CQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void appendTail(int value) {
        pushStack.push(value);
    }

    public int deleteHead() {
        if(popStack.isEmpty() && pushStack.isEmpty()){
            return -1;
        }else if(!popStack.isEmpty()){
            return popStack.pop();
        }else{
            dao();
            return popStack.pop();
        }
    }

    public void dao(){
        while (!pushStack.isEmpty()){
            popStack.push(pushStack.pop());
        }
    }

    @Test
    public void test(){
        CQueue queue = new CQueue();
        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);
        queue.appendTail(4);

        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        queue.appendTail(5);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }
}
