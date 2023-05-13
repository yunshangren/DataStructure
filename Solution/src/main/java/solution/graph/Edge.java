package solution.graph;

/**
 * @author Acer
 * @create 2022/10/27 9:53
 */
public class Edge {
    public int weight;
    public Point from;
    public Point to;

    public Edge(int weight, Point from, Point to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }

    public int arraySign(int[] nums) {
        int res = 1;
        for (int num : nums) {
            if (num < 0) {
                res = -res;
            } else if (num == 0) {
                res = 0;
            }
        }
        return res;

    }
}
