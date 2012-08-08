//package main;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class blah {
//    private String listOfInputValues;
//    private int noOfResults;
//    private int gridSize;
//    private int[][] heatValues;
//    //    private String[] listOfOutputValues = new String[]{};
//    private ArrayList<String> listOfOutputValues = new ArrayList<String>();
//
//
//    public Analyser(String listOfInputValues) {
//
//        this.listOfInputValues = listOfInputValues;
//    }
//
//    public boolean areHeatValuesOutOfRange(String listOfInputValues) throws Exception {
//        String[] arrayOfInputValues = listOfInputValues.split(" ");
//        int inputArrayCounter = 2;
//        int counter = 0;
//        while (inputArrayCounter < arrayOfInputValues.length) {
//            Pattern pattern = Pattern.compile("^[0-5]$");
//            Matcher matcher = pattern.matcher(arrayOfInputValues[inputArrayCounter]);
//            if (matcher.find()) counter++;
//            else throw new Exception("Heat values should be in the range of 1 to 5");
//            inputArrayCounter++;
//        }
//        if (counter == inputArrayCounter - 3)
//            return true;
//        else
//            return false;
//    }
//
//    public ArrayList<String> generateListOfHighestSolarActivityScores() throws Exception {
//        if (!areHeatValuesOutOfRange(listOfInputValues)) {
//            GridConstructor grid = new GridConstructor(listOfInputValues);
//            heatValues = grid.constructTheGridWithRawHeatMeasurements();
//            gridSize = grid.getGridSize();
//            Calculator calculator = new Calculator(heatValues);
//            noOfResults = grid.getNoOfResultsRequired();
//            int[] solarActivityScore = new int[gridSize * gridSize];
//            int scoreArrayCounter = 0;
//            HashMap hashMap = new HashMap();
//            for (int row = 1; row <= gridSize; row++) {
//                for (int column = 1; column <= gridSize; column++) {
//                    solarActivityScore[scoreArrayCounter] = calculator.generateListOfHighestSolarActivityScores(row, column);
//                    String hashMapValue = String.format("(%d,%d)", column - 1, row - 1);
//                    hashMap.put(solarActivityScore[scoreArrayCounter], new String(hashMapValue));
//                    scoreArrayCounter++;
//                }
//            }
//            Arrays.sort(solarActivityScore);
//            int outputArrayCounter = 0;
////        listOfOutputValues = new String[noOfResults];
//            while (noOfResults > 0) {
//
//                String hashMapValueToString = hashMap.get(solarActivityScore[scoreArrayCounter - 1]).toString();
//                String outputValue = String.format("%s Score %d", hashMapValueToString, solarActivityScore[scoreArrayCounter - 1]);
////            listOfOutputValues[outputArrayCounter] = outputValue;
//                scoreArrayCounter = scoreArrayCounter - 1;
//                listOfOutputValues.add(outputValue);
////            outputArrayCounter++;
//                noOfResults = noOfResults - 1;
//            }
//        }
//
//
//        System.out.print("hi");
//        System.out.print(listOfOutputValues);
//        return listOfOutputValues;
//    }
//
//
//}

//import org.junit.Test;
//
//@Test
//    public void sholudCalculateTheHighestSolarActivityScore() throws Exception {
//        Analyser analyser = new Analyser("1 3 4 2 3 2 2 1 3 2 1");
//        ArrayList<String> expectedSolarActivityScores = analyser.generateListOfHighestSolarActivityScores();
//        ArrayList<String> actualSolarActivityScores = new ArrayList();
//        actualSolarActivityScores.add("(1,1) Score=20");
//        assertTrue(expectedSolarActivityScores.equals(actualSolarActivityScores));
//    }