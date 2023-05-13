package solution.graph;

import java.util.ArrayList;

/**
 * @author Acer
 * @create 2022/10/27 9:48
 */
public class Point {
    public int value;
    public int in;
    public int out;
    public ArrayList<Point> nexts;
    public ArrayList<Edge> edges;

    public Point(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<Edge>();
    }

    @Override
    public String toString() {
        return "Point{" +
                "value=" + value +
                ", nexts=" + nexts +
                '}';
    }
}
