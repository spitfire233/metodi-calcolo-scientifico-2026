package unimib.scm.matrix;

import static unimib.scm.utils.Constants.MATRIX_NOT_SQUARED_ERROR_MSG;

public class MatrixAlg {


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
        if (!isMatrixSquared(matrix))
            throw new IllegalArgumentException(MATRIX_NOT_SQUARED_ERROR_MSG);

        boolean isLowerTriangular = true;
        int i = 0;
        while(i < matrix.length && isLowerTriangular) {
            int j = i + 1;
            while (j < matrix[i].length) {
                if(matrix[i][j] != 0.0)
                    isLowerTriangular = false;
                j++;
            }
            i++;
        }
        return isLowerTriangular;
    }

    public static boolean isMatrixUpperTriangular(double[][] matrix) throws IllegalArgumentException {
        if(!isMatrixSquared(matrix))
            throw new IllegalArgumentException(MATRIX_NOT_SQUARED_ERROR_MSG);
        boolean isUpperTriangular = true;
        int i = matrix.length - 1;
        while (i >= 0 && isUpperTriangular) {
            int j = i - 1;
            while (j >= 0) {
                if(matrix[i][j] != 0.0)
                    isUpperTriangular = false;
                j--;
            }
            i--;
        }
        return isUpperTriangular;
    }
}
