/*
 * Course: CSC1120
 * Spring 2024
 * Lab 6 - Benchmarking
 * Name: Jawadul Chowdhury
 * Created: 1/29/24
 */
package chowdhuryj;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;


/**
 * class for ListBenchmark()
 */
public class ListBenchmark {

    /**
     * constant for upper bound
     */
    public static final int UPPER_BOUND = 1000;

    /**
     * constant for number to find
     */
    public static final int NUMBER_TO_FIND = 55;

    /**
     * method for getHelp()
     * @return the string
     */
    public static String getHelp() {
        String stringHelp = " 'implementation' 'operation' 'smallest list size'" +
                " 'multiplicative factor' + 'number of benchmark runs' ";
        return stringHelp;
    }


    /**
     * method for runBenchmarks()
     * @param listType listType
     * @param operation operation
     * @param size size
     * @param multiplier multiplier
     * @param numberOfTests numberOfTests
     * @return long[] array
     */
    public static long[] runBenchmarks(String listType,
                                       String operation, int size,
                                       int multiplier, int numberOfTests) {

        // initialize an array of longs, with size being number of tests
        long[] retLongArray = new long[numberOfTests];
        int currentSize = size;

        for(int i = 0; i < numberOfTests; i++) {

            currentSize = currentSize * multiplier;

            // create a list
            List<Integer> newList = createList(listType, currentSize);
            long startTime;
            long endTime;
            long elapsedTime;


            // applying the operations
            switch (operation) {
                case "indexedContains":
                    startTime = System.nanoTime();
                    indexedContains(newList, -1);
                    endTime = System.nanoTime();
                    elapsedTime = endTime - startTime;
                    retLongArray[i] = elapsedTime;
                    break;
                case "addToFront":
                    startTime = System.nanoTime();
                    addToFront(newList, 4);
                    endTime = System.nanoTime();
                    elapsedTime = endTime - startTime;
                    retLongArray[i] = elapsedTime;
                    break;

                case "contains":
                    startTime = System.nanoTime();
                    contains(newList, NUMBER_TO_FIND);
                    endTime = System.nanoTime();
                    elapsedTime = endTime - startTime;
                    retLongArray[i] = elapsedTime;
                    break;
            }
        }

        return retLongArray;
    }


    /**
     * helper method for generating a list with random numbers filled in
     * @param retList retList
     * @param size size
     */
    public static void randomList(List<Integer> retList, int size) {
        // random number generator
        Random random = new Random();
        for(int i = 0; i < size; i++) {
            int randomInt = random.nextInt(UPPER_BOUND) + 1;
            retList.add(0, randomInt);
        }
    }


    /**
     * helper method for checking of index contains
     * @param retList retList
     * @param index index
     */
    public static void indexedContains(List<Integer> retList, int index) {
        int retVal = 0;
        for(int i = 0; i < retList.size() && retVal == 0; i++) {
            if(retList.get(i) == index) {
                retVal = 1;
            }
        }
    }

    /**
     * helper method for adding to the front of the list
     * @param retList retList
     * @param integer integer
     */
    public static void addToFront(List<Integer> retList, int integer) {
        retList.add(0, integer);
    }

    /**
     * helper method for checking if integer is present
     * @param retList retList
     * @param integer integer
     * @return boolean value
     */
    public static boolean contains(List<Integer> retList, int integer) {
        return retList.contains(integer);
    }


    /**
     * helper method for createList
     * @param listType listType
     * @param size size
     * @return list of integers
     */
    public static List<Integer> createList(String listType, int size) {
        Integer[] intArray = new Integer[size];
        // random number generator
        Random random = new Random();
        for(int i = 0; i < size; i++) {
            int randomInt = random.nextInt(UPPER_BOUND) + 1;
            intArray[i] = randomInt;
        }
        switch (listType) {
            case "java.util.ArrayList":
                return new ArrayList<>(Arrays.asList(intArray));
            case "java.util.LinkedList":
                return new LinkedList<>(Arrays.asList(intArray));
            case "datastructures.ArrayList":
                return new datastructures.ArrayList<>(intArray);
            case "datastructures.LinkedList":
                return new datastructures.LinkedList<>(intArray);
            default:
                return new datastructures.LinkedListTurbo<>(intArray);
        }
    }

}
