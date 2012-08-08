import main.Analyser;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AnalyserTest {

    @Test
    public void sholudCalculateTheHighestSolarActivityScore() throws Exception {
        Analyser analyser = new Analyser("1 3 4 2 3 2 2 1 3 2 1");
        ArrayList<String> expectedSolarActivityScores = analyser.calculateSolarActivityScore();
        ArrayList<String> actualSolarActivityScores = new ArrayList();
        actualSolarActivityScores.add("(1,1) Score=20");
        assertTrue(expectedSolarActivityScores.equals(actualSolarActivityScores));
    }


    @Test
    public void shouldReturnTheHighestThreeSolarActivityScores() throws Exception {
        Analyser analyser = new Analyser("3 4 2 3 2 1 4 4 2 0 3 4 1 1 2 3 4 4");
        ArrayList<String> expectedSolarActivityScores = analyser.calculateSolarActivityScore();
        ArrayList<String> actualSolarActivityScores = new ArrayList<String>();
        actualSolarActivityScores.add("(1,2) Score=27");
        actualSolarActivityScores.add("(1,1) Score=25");
        actualSolarActivityScores.add("(2,2) Score=23");
        assertTrue(expectedSolarActivityScores.equals(actualSolarActivityScores));

    }
    @Test
    public void shouldReturnTheHighestSolarActivityScores() throws Exception {
        Analyser analyser = new Analyser("4 2 2 3 2 1");
        ArrayList<String> expectedSolarActivityScores = analyser.calculateSolarActivityScore();
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
            analyser.calculateSolarActivityScore();
        } catch (Exception e) {
            assertThat(e.getMessage(), is("Heat values should be in the range of 1 to 5"));
        }
    }

    @Test
    public void resultsRequiredAndGridSizeShouldBePositiveNumber() throws Exception {
        Analyser analyser = new Analyser("10 3 4 2 3 2 2 1 3 2 1");
        try {
            analyser.calculateSolarActivityScore();
        } catch (Exception e) {
            assertThat(e.getMessage(), is("Results required & gridsize should be +ve, results required should not be greater than no of cells in grid"));
        }
    }

}
