package solution2;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/2/20 20:29
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        //每行中的整数从左到右按升序排列。
        //每行的第一个整数大于前一行的最后一个整数。
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[row - 1][col - 1]) {
            return false;
        }

        int left = 0;
        int right = row - 1;
        int index = 0; // 找到target可能存在的行，（比target小的最大的数）
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                right = mid - 1;
            } else {
                if (mid == right || matrix[mid + 1][0] > target) {
                    index = mid;
                    break;
                }
                left = mid + 1;
            }
        }
        left = 0;
        right = col - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (matrix[index][mid] == target) {
                return true;
            } else if (matrix[index][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    @Test
    public void test() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(searchMatrix(matrix, 30));
    }
}
