import main.GridConstructor;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;


public class GridConstructorTest {

    @Test
    public void shouldConvertTheInputIntoGridForm() throws Exception {
        ArrayList<Integer> rawDataOfHeatMeasurements = new ArrayList<Integer>();
        rawDataOfHeatMeasurements.add(1);
        rawDataOfHeatMeasurements.add(2);
        rawDataOfHeatMeasurements.add(3);
        rawDataOfHeatMeasurements.add(4);
        GridConstructor gridConstructor = new GridConstructor(2,rawDataOfHeatMeasurements);
        int[][] expectedMeasurement = gridConstructor.constructTheGridWithRawHeatMeasurements();
        int[][] actualMeasurements = new int[][]{{0, 0, 0, 0}, {0, 1, 2, 0}, {0, 3, 4, 0}, {0, 0, 0, 0}};
        assertArrayEquals(expectedMeasurement, actualMeasurements);

    }

}
