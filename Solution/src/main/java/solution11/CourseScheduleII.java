package solution11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Acer
 * @create 2023/4/18 14:19
 */
public class CourseScheduleII {
    List<List<Integer>> adj = new ArrayList<>();
    List<Integer> postOrder = new ArrayList<>();
    boolean[] visited;
    boolean[] onPath;
    boolean hasCycle = false;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[0]).add(prerequisite[1]);
        }
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            dfs(i);
            if (hasCycle) {
                return new int[]{};
            }
        }
        int[] res = new int[numCourses];

        for (int i = 0; i < postOrder.size(); i++) {
            res[i] = postOrder.get(i);
        }
        return res;
    }

    public void dfs(int cur) {
        if (onPath[cur]) {
            hasCycle = true;
        }
        if (visited[cur] || hasCycle) {
            return;
        }
        visited[cur] = true;
        onPath[cur] = true;
        for (Integer i : adj.get(cur)) {
            dfs(i);
        }
        postOrder.add(cur);
        onPath[cur] = false;
    }
}
