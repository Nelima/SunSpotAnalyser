import main.GridConstructor;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;


public class GridTest {

    @Test
    public void shouldConvertTheInputIntoGridForm() throws Exception {
        GridConstructor gridConstructor = new GridConstructor("1 2 1 2 3 4");
        int[][] expectedMeasurement = gridConstructor.constructTheGridWithRawHeatMeasurements();
        int[][] actualMeasurements = new int[][]{{0, 0, 0, 0}, {0, 1, 2, 0}, {0, 3, 4, 0}, {0, 0, 0, 0}};
        assertArrayEquals(expectedMeasurement, actualMeasurements);

    }

}
