import java.util.Random;

public class Task01 {
    // diagonal
    public static int[][] identityMatrix(int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i][i] = 1;
        }
        return matrix;
    }

    public static int[][] zeroMatrix(int n) {
        return new int[n][n]; // по умолчанию всё будет 0
    }

    // 2 matrices
    public static int[][] addMatrices(int[][] A, int[][] B) {
        int n = A.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }

    // Multiply 2 matrices
    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int n = A.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    // Multiply matrix by scalar
    public static int[][] multiplyByScalar(int[][] A, int scalar) {
        int n = A.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = A[i][j] * scalar;
            }
        }
        return result;
    }

    // recursive expansion by minors
    public static int determinant(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) return matrix[0][0];
        if (n == 2) return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

        int det = 0;
        for (int col = 0; col < n; col++) {
            det += Math.pow(-1, col) * matrix[0][col] * determinant(minor(matrix, 0, col));
        }
        return det;
    }

    // get minor matrix
    private static int[][] minor(int[][] matrix, int row, int col) {
        int n = matrix.length;
        int[][] minor = new int[n - 1][n - 1];
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (i == row) continue;
            int c = 0;
            for (int j = 0; j < n; j++) {
                if (j == col) continue;
                minor[r][c] = matrix[i][j];
                c++;
            }
            r++;
        }
        return minor;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf("%5d", val); // 5 position element width
            }
            System.out.println();
        }
        System.out.println();
    }



    public static void main(String[] args) {
        System.out.println("On the agenda we got a batch of matrices & operations!");
        int n = 3;

        // Example matrices
        int[][] A = {
                {2, 1, 3},
                {0, -1, 4},
                {5, 2, 0}
        };
        int[][] B = {
                {1, 0, 2},
                {3, 1, -1},
                {0, 4, 2}
        };

        System.out.println("Matrix A:");
        printMatrix(A);

        System.out.println("Matrix B:");
        printMatrix(B);

        System.out.println("Identity Matrix:");
        printMatrix(identityMatrix(n));

        System.out.println("Zero Matrix:");
        printMatrix(zeroMatrix(n));

        System.out.println("A + B:");
        printMatrix(addMatrices(A, B));

        System.out.println("A * B:");
        printMatrix(multiplyMatrices(A, B));

        System.out.println("A * 3:");
        printMatrix(multiplyByScalar(A, 3));

        System.out.println("Determinant of A = " + determinant(A));
        System.out.println("Determinant of B = " + determinant(B));
    }
}