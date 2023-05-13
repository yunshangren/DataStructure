package solution2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Acer
 * @create 2023/2/21 17:44
 */
public class VideoStitching {
    public int videoStitching(int[][] clips, int time) {
        // 按照start位置对数组排序
        Arrays.sort(clips, Comparator.comparingInt(o -> o[0]));
        int res = 0;
        int cur = 0;
        int point = 0;
        while(cur < time){
            for (int i = 0; i < clips.length && clips[i][0] <= point; i++) {
                cur = Math.max(cur, clips[i][1]);
            }
            if(cur == point){
                return -1;
            }
            point = cur;
            res++;
        }
        return res;
    }
}
