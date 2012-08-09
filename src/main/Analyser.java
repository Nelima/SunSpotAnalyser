package main;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyser {
    private String inputValues;
    private int noOfResultsRequired;
    private int gridSize;
    private int[][] grid;
    private ArrayList<String> listOfOutputValues = new ArrayList();
    private String[] arrayOfInputValues;
    private ArrayList<Integer> rawDataOfHeatMeasurements = new ArrayList<Integer>();

    public Analyser(String inputValues) {

        this.inputValues = inputValues;
    }

    public void splitTheInputValues() {
        arrayOfInputValues = inputValues.split(" ");
        noOfResultsRequired = Integer.parseInt((arrayOfInputValues[0]));
        gridSize = Integer.parseInt((arrayOfInputValues[1]));
        for (int inputArrayCounter = 2; inputArrayCounter < arrayOfInputValues.length; inputArrayCounter++) {
            rawDataOfHeatMeasurements.add(Integer.parseInt(arrayOfInputValues[inputArrayCounter]));
        }
    }

    public boolean areHeatMeasurementsValid() throws Exception {
        int inputArrayCounter = 2;
        int counter = 0;
        while (inputArrayCounter < arrayOfInputValues.length) {
            Pattern pattern = Pattern.compile("^[0-5]$");
            Matcher matcher = pattern.matcher(arrayOfInputValues[inputArrayCounter]);
            if (matcher.find()) counter++;
            else throw new Exception("Heat values should be positive numbers and in the range of 1 to 5");
            inputArrayCounter++;
        }
        if ((counter == inputArrayCounter - 3))
            return true;
        else
            return false;
    }


    public boolean isResultsRequiredValid() throws Exception {
        Pattern pattern = Pattern.compile("^[0-9]+$");
        Matcher resultsRequiredMatcher = pattern.matcher(arrayOfInputValues[0]);
        splitTheInputValues();
        if (resultsRequiredMatcher.find() && (noOfResultsRequired <= (gridSize * gridSize)))

            return true;
        else
            throw new Exception("Results required should be +ve and should not be greater than no of cells in grid");
    }


    public boolean isGridSizeValid() throws Exception {
        Pattern pattern = Pattern.compile("^[0-9]+$");
        Matcher gridSizeMatcher = pattern.matcher(arrayOfInputValues[1]);
        if (gridSizeMatcher.find()) return true;
        else
            throw new Exception("Grid size should be positive");


    }


    public ArrayList<String> generateListOfHighestSolarActivityScores() throws Exception {
        splitTheInputValues();
        if (isResultsRequiredValid() && isGridSizeValid() && !areHeatMeasurementsValid()) {
            GridConstructor gridConstructor = new GridConstructor(gridSize, rawDataOfHeatMeasurements);
            grid = gridConstructor.constructTheGridWithRawHeatMeasurements();
            Calculator calculator = new Calculator(grid);
            HashMap scoresAndLocationsOfAllCells = new HashMap();
            for (int row = 1; row <= gridSize; row++) {
                for (int column = 1; column <= gridSize; column++) {

                    String location = String.format("(%d,%d) Score", column - 1, row - 1);
                    scoresAndLocationsOfAllCells.put(location, new Integer(calculator.calculateSolarActivityScore(row, column)));
                }
            }

            MapSorter mapSorter = new MapSorter(scoresAndLocationsOfAllCells);
            ArrayList sortedListOfSolarScores = mapSorter.sort();

            int sortedListSize = sortedListOfSolarScores.size();
            while (noOfResultsRequired > 0) {
                listOfOutputValues.add(sortedListOfSolarScores.get(sortedListSize - 1).toString());
                noOfResultsRequired--;
                sortedListSize--;
            }
        }
        return listOfOutputValues;

    }


}

