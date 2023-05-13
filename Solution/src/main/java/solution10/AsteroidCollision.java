package solution10;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Acer
 * @create 2023/4/16 15:58
 */
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        int[] stack = new int[n];
        int size = 0;
        boolean pos = false;
        for (int asteroid : asteroids) {
            if (asteroid < 0 && !pos) {
                stack[size++] = asteroid;
            } else if (asteroid > 0) {
                stack[size++] = asteroid;
                pos = true;
            } else {
                while (size > 0 && stack[size - 1] > 0 && stack[size - 1] < -asteroid) {
                    size--;
                }
                if (size > 0 && stack[size - 1] == -asteroid) {
                    size--;
                    continue;
                }
                if (size == 0 || stack[size - 1] < 0) {
                    pos = false;
                }
                if (!pos) {
                    stack[size++] = asteroid;
                }
            }
        }
        int[] res = new int[size];
        System.arraycopy(stack, 0, res, 0, size);
        return res;
    }

    @Test
    public void test() {
        int[] arr = {8, -8};
        System.out.println(Arrays.toString(asteroidCollision(arr)));
    }
}
