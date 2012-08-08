import main.Calculator;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class CalculatorTest {
    @Test

    public void ShouldReturnTheSolarActivityScoreOfSpecifiedCell() {
        Calculator calculator = new Calculator(new int[][]{{0, 0, 0, 0}, {0, 1, 2, 0}, {0, 3, 4, 0}, {0, 0, 0, 0}});
        int solarActivityScore = calculator.calculateSolarActivityScore(1, 1);
        assertThat(solarActivityScore, is(10));

    }

}
