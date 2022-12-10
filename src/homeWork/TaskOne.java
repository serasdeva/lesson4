package homeWork;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TaskOne {

    static int[][] mat = {
            {1, 1, 1, 0, 1},
            {0, 1, 0, 0, 1},
            {1, 1, 1, 0, 0},
            {1, 1, 1, 1, 0},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 0, 0}
    };

    public static void main(String[] args) {
        updateMatrix(mat);
    }

    public static int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = m + n;
                }
            }

        }

        int[] dirs = {-1, 0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int i = 0; i < dirs.length - 1; i++) {
                int r = cell[0] + dirs[i];
                int c = cell[1] + dirs[i + 1];
                if (r < 0 || r >= m || c < 0 || c >= n ||
                        matrix[r][c] <= matrix[cell[0]][cell[1]] + 1) continue;
                queue.add(new int[]{r, c});
                matrix[r][c] = matrix[cell[0]][cell[1]] + 1;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        return matrix;
    }
}

