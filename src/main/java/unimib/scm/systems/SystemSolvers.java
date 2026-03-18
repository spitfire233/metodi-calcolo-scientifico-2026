package unimib.scm.systems;

import unimib.scm.matrix.MatrixMethods;

import static unimib.scm.utils.Constants.*;

public class SystemSolvers {

    public static double[] solveLowerTriangularSystem(double[][] matrix, double[] right_hand_terms) {
        if(matrix.length != right_hand_terms.length) {
            throw new IllegalArgumentException(RIGHT_HAND_SIDE_WITH_WRONG_SIZE);
        } else if(!MatrixMethods.isMatrixLowerTriangular(matrix)) {
            throw new IllegalArgumentException(MATRIX_IS_NOT_LOWER_TRIANGULAR);
        }
        double[] results = new double[matrix.length];
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][i] == 0.0)
                throw new IllegalArgumentException(MATRIX_TERM_IS_ZERO_CANNOT_DIVIDE);
            double tmp = 0.0;
            for(int j = 0; j < i; j++) {
                tmp = tmp + (matrix[i][j] * results[j]);
            }
            results[i] = (right_hand_terms[i] - tmp)/matrix[i][i];
        }
        return results;
    }

    public static double[] solveUpperTriangularSystem(double[][] matrix, double[] right_hand_terms) {
        if(matrix.length != right_hand_terms.length) {
            throw new IllegalArgumentException(RIGHT_HAND_SIDE_WITH_WRONG_SIZE);
        } else if (!MatrixMethods.isMatrixUpperTriangular(matrix)) {
            throw new IllegalArgumentException(MATRIX_IS_NOT_UPPER_TRIANGULAR);
        }
        int n = matrix.length;
        double[] results = new double[n];
        for(int i = n -1; i >= 0; i--) {
            if(matrix[i][i] == 0.0)
                throw new IllegalArgumentException(MATRIX_TERM_IS_ZERO_CANNOT_DIVIDE);
            double tmp = 0.0;
            for(int j = i + 1; j < matrix.length; j++) {
                tmp = tmp + (matrix[i][j] * results[j]);
            }
            results[i] = (right_hand_terms[i] - tmp)/matrix[i][i];
        }
        return results;
    }


}
