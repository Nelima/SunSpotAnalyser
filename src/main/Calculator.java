package main;
public class Calculator {
    private int[][] heatMeasurements;

    public Calculator(int[][] heatMeasurements) {
        this.heatMeasurements = heatMeasurements;
    }

    public int calculateSolarActivityScore(int rowValue, int columnValue) {

        int scoreOfEachCell = 0;
        for (int rowCounter = rowValue - 1; rowCounter < rowValue + 2; rowCounter++) {
            for (int columnCounter = columnValue - 1; columnCounter < columnValue + 2; columnCounter++) {
                scoreOfEachCell = scoreOfEachCell + heatMeasurements[rowCounter][columnCounter];
            }

        }
        return scoreOfEachCell;

    }
}
