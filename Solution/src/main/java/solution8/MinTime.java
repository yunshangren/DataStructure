package solution8;

/**
 * @author Acer
 * @create 2023/3/31 14:33
 */
public class MinTime {
    // 这个是不按题目顺序做
    /*public int minTime(int[] time, int m) {
        int n = time.length;
        if (n <= m) {
            return 0;
        }
        Arrays.sort(time);
        int temp = time[n - m - 1];
        int[] preSum = new int[n - m + 1];
        for (int i = 1; i <= n - m; i++) {
            preSum[i] = preSum[i - 1] + time[i - 1];
        }
        if (temp * m >= preSum[n - m - 1]) {
            return temp;
        }
        int avg = preSum[n - m - 1] / m;
        avg = avg * m == preSum[n - m - 1] ? avg : avg + 1;
        int num1 = searchGe(preSum, avg);
        if (num1 == avg) {
            return avg;
        }
        int diff = num1 - avg;
        int num2 = searchLe(preSum, diff);
        return num1 - num2;
    }

    public int searchGe(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int res = 0;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                res = arr[mid];
                right = mid - 1;
            } else {
                res = arr[mid];
                break;
            }
        }
        return res;
    }

    public int searchLe(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int res = 0;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (arr[mid] < target) {
                res = arr[mid];
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                res = arr[mid];
                break;
            }
        }
        return res;
    }*/

    // 按照题目编号顺序

}
