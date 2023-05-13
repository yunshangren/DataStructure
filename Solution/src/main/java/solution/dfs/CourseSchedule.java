package solution.dfs;

import org.junit.Test;

import java.util.*;

/**
 * @author Acer
 * @create 2022/10/27 13:03
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> preCourseMap = buildGraph(prerequisites);
        Set<Integer> keySet = preCourseMap.keySet();
        boolean[] visited = new boolean[numCourses];
        boolean[] onPath = new boolean[numCourses];
        for (Integer key : keySet) {
            if(visited[key]){
                continue;
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.add(key);
            while (!queue.isEmpty()){
                Integer cur = queue.poll();
                if(onPath[cur]){
                    return false;
                }
                visited[cur] = true;
                onPath[cur] = true;
                queue.addAll(preCourseMap.get(cur));
            }
        }
        return false;
    }


    public HashMap<Integer, List<Integer>> buildGraph(int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            if (!map.containsKey(prerequisite[0])) {
                map.put(prerequisite[0], new ArrayList<>());
            }
            map.get(prerequisite[0]).add(prerequisite[1]);
        }
        return map;
    }


    @Test
    public void test() {
        int[][] arr = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2},

        };
        System.out.println(canFinish(4, arr));
    }
}
