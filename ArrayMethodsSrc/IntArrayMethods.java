/***
 * This Class will contain static methods for use with integer arrays.
 * Created by rsm on 10/18/19
 */

public class IntArrayMethods
{
    /* TODO complete toString method */
    /**
     * Creates and returns a String representing the input array
     * @param inputArray array to represent in String form
     * @return String representation of inputArray
     */
    public static String toString(int[] inputArray)
    {

        return ""; // delete this return when you're done
    }


    /* TODO complete the equals method */
    /**
     * Checks if the two input arrays are equal. returns true if they are equal, and false otherwise.
     * @param inputArray1 first input array
     * @param inputArray2 second input array
     * @return true of the arrays are equal; false otherwise
     */
    public static boolean equals(int[] inputArray1, int[] inputArray2)
    {
        return true; // delete this return when you're done
    }


    /* TODO complete copy method */
    /**
     * Creates and returns a copy of the input array.
     * @param inputArray array to copy
     * @return a copy of inputArray
     */
    public static int[] copy(int[] inputArray)
    {
        // Construct a new array of the same length.
        // Then, use a loop to write each value from the original array into the new array.
        return null; // delete this return when you're done
    }


    /* TODO complete the sum method */
    /**
     * Finds the sum of all elements in the input array
     * @param inputArray array from which to find sum
     * @return the sum of arrayToSum's elements.
     */
    public static int sum(int[] inputArray)
    {
        return 0; // delete this return when you're done
    }


    /* TODO complete the average method */
    /**
     * Finds and returns the average of the input array's elements
     * @param inputArray array from which to calculate average
     * @return average of the elements of inputArray
     */
    public static double average(int[] inputArray)
    {
        return 0.0; // delete this return when you're done
    }


    /* TODO complete the max method */
    /**
     * Finds the maximum value in the portion of the input array starting at startIndex and stopping before endIndex.
     * @param inputArray the array from which to find a max
     * @param startIndex the first index to check (elements at preceding indexes won't be considered)
     * @param endIndex the index before which to stop checking (elements at and after this index won't be considered)
     * @return the maximum value in inputArray from startIndex to endIndex (inclusive for startIndex, exclusive for endIndex)
     */
    public static int max(int[] inputArray, int startIndex, int endIndex)
    {
        return 0; // delete this return when you're done
    }


    /* TODO complete the max method below using the max method above */
    /**
     * Finds the maximum value in the input array
     * @param inputArray the array from which to find the max
     * @return the maximum value in the inputArray
     */
    public static int max(int[] inputArray)
    {
        /* Don't use a loop. Instead, use the other max method defined above
        by choosing appropriate startIndex and endIndex values */
        return 0; // delete this return when you're done
    }


    /* TODO complete the min method */
    /**
     * Finds the minimum value in the portion of the input array starting at startIndex and stopping before endIndex.
     * @param inputArray the array from which to find a min
     * @param startIndex the first index to check (elements at preceding indexes won't be considered)
     * @param endIndex the index before which to stop checking (elements at and after this index won't be considered)
     * @return the minimum value in inputArray from startIndex to endIndex (inclusive for startIndex, exclusive for endIndex)
     */
    public static int min(int[] inputArray, int startIndex, int endIndex)
    {
        return 0; // delete this return when you're done
    }


    /* TODO complete the min method below using the min method above */
    /**
     * Finds the minimum value in the input array
     * @param inputArray the array from which to find the min
     * @return the minimum value in the inputArray
     */
    public static int min(int[] inputArray)
    {
        /* Don't use a loop. Instead, use the other min method defined above
        by choosing appropriate startIndex and endIndex values */
        return 0; // delete this return when you're done
    }

    /* TODO complete selectionSort method */
    /**
     * Creates and returns a sorted copy of the input array using the Selection Sort algorithm.
     * @param inputArray the array to be copied and sorted
     * @return a copy of inputArray, sorted in increasing order
     */
    public static int[] selectionSort(int[] inputArray)
    {
        // DO NOT CHANGE THE ORIGINAL ARRAY (inputArray)
        // SORT THE COPY MADE BELOW INSTEAD
        int[] sorted = copy(inputArray);
        // your code goes here
        return sorted;
    }


    /* TODO complete bubbleSort method */
    /**
     * Creates and returns a sorted copy of the input array using the Bubble Sort algorithm.
     * @param inputArray the array to be copied and sorted.
     * @return a copy of inputArray, sorted in increasing order
     */
    public static int[] bubbleSort(int[] inputArray)
    {
        // DO NOT CHANGE THE ORIGINAL ARRAY (inputArray)
        // SORT THE COPY MADE BELOW INSTEAD
        int[] sorted = copy(inputArray);
        // your code goes here
        return sorted;
    }
}
