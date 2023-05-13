package solution2;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @author Acer
 * @create 2023/2/20 14:51
 */
public class MaxAverageRatio {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int cnt = classes.length; // 班级个数
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            double v1 = (a[0] * 1.0 + 1) / (a[1] + 1) - a[0] * 1.0 / a[1];
            double v2 = (b[0] * 1.0 + 1) / (b[1] + 1) - b[0] * 1.0 / b[1];
            if (v1 == v2) {
                return 0;
            }
            return v1 > v2 ? -1 : 1;
        });

        for (int i = 0; i < cnt; i++) {
            queue.add(new int[]{classes[i][0], classes[i][1]});
        }
        double res = 0;
        for (int i = 0; i < extraStudents; i++) {
            int[] ints = queue.poll();
            ints[0] = ints[0] + 1;
            ints[1] = ints[1] + 1;
            queue.add(ints);
        }

        for (int i = 0; i < cnt; i++) {
            int[] ints = queue.poll();
            res += (double) ints[0] / ints[1];
        }

        return res / cnt;
    }

    public double maxAverageRatio1(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> deap =
                new PriorityQueue<>((a, b) -> {
                    double result = 0;
                    result += 1.0 * (b[0] + 1) / (b[1] + 1) - 1.0 * b[0] / b[1];
                    result -= 1.0 * (a[0] + 1) / (a[1] + 1) - 1.0 * a[0] / a[1];
                    return result == 0 ? 0 : result > 0 ? 1 : -1;
                });
        for (int[] aClass : classes) {
            deap.add(new int[]{aClass[0], aClass[1]});
        }
        for (int i = 0; i < extraStudents; i++) {
            int[] poll = deap.poll();
            if (poll != null) {
                deap.add(new int[]{poll[0] + 1, poll[1] + 1});
            }
        }
        double answer = 0;
        for (int[] ints : deap) {
            answer += ints[0] * 1.0 / ints[1];
        }
        return answer / classes.length;
    }


    @Test
    public void test() {
        int[][] classes = {
                {2, 4},
                {3, 9},
                {4, 5},
                {2, 10}
        };
        System.out.println(maxAverageRatio(classes, 4));
        System.out.println(maxAverageRatio1(classes, 4));

    }
}
