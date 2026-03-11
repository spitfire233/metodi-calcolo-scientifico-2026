package unimib.scm.matrix;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MatrixAlgUnitTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4})
    public void whenMatrixSquared_thenReturnTrue(int n) {
        double[][] matrix = new double[n][n];
        assertTrue(MatrixAlg.isMatrixSquared(matrix));
    }

}
