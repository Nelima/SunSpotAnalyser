package main;

import java.util.ArrayList;

public class GridConstructor {
    private int gridSize;
    private ArrayList<Integer> heatMeasurements;

    public GridConstructor(int gridSize, ArrayList<Integer> heatMeasurements) {
        this.gridSize = gridSize;
        this.heatMeasurements = heatMeasurements;
    }


    public int[][] constructTheGridWithRawHeatMeasurements() throws Exception {

        int listOfHeatMeasurementsCounter = 0;
        int grid[][] = new int[gridSize + 2][gridSize + 2];
        for (int row = 1; row <= gridSize; row++) {
            for (int column = 1; column <= gridSize; column++) {
                grid[row][column] = heatMeasurements.get(listOfHeatMeasurementsCounter);
                listOfHeatMeasurementsCounter++;
            }

        }

        return grid;

    }


}
