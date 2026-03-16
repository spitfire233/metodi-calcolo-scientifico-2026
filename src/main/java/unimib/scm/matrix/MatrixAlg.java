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

    // TODO: Refactorare in modo tale che funzioni con isMatrixLowerTriangular ma con la trasposta!
    public static boolean isMatrixUpperTriangular(double[][] matrix) throws IllegalArgumentException {
        if(!isMatrixSquared(matrix))
            throw new IllegalArgumentException(MATRIX_NOT_SQUARED_ERROR_MSG);
        boolean isUpperTriangular = true;
        int i = matrix.length - 1;
        while (i >= 0 && isUpperTriangular) {
            int j = i - 1;
            while (j >= 0) {
                if(matrix[i][j] != 0.0) {
                    isUpperTriangular = false;
                    break;
                }
                j--;
            }
            i--;
        }
        return isUpperTriangular;
    }





    public static int[] solveTriangularSystem(double[][] matrix) throws IllegalArgumentException {
        int[] x = new int[matrix.length];



        return x;
    }





}
