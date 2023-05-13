package solution5;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/3/13 16:02
 */
public class MinNumberOfHours {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        // 比赛开始前就要训练好
        int res = 0;
        int needEnergy = 0;
        for (int i : energy) {
            needEnergy += i;
        }
        if(needEnergy >= initialEnergy){
            res += needEnergy + 1 - initialEnergy;
        }
        for (int i : experience) {
            if(initialExperience <= i){
                int diff = i - initialExperience + 1;
                res += diff;
                initialExperience += diff;
            }
            initialExperience += i;
        }
        return res;
    }

    @Test
    public void test() {
        int[] hp = {1, 1, 1, 1};
        int[] exp = {1, 1, 1, 50};
        System.out.println(minNumberOfHours(1, 1, hp, exp));
    }
}
