package solution11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Acer
 * @create 2023/4/18 13:56
 */
public class CourseSchedule {
    List<List<Integer>> adj = new ArrayList<>();
    boolean[] visited;
    boolean[] onPath;
    boolean hasCycle = false;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
        }
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            dfs(i);
        }
        return !hasCycle;
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
        onPath[cur] = false;
    }

}
