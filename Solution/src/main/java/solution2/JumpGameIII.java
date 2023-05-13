package solution2;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Acer
 * @create 2023/2/22 19:23
 */
public class JumpGameIII {
    public boolean canReach(int[] arr, int start) {
        if (arr[start] == 0) {
            return true;
        }
        boolean[] visited = new boolean[arr.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            if (arr[index] == 0) {
                return true;
            }
            visited[index] = true;
            int left = index - arr[index];
            if (left >= 0 && !visited[left]) {
                queue.add(left);
            }
            int right = index + arr[index];
            if (right < arr.length && !visited[right]) {
                queue.add(right);
            }
        }
        return false;
    }


    @Test
    public void test() {
        int[] arr = {1, 1, 1, 1, 1, 1, 1, 1, 0};
        System.out.println(canReach(arr, 3));
    }
}
