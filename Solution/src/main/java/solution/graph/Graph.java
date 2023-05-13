package solution.graph;



import java.util.*;

/**
 * @author Acer
 * @create 2022/10/26 20:45
 */
public class Graph {
    public HashMap<Integer, Point> nodes;
    public HashSet<Edge> edges;

    public Graph(HashMap<Integer, Point> nodes, HashSet<Edge> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }


    public static void bfs(Point point){
        if(point == null){
            return;
        }
        Queue<Point> queue = new LinkedList<>();
        HashSet<Point> set = new HashSet<>();
        queue.add(point);
        set.add(point);
        while (!queue.isEmpty()){
            Point cur = queue.poll();
            System.out.print(cur.value + "\t");
            for (Point next : cur.nexts) {
                if(!set.contains(next)){
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }

    public static void dfs(Point point){
        while (point == null){
            return;
        }
        Stack<Point> stack = new Stack<>();
        HashSet<Point> set = new HashSet<>();
        stack.push(point);
        set.add(point);
        System.out.println(point);
        while (!stack.isEmpty()){
            Point cur = stack.pop();
            for (Point next : cur.nexts) {
                if(!set.contains(next)){
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    break;
                }
            }
        }
    }
}
