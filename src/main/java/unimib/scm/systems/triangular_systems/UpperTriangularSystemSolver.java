package unimib.scm.systems.triangular_systems;

import unimib.scm.matrix.MatrixAlg;
import unimib.scm.systems.SolveStrategy;

import static unimib.scm.utils.Constants.*;

public class UpperTriangularSystemSolver implements SolveStrategy {
    @Override
    public double[] solve(double[][] matrix, double[] right_hand_terms) throws IllegalArgumentException {
        if(matrix.length != right_hand_terms.length) {
            throw new IllegalArgumentException(RIGHT_HAND_SIDE_WITH_WRONG_SIZE);
        } else if (!MatrixAlg.isMatrixUpperTriangular(matrix)) {
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
            results[i] = (1/matrix[i][i])*(right_hand_terms[i] - tmp);
        }
        return results;
    }
}
