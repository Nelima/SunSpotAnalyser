package main;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyser {
    private String inputValues;
    private int noOfResults;
    private int gridSize;
    private int[][] grid;
    private ArrayList<String> listOfOutputValues = new ArrayList();
    private String[] arrayOfInputValues;

    public Analyser(String inputValues) {

        this.inputValues = inputValues;
    }

    public void splittingTheInputValues() {
        arrayOfInputValues = inputValues.split(" ");
        noOfResults = Integer.parseInt((arrayOfInputValues[0]));
        gridSize = Integer.parseInt((arrayOfInputValues[1]));
    }

    public boolean areHeatValuesOutOfRange() throws Exception {
        int inputArrayCounter = 2;
        int counter = 0;
        while (inputArrayCounter < arrayOfInputValues.length) {
            Pattern pattern = Pattern.compile("^[0-5]$");
            Matcher matcher = pattern.matcher(arrayOfInputValues[inputArrayCounter]);
            if (matcher.find()) counter++;
            else throw new Exception("Heat values should be in the range of 1 to 5");
            inputArrayCounter++;
        }
        if (counter == inputArrayCounter - 3)
            return true;
        else
            return false;
    }


    public boolean isResultsRequiredValid() throws Exception {
        Pattern pattern = Pattern.compile("^[0-9]+$");
        Matcher resultsRequiredMatcher = pattern.matcher(arrayOfInputValues[0]);
        splittingTheInputValues();
        if (resultsRequiredMatcher.find() && (noOfResults <= (gridSize * gridSize)))

            return true;
        else
            throw new Exception("Results required should be +ve and should not be greater than no of cells in grid");
    }


    public boolean isGridSizeValid() throws Exception {
        Pattern pattern = Pattern.compile("^[0-9]+$");
        Matcher gridSizeMatcher = pattern.matcher(arrayOfInputValues[1]);
        if (gridSizeMatcher.find()) return true;
        else
            throw new Exception("GridConstructor size should be positive");


    }


    public ArrayList<String> generateListOfHighestSolarActivityScores() throws Exception {
        splittingTheInputValues();
        if (isResultsRequiredValid() && isGridSizeValid() && !areHeatValuesOutOfRange()) {
            GridConstructor gridConstructor = new GridConstructor(inputValues);
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
            ArrayList sortedListOfSolarScores = mapSorter.sorting();

            int sortedListSize = sortedListOfSolarScores.size();
            while (noOfResults > 0) {
                listOfOutputValues.add(sortedListOfSolarScores.get(sortedListSize - 1).toString());
                noOfResults--;
                sortedListSize--;
            }
        }
        return listOfOutputValues;

    }


}

