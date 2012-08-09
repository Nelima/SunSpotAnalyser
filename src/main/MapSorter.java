package main;

import java.util.*;


public class MapSorter {
    private HashMap<String, Integer> stringIntegerHashMap;

    public MapSorter(HashMap<String, Integer> stringIntegerHashMap) {
        this.stringIntegerHashMap = stringIntegerHashMap;
    }

    public ArrayList sort() {

        ArrayList sortedListOfSolarScores = new ArrayList(stringIntegerHashMap.entrySet());
        Collections.sort(sortedListOfSolarScores, new Comparator() {
            public int compare(Object firstObject, Object secondObject) {
                Map.Entry firstEntry = (Map.Entry) firstObject;
                Map.Entry secondEntry = (Map.Entry) secondObject;
                Integer first = (Integer) firstEntry.getValue();
                Integer second = (Integer) secondEntry.getValue();
                return first.compareTo(second);
            }
        });
        return sortedListOfSolarScores;
    }
}

