package main;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyser {
    private String analyserData;
    private int noOfResultsRequired;
    private int gridSize;
    private int[][] grid;
    private ArrayList<String> listOfOutputValues = new ArrayList();
    private String[] formattedAnalyserData;
    private ArrayList<Integer> heatMeasurements = new ArrayList<Integer>();

    public Analyser(String analyserData) {
        this.analyserData = analyserData;
    }

    public void generatingAnalyserData() {
        formattedAnalyserData = analyserData.split(" ");
        noOfResultsRequired = Integer.parseInt((formattedAnalyserData[0]));
        gridSize = Integer.parseInt((formattedAnalyserData[1]));
        for (int inputArrayCounter = 2; inputArrayCounter < formattedAnalyserData.length; inputArrayCounter++) {
            heatMeasurements.add(Integer.parseInt(formattedAnalyserData[inputArrayCounter]));
        }
    }

    public boolean areHeatMeasurementsValid() throws Exception {
        int inputArrayCounter = 2;
        int counter = 0;
        while (inputArrayCounter < formattedAnalyserData.length) {
            Pattern pattern = Pattern.compile("^[0-5]$");
            Matcher matcher = pattern.matcher(formattedAnalyserData[inputArrayCounter]);
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
        Matcher resultsRequiredMatcher = pattern.matcher(formattedAnalyserData[0]);
        generatingAnalyserData();
        if (resultsRequiredMatcher.find() && (noOfResultsRequired <= (gridSize * gridSize)))

            return true;
        else
            throw new Exception("Results required should be +ve and should not be greater than no of cells in grid");
    }


    public boolean isGridSizeValid() throws Exception {
        Pattern pattern = Pattern.compile("^[0-9]+$");
        Matcher matcher = pattern.matcher(formattedAnalyserData[1]);
        if (matcher.find()) return true;
        else
            throw new Exception("Grid size should be positive");

    }


    public ArrayList<String> generateListOfHighestSolarActivityScores() throws Exception {
        generatingAnalyserData();
        if (isResultsRequiredValid() && isGridSizeValid() && !areHeatMeasurementsValid()) {
            GridConstructor gridConstructor = new GridConstructor(gridSize, heatMeasurements);
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

