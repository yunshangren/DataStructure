package solution8;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Acer
 * @create 2023/3/31 10:59
 */
public class Rand10 {
    static int[] arr = new int[7];

    static {
        for (int i = 0; i < 7; i++) {
            arr[i] = i + 1;
        }
    }

    public int rand7() {
        int index = (int) (Math.random() * 7);
        return arr[index];
    }

    public int rand(){
        int temp = rand7();
        return temp == 4 ? rand() : temp < 4 ? 0 : 1;
    }

    public int rand10(){
        int res = 0;
        for(int i = 0; i < 4; i++){
            res |= (rand() << i);
        }
        return res < 10 ? res + 1 : rand10();
    }

    @Test
    public void test(){
        int[] arr = new int[10];
        for (int i = 0; i < 1000000; i++) {
            arr[rand10() - 1]++;
        }
        System.out.println(Arrays.toString(arr));
    }
}
