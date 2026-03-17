package unimib.scm.matrix;

import static unimib.scm.utils.Constants.MATRIX_NOT_SQUARED_ERROR_MSG;

public class MatrixMethods {


    public static boolean isMatrixSquared(double[][] matrix) {
        boolean isSquared = true;
        int i = 0;
        while (i < matrix.length && isSquared) {
            if (matrix[i].length != matrix.length)
                isSquared = false;
            i++;
        }
        return isSquared;
    }

    public static boolean isMatrixLowerTriangular(double[][] matrix) throws IllegalArgumentException {
        if(!isMatrixSquared(matrix))
            throw new IllegalArgumentException(MATRIX_NOT_SQUARED_ERROR_MSG);
        int n = matrix.length;
        boolean isLowerTriangular = true;
        for(int i = 0; i < n && isLowerTriangular; i++) {
            for(int j = i + 1; j < n; j++) {
                if (matrix[i][j] != 0.0) {
                    isLowerTriangular = false;
                    break;
                }
            }
        }
        return isLowerTriangular;
    }

    public static boolean isMatrixUpperTriangular(double[][] matrix) throws IllegalArgumentException {
        return isMatrixLowerTriangular(transposeMatrix(matrix));
    }

    public static double[][] transposeMatrix(double[][] matrix) {
        double[][] transpose = new double[matrix[0].length][];
        for (int i = 0; i < matrix[0].length; i++) {
            transpose[i] = new double[matrix.length];
            for(int j = 0; j < matrix.length; j++) {
                transpose[i][j] = matrix[j][i];
            }
        }
        return transpose;
    }
}
