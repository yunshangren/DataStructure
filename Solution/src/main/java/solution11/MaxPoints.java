package solution11;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

/**
 * @author Acer
 * @create 2023/5/3 17:44
 */
public class MaxPoints {
    static class Info {
        Double k;
        Double b;
        Double x;

        public Info(double k, double b) {
            this.k = k;
            this.b = b;
        }

        public Info(double x) {
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Info)) return false;
            Info info = (Info) o;
            return Objects.equals(k, info.k) && Objects.equals(b, info.b) && Objects.equals(x, info.x);
        }

        @Override
        public int hashCode() {
            return Objects.hash(k, b, x);
        }
    }

    public int maxPoints(int[][] points) {
        HashMap<Info, HashSet<Integer>> map = new HashMap<>();
        int n = points.length;
        if (n == 1) {
            return 1;
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int x = (points[j][0] - points[i][0]);
                Info info;
                if (x == 0) {
                    info = new Info(points[i][0]);
                } else {
                    double k = (points[j][1] - points[i][1]) * 1.0 / x;
                    double b = points[i][1] - points[i][0] * k;
                    info = new Info(k, b);
                }

                if (!map.containsKey(info)) {
                    HashSet<Integer> set = new HashSet<>();
                    set.add(i);
                    set.add(j);
                    map.put(info, set);
                } else {
                    map.get(info).add(i);
                    map.get(info).add(j);
                }
            }
        }
        int max = 0;
        for (Info info : map.keySet()) {
            max = Math.max(max, map.get(info).size());
        }
        return max;
    }
}
