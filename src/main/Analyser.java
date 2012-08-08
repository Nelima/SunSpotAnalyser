package main;

import javax.swing.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyser {
    private String inputValues;
    private int noOfResults;
    private int gridSize;
    private int[][] heatValues;
    private ArrayList<String> listOfOutputValues = new ArrayList();

    public Analyser(String inputValues) {

        this.inputValues = inputValues;
    }

    public boolean areHeatValuesOutOfRange(String listOfInputValues) throws Exception {
        String[] arrayOfInputValues = listOfInputValues.split(" ");
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

    public boolean isResultsRequiredisValid(String listOfInputValues) throws Exception {
        String[] arrayOfInputValues = listOfInputValues.split(" ");
        Pattern pattern = Pattern.compile("^[0-9]+$");
        Matcher resultsRequiredMatcher = pattern.matcher(arrayOfInputValues[0]);
        Matcher gridSizeMatcher = pattern.matcher(arrayOfInputValues[1]);
        int resultsRequired = Integer.parseInt(arrayOfInputValues[0]);
        int gridSize = Integer.parseInt(arrayOfInputValues[1]);
        if (resultsRequiredMatcher.find() && gridSizeMatcher.find() && (resultsRequired <= (gridSize * gridSize)))

            return true;
        else
            throw new Exception("Results required & gridsize should be +ve, results required should not be greater than no of cells in grid");
    }

    public ArrayList<String> calculateSolarActivityScore() throws Exception {
        if (isResultsRequiredisValid(inputValues) && !areHeatValuesOutOfRange(inputValues)) {
            Grid grid = new Grid(inputValues);
            heatValues = grid.formatInputValuesIntoGrid();
            gridSize = grid.getGridSize();
            Calculator calculator = new Calculator(heatValues);
            noOfResults = grid.getNoOfResultsRequired();
            HashMap hashMap = new HashMap();
            for (int row = 1; row <= gridSize; row++) {
                for (int column = 1; column <= gridSize; column++) {

                    String hashMapValue = String.format("(%d,%d) Score", column - 1, row - 1);
                    hashMap.put(hashMapValue, new Integer(calculator.calculateSolarActivityScore(row, column)));

                }
            }
            ArrayList sortedList = new ArrayList(hashMap.entrySet());
            Collections.sort(sortedList, new Comparator() {
                public int compare(Object o1, Object o2) {
                    Map.Entry e1 = (Map.Entry) o1;
                    Map.Entry e2 = (Map.Entry) o2;
                    Integer first = (Integer) e1.getValue();
                    Integer second = (Integer) e2.getValue();
                    return first.compareTo(second);
                }
            });
            int sortedListSize = sortedList.size();
            while (noOfResults > 0) {
                listOfOutputValues.add(sortedList.get(sortedListSize - 1).toString());
                noOfResults--;
                sortedListSize--;
            }
        }
        return listOfOutputValues;

    }


}

