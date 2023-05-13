package solution8;

import java.util.PriorityQueue;

/**
 * @author Acer
 * @create 2023/4/3 12:14
 */
public class MedianFinder {
    PriorityQueue<Integer> queueMin;
    PriorityQueue<Integer> queueMax;

    public MedianFinder() {
        queueMin = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        queueMax = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (queueMin.isEmpty() || num <= queueMin.peek()) {
            queueMin.add(num);
            if (queueMin.size() - queueMax.size() > 1) {
                queueMax.add(queueMin.poll());
            }
        } else {
            queueMax.add(num);
            if (queueMax.size() > queueMin.size()) {
                queueMin.add(queueMax.poll());
            }
        }
    }

    public double findMedian() {
        return queueMin.size() == queueMax.size()
                ? (queueMin.peek() + queueMax.peek()) * 1.0 / 2
                : queueMin.peek();
    }
}
