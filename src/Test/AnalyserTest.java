import main.Analyser;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AnalyserTest {

    @Test
    public void shouldReturnTheHighestThreeSolarActivityScores() throws Exception {
        Analyser analyser = new Analyser("3 4 2 3 2 1 4 4 2 0 3 4 1 1 2 3 4 4");
        ArrayList<String> expectedSolarActivityScores = analyser.generateListOfHighestSolarActivityScores();
        ArrayList<String> actualSolarActivityScores = new ArrayList<String>();
        actualSolarActivityScores.add("(1,2) Score=27");
        actualSolarActivityScores.add("(1,1) Score=25");
        actualSolarActivityScores.add("(2,2) Score=23");
        assertTrue(expectedSolarActivityScores.equals(actualSolarActivityScores));

    }


    @Test
    public void shouldReturnTheHighestSolarActivityScores() throws Exception {
        Analyser analyser = new Analyser("4 2 2 3 2 1");
        ArrayList<String> expectedSolarActivityScores = analyser.generateListOfHighestSolarActivityScores();
        ArrayList<String> actualSolarActivityScores = new ArrayList<String>();
        actualSolarActivityScores.add("(1,0) Score=8");
        actualSolarActivityScores.add("(1,1) Score=8");
        actualSolarActivityScores.add("(0,0) Score=8");
        actualSolarActivityScores.add("(0,1) Score=8");
        assertTrue(expectedSolarActivityScores.equals(actualSolarActivityScores));

    }

    @Test
    public void heatValuesShouldBeInTheRangeOf1To5() throws Exception {
        Analyser analyser = new Analyser("1 3 4 6 3 2 2 1 3 2 1");
        try {
            analyser.generateListOfHighestSolarActivityScores();
        } catch (Exception e) {
            assertThat(e.getMessage(), is("Heat values should be positive numbers and in the range of 1 to 5"));
        }
    }

    @Test
    public void heatValuesShouldBePositive() throws Exception {
        Analyser analyser = new Analyser("1 3 -4 6 3 2 2 1 3 2 1");
        try {
            analyser.generateListOfHighestSolarActivityScores();
        } catch (Exception e) {
            assertThat(e.getMessage(), is("Heat values should be positive numbers and in the range of 1 to 5"));
        }
    }
    @Test
    public void gridSizeShouldBePositiveNumber() throws Exception {
        Analyser analyser = new Analyser("9 -3 4 2 3 2 2 1 3 2 1");
        try {
            analyser.generateListOfHighestSolarActivityScores();
        } catch (Exception e) {
            assertThat(e.getMessage(), is("Grid size should be positive"));
        }
    }

    @Test
    public void resultsRequiredShouldBeValidNumber() throws Exception {
        Analyser analyser = new Analyser("10 3 4 2 3 2 2 1 3 2 1");
        try {
            analyser.generateListOfHighestSolarActivityScores();
        } catch (Exception e) {
            assertThat(e.getMessage(), is("Results required should be +ve and should not be greater than no of cells in grid"));
        }
    }
    @Test
    public void resultsRequiredShouldBePositiveNumber() throws Exception {
        Analyser analyser = new Analyser("-1 3 4 2 3 2 2 1 3 2 1");
        try {
            analyser.generateListOfHighestSolarActivityScores();
        } catch (Exception e) {
            assertThat(e.getMessage(), is("Results required should be +ve and should not be greater than no of cells in grid"));
        }
    }

}
