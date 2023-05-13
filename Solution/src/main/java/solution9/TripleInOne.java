package solution9;

/**
 * @author Acer
 * @create 2023/4/10 12:55
 */
public class TripleInOne {
    int[] stack;
    int[] size = new int[3];
    int oneSize;

    public TripleInOne(int stackSize) {
        oneSize = stackSize;
        size[1] = stackSize;
        size[2] = stackSize << 1;
        stack = new int[stackSize * 3];
    }

    public void push(int stackNum, int value) {
        if (size[stackNum] == (stackNum + 1) * oneSize) {
            return;
        }
        stack[size[stackNum]++] = value;

    }

    public int pop(int stackNum) {
        if (size[stackNum] == stackNum * oneSize) {
            return -1;
        }
        return stack[size[stackNum]-- - 1];
    }

    public int peek(int stackNum) {
        if (size[stackNum] == stackNum * oneSize) {
            return -1;
        }
        return stack[size[stackNum] - 1];
    }

    public boolean isEmpty(int stackNum) {
        return size[stackNum] == stackNum * oneSize;
    }
}
