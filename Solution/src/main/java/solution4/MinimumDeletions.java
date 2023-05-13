package solution4;

/**
 * @author Acer
 * @create 2023/3/6 20:19
 */
public class MinimumDeletions {
    //使字符串平衡的最少删除次数
    // 1.字符串全为a
    // 2.字符串全为b
    // 3.字符串中有a也有b，所有的a都在b的左边
    public int minimumDeletions(String s) {
        int res = 0;
        int bCnt = 0;
        for (char c : s.toCharArray()) {
            if (c == 'b') {
                bCnt++;
            } else {
                res = Math.min(bCnt, res + 1);
            }
        }
        return res;
    }
}
