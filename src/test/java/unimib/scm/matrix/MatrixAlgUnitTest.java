package unimib.scm.matrix;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MatrixAlgUnitTest {

    @Test
    public void whenMatrixSquared_thenReturnTrue() {
        Random random = new Random();
        int n = random.nextInt(5) + 1;
        double[][] matrix = new double[n][n];
        assertTrue(MatgrixAlg.isMatrixSquared(matrix));
    }

    @Test
    public void whenMatrixNotSquared_thenReturnFalse() {
        Random random = new Random();
        int n = random.nextInt(5) + 1;
        int m = random.nextInt(5) + 1;
        double[][] matrix = new double[n][m];
        assertFalse(MatrixAlg.isMatrixSquared(matrix));
    }

    public void whenMatrixLowerTriangular_thenReturnTrue() {

    }



    private double[][] generateRandomLowerTriangularMatrix() {
        Random random = new Random();
        int n = random.nextInt(5) +1;
        double[][] matrix = new double[n][n];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = i + 1; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextDouble();
            }
        }

        return matrix;


    }

}
