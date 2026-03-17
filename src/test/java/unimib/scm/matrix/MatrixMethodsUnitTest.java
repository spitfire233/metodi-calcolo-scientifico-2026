package unimib.scm.matrix;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import unimib.scm.systems.SolveStrategy;
import unimib.scm.systems.triangular_systems.LowerTriangularSystemSolver;
import unimib.scm.systems.triangular_systems.UpperTriangularSystemSolver;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class MatrixMethodsUnitTest {

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4})
    public void whenMatrixSquared_thenReturnTrue(int n) {
        Random random = new Random();
        double[][] matrix = new double[n][n];
        assertTrue(MatrixMethods.isMatrixSquared(matrix));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2",
            "2, 1",
            "3, 4",
            "5, 3"
    })
    public void whenMatrixNotSquared_thenReturnFalse(int n, int m) {
        double[][] matrix = new double[n][m];
        assertFalse(MatrixMethods.isMatrixSquared(matrix));
    }


    @ParameterizedTest
    @CsvSource({
            "2, 2",
            "3, 4",
            "4, 3",
            "5, 3",
            "6, 1"
    })
    public void whenTransposingMatrix_returnCorrectMatrix(int n, int m) {
        Random random = new Random();
        double[][] matrix = new double[n][m];
        double[][] correctTranspose = new double[m][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                double entry = random.nextDouble();
                matrix[i][j] = entry;
                correctTranspose[j][i] = entry;
            }
        }
        double[][] result = MatrixMethods.transposeMatrix(matrix);
        assertTrue(IntStream.range(0, m)
                .allMatch(i -> Arrays.equals(correctTranspose[i], result[i])));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    public void whenMatrixIsLowerTriangular_returnTrue(int n) {
        Random random = new Random();
        double[][] matrix = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j <= i) {
                    matrix[i][j] = random.nextDouble();
                } else {
                    matrix[i][j] = 0.0;
                }
            }
        }
        assertTrue(MatrixMethods.isMatrixLowerTriangular(matrix));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    public void whenMatrixIsUpperTriangular_returnTrue(int n) {
        Random random = new Random();
        double[][] matrix = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j >= i) {
                    matrix[i][j] = random.nextDouble();
                } else {
                    matrix[i][j] = 0.0;
                }
            }
        }
        assertTrue(MatrixMethods.isMatrixUpperTriangular(matrix));
    }

    @Test
    public void whenValidLowerTriangularMatrix_thenSolveCorrectly() {
        double[][] matrix = {
                {2, 0, 0},
                {3, 1, 0},
                {1, -1, 1}
        };
        double[] right_hand_side = {2, 5, 1};
        SolveStrategy solver = new LowerTriangularSystemSolver();
        double[] result = solver.solve(matrix, right_hand_side);
        double[] expected = {1, 2, 2};
        assertArrayEquals(expected, result, 1e-9);
    }

    @Test
    public void whenRightHandSideWrongSizeWithLowerTriangular_thenThrowException() {
        double[][] matrix = {
                {1, 0},
                {3, 4}
        };
        double[] right_hand_side = {1};
        SolveStrategy solver = new LowerTriangularSystemSolver();
        assertThrows(
                IllegalArgumentException.class,
                () -> solver.solve(matrix, right_hand_side)
        );
    }

    @Test
    public void whenMatrixIsNotLowerTriangular_thenThrowException() {
        double[][] matrix = {
                {1, 2},
                {0, 4}
        };
        double[] right_hand_side = {1, 1};
        SolveStrategy solver = new LowerTriangularSystemSolver();
        assertThrows(
                IllegalArgumentException.class,
                () -> solver.solve(matrix, right_hand_side)
        );
    }

    @Test
    public void whenDiagonalContainsZeroInLowerTriangular_thenThrowException() {
        double[][] matrix = {
                {1, 0},
                {3, 0}
        };
        double[] right_hand_side = {1, 2};
        SolveStrategy solver = new LowerTriangularSystemSolver();
        assertThrows(
                IllegalArgumentException.class,
                () -> solver.solve(matrix, right_hand_side)
        );
    }

    @Test
    public void whenValidUpperTriangularMatrix_thenSolveCorrectly() {
        double[][] matrix = {
                {2, 3, 1},
                {0, 1, 4},
                {0, 0, 2}
        };
        double[] right_hand_side = {5, 9, 4};
        SolveStrategy solver = new UpperTriangularSystemSolver();
        double[] result = solver.solve(matrix, right_hand_side);
        double[] expected = {0, 1, 2};
        assertArrayEquals(expected, result, 1e-9);
    }

    @Test
    public void whenRightHandSideWrongSizeWithUpperTriangular_thenThrowException() {
        double[][] matrix = {
                {1, 2},
                {0, 4}
        };
        double[] right_hand_side = {1};
        SolveStrategy solver = new UpperTriangularSystemSolver();
        assertThrows(
                IllegalArgumentException.class,
                () -> solver.solve(matrix, right_hand_side)
        );
    }

    @Test
    public void whenMatrixIsNotUpperTriangular_thenThrowException() {
        double[][] matrix = {
                {1, 0},
                {3, 4}
        };
        double[] right_hand_side = {1, 1};
        SolveStrategy solver = new UpperTriangularSystemSolver();
        assertThrows(
                IllegalArgumentException.class,
                () -> solver.solve(matrix, right_hand_side)
        );
    }

    @Test
    public void whenDiagonalContainsZeroInUpperTriangular_thenThrowException() {
        double[][] matrix = {
                {1, 2},
                {0, 0}
        };
        double[] right_hand_side = {3, 4};
        SolveStrategy solver = new UpperTriangularSystemSolver();
        assertThrows(
                IllegalArgumentException.class,
                () -> solver.solve(matrix, right_hand_side)
        );
    }




}
