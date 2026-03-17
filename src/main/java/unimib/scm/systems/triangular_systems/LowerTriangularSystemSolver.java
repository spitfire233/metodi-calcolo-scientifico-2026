package unimib.scm.systems.triangular_systems;

import unimib.scm.matrix.MatrixMethods;
import unimib.scm.systems.SolveStrategy;

import static unimib.scm.utils.Constants.*;

public class LowerTriangularSystemSolver implements SolveStrategy {
    @Override
    public double[] solve(double[][] matrix, double[] right_hand_terms) throws IllegalArgumentException {
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
            results[i] = (1/matrix[i][i])*(right_hand_terms[i] - tmp);
        }
        return results;
    }





}
