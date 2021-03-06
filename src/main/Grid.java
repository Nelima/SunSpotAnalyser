package main;

public class Grid {
    private String listOfInputValues;
    private int noOfResultsRequired;
    private int gridSize;

    public Grid(String listOfInputValues) {

        this.listOfInputValues = listOfInputValues;
    }


    public int[][] formatInputValuesIntoGrid() throws Exception {

        String[] arrayOfInputValues = listOfInputValues.split(" ");
        int inputArrayCounter = 0;
        noOfResultsRequired = Integer.parseInt((arrayOfInputValues[0]));
        gridSize = Integer.parseInt(arrayOfInputValues[1]);
        int heatMeasurements[][] = new int[gridSize + 2][gridSize + 2];
        for (int row = 1; row <= gridSize; row++) {
            for (int column = 1; column <= gridSize; column++) {
                heatMeasurements[row][column] = Integer.parseInt(arrayOfInputValues[inputArrayCounter + 2]);
                inputArrayCounter++;
            }

        }

        return heatMeasurements;

    }

    public int getNoOfResultsRequired() {
        return noOfResultsRequired;
    }

    public int getGridSize() {
        return gridSize;
    }
}
