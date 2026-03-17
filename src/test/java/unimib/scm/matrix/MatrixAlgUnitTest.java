package unimib.scm.matrix;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class MatrixAlgUnitTest {

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4})
    public void whenMatrixSquared_thenReturnTrue(int n) {
        Random random = new Random();
        double[][] matrix = new double[n][n];
        assertTrue(MatrixAlg.isMatrixSquared(matrix));
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
        assertFalse(MatrixAlg.isMatrixSquared(matrix));
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
        double[][] result = MatrixAlg.transposeMatrix(matrix);
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
        assertTrue(MatrixAlg.isMatrixLowerTriangular(matrix));
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
        assertTrue(MatrixAlg.isMatrixUpperTriangular(matrix));
    }
}
