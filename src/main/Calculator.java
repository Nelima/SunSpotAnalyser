package main;
public class Calculator {
    private int[][] heatValues;

    public Calculator(int[][] heatValues) {
        this.heatValues = heatValues;
    }

    public int calculateSolarActivityScore(int rowValue, int columnValue) {

        int scoreOfEachCell = 0;
        for (int rowCounter = rowValue - 1; rowCounter < rowValue + 2; rowCounter++) {
            for (int columnCounter = columnValue - 1; columnCounter < columnValue + 2; columnCounter++) {
                scoreOfEachCell = scoreOfEachCell + heatValues[rowCounter][columnCounter];
            }

        }
        return scoreOfEachCell;

    }
}
