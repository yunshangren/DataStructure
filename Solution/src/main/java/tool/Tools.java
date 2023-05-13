package tool;

/**
 * @author Acer
 * @create 2023/5/11 14:16
 */
public class Tools {
    public static int[][] stringToMatrix(String s) {
        StringBuilder builder = new StringBuilder(s);
        builder.delete(0, 2);
        builder.delete(builder.length() - 2, builder.length());
        s = builder.toString();
        String[] strings = s.split("],\\[");
        int[][] matrix = new int[strings.length][];
        for (int i = 0; i < strings.length; i++) {
            String str = strings[i];
            String[] temp = str.split(",");
            matrix[i] = new int[temp.length];
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Integer.parseInt(temp[j]);
            }
        }
        return matrix;
    }
}
