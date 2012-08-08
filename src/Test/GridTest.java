import main.Grid;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;


public class GridTest {

    @Test
    public void shouldConvertTheInputIntoGridForm() throws Exception {
        Grid grid = new Grid("1 2 1 2 3 4 ");
        int[][] expectedMeasurement = grid.formatInputValuesIntoGrid();
        int[][] actualMeasurements = new int[][]{{0, 0, 0, 0}, {0, 1, 2, 0}, {0, 3, 4, 0}, {0, 0, 0, 0}};
        assertArrayEquals(expectedMeasurement, actualMeasurements);

    }

}
