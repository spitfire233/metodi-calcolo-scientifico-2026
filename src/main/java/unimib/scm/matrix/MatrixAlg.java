package unimib.scm.matrix;

import static unimib.scm.utils.Constants.MATRIX_NOT_SQUARED_ERROR_MSG;

public class MatrixAlg {


    public static <N extends Number> boolean isMatrixSquared(N[][] matrix) {
        boolean isSquared = true;
        int i = 0;
        while(i < matrix.length && isSquared) {
            if(matrix[i].length != matrix.length)
                isSquared = false;
            i++;
        }
        return isSquared;
    }


    public static <N extends Number> boolean isMatrixUpperTriangular(N[][] matrix) throws IllegalArgumentException {
        if (!isMatrixSquared(matrix))
            throw new IllegalArgumentException(MATRIX_NOT_SQUARED_ERROR_MSG);
        boolean isUpperTriangular = true;

        int i = 0;
        return isUpperTriangular;
    }





}
