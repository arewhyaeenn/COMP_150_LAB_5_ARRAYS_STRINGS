/***
 * This class will test the IntArrayMethods class.
 * It is complete, and should not be edited by students other than uncommenting tests once previous tests are correct.
 * Created by rsm on 10/18/19.
 */

public class IntArrayMethodsClient
{
    public static void main(String[] args)
    {
        // array of arrays on which to test methods
        int[][] testInputs = {
                {1, 2, 3},
                {9, 8, 7, 6, 5, 4, 3, 2, 1, 0},
                {22, 98, 65, 52, 78786, 71, 12},
                {-1, -2, -3},
                {-9, -8, -7, -6, -5, -4, -3, -2, -1, 0}
        };

        // identical array of arrays to test that originals aren't changing with copies
        int[][] testInputsValidation = {
                {1, 2, 3},
                {9, 8, 7, 6, 5, 4, 3, 2, 1, 0},
                {22, 98, 65, 52, 78786, 71, 12},
                {-1, -2, -3},
                {-9, -8, -7, -6, -5, -4, -3, -2, -1, 0}
        };

        // correct outputs from toString method
        String[] toStringOutputs = {
                "[ 1 2 3 ]",
                "[ 9 8 7 6 5 4 3 2 1 0 ]",
                "[ 22 98 65 52 78786 71 12 ]",
                "[ -1 -2 -3 ]",
                "[ -9 -8 -7 -6 -5 -4 -3 -2 -1 0 ]"
        };

        // inputs for equals tests with testInputs[0]
        int[][] equalsTestInputs = {
                {1, 2},
                {1, 2, 3, 4},
                {1, 2, 3},
                {1, 2, 4},
                {0, 2, 3},
                {1, 3, 3}
        };

        // outputs for equals tests with testInputs[0]
        boolean[] equalsTestOutputs = {
                false,
                false,
                true,
                false,
                false,
                false
        };

        // correct outputs from sum method
        int[] sumOutputs = {6, 45, 79106, -6, -45};

        // correct ouputs for average method
        double[] averageOutputs = {2.0, 4.5, 11300.857142857143, -2.0, -4.5};

        // correct outputs from sorting arrays
        int[][] testInputsSorted = {
                {1, 2, 3},
                {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                {12, 22, 52, 65, 71, 98, 78786},
                {-3, -2, -1},
                {-9, -8, -7, -6, -5, -4, -3, -2, -1, 0}
        };

        // indexes with which to test the indexed min and max methods
        int[][][] minMaxTestIndexes = {
                {
                        {0, 3},
                        {1, 2}
                },
                {
                        {0, 10},
                        {3, 5}
                },
                {
                        {0, 7},
                        {1, 4}
                },
                {
                        {0, 3},
                        {1, 2}
                },
                {
                        {0, 10},
                        {3, 5}
                }
        };

        // correct outputs from indexed max method
        int[][] maxIndexOutputs = {
                {3, 2},
                {9, 6},
                {78786, 98},
                {-1, -2},
                {0, -5}
        };

        // correct outputs from indexed min method
        int[][] minIndexOutputs = {
                {1, 2},
                {0, 5},
                {12, 52},
                {-3, -2},
                {-9, -6}
        };

        // correct outputs from complete max and min methods
        int[] maxOutputs = {3, 9, 78786, -1, 0};
        int[] minOutputs = {1, 0, 12, -3, -9};



        // indexes to use when testing swapElements
        int[][][] swapElementsTestIndexes = {
                {
                        {0,0},
                        {0,1},
                        {0,2},
                        {1,2}
                },
                {
                        {0, 1},
                        {0, 9},
                        {4, 5},
                        {5, 4}
                }
        };

        // expected results from swapElements calls
        int[][][] swapElementsValidation = {
                {
                        {1, 2, 3},
                        {2, 1, 3},
                        {3, 2, 1},
                        {1, 3, 2}
                },
                {
                        {8, 9, 7, 6, 5, 4, 3, 2, 1, 0},
                        {0, 8, 7, 6, 5, 4, 3, 2, 1, 9},
                        {9, 8, 7, 6, 4, 5, 3, 2, 1, 0},
                        {9, 8, 7, 6, 4, 5, 3, 2, 1, 0}
                }
        };


        //-------------------------------------------------- TOSTRING --------------------------------------------------
        System.out.println("*** TESTING TOSTRING ***");
        System.out.println("(You'll need to check these by hand and ensure they're correct before moving on to further tests)");
        System.out.println();
        for (int i = 0; i < testInputs.length; ++i)
        {
            System.out.println("    toString on array " + (i+1) + ": " + IntArrayMethods.toString(testInputs[i]));
            System.out.println("    should be          : " + toStringOutputs[i]);
            System.out.println();
        }
        System.out.println();


        //--------------------------------------------------  EQUALS  --------------------------------------------------
        System.out.println("*** TESTING EQUALS ***");
        System.out.println();
        for(int i = 0; i < equalsTestInputs.length; i++)
        {
            System.out.println("    Comparing " + IntArrayMethods.toString(testInputs[0]) +
                    " and " + IntArrayMethods.toString(equalsTestInputs[i]));
            boolean result = IntArrayMethods.equals(testInputs[0], equalsTestInputs[i]);
            System.out.println("    Your equals method says these arrays " + (result ? "ARE" : "ARE NOT") + " equal.");
            System.out.println("    This result is " +
                    (result == equalsTestOutputs[i] ? "CORRECT" :
                            "INCORRECT"+
                            "\n\n----------------------ALL TESTS BELOW THIS ARE INVALID, FIX EQUALS METHOD BEFORE MOVING ON----------------------"));
            System.out.println();
        }
        System.out.println();


        //---------------------------------------------------  COPY  ---------------------------------------------------
        System.out.println("*** TESTING COPY ***");
        System.out.println();
        for (int  i = 0; i < testInputs.length; i++)
        {
            int[] original = testInputs[i];
            System.out.println("    Copying :" + IntArrayMethods.toString(original));
            int[] copy = IntArrayMethods.copy(original);
            System.out.println("    Result  :" + IntArrayMethods.toString(copy));
            boolean correct = IntArrayMethods.equals(original, copy);
            System.out.println("    Copied array has " + (correct ? "CORRECT" : "INCORRECT") + " values.");
            System.out.println("    Editing copied array...");
            copy[0] = 12345;
            correct = IntArrayMethods.equals(original, testInputsValidation[i]);
            System.out.println("    Editing copy " + (correct ? "DID NOT" : "DID") + " edit original : " +
                    (correct ? "GOOD" : "BAD" +
                    "\n\n----------------------ALL TESTS BELOW THIS ARE INVALID, FIX COPY METHOD BEFORE MOVING ON----------------------"));
            System.out.println();
        }
        System.out.println();


        //---------------------------------------------------  SUM  ----------------------------------------------------
        System.out.println("*** TESTING SUM ***");
        System.out.println();
        for (int i = 0; i < testInputs.length; i++)
        {
            int[] testArray = testInputs[i];
            int sum = IntArrayMethods.sum(testArray);
            int correctSum = sumOutputs[i];
            boolean correct = sum == correctSum;
            System.out.println("    Your sum method for " + IntArrayMethods.toString(testArray) +
                    " is " + IntArrayMethods.sum(testArray) +
                    " : " + (correct ? "CORRECT" : "INCORRECT" +
                    "\n\n----------------------ALL TESTS BELOW THIS ARE INVALID, FIX SUM METHOD BEFORE MOVING ON----------------------"));
            System.out.println();
        }
        System.out.println();


        //--------------------------------------------------  AVERAGE  -------------------------------------------------
        System.out.println("*** TESTING AVERAGE ***");
        System.out.println();
        for (int i = 0; i < testInputs.length; i++)
        {
            int[] testArray = testInputs[i];
            double average = IntArrayMethods.average(testArray);
            double correctAverage = averageOutputs[i];
            boolean correct = compareDoubles(average, correctAverage);
            System.out.println("    Your average method for " + IntArrayMethods.toString(testArray) +
                    " is " + IntArrayMethods.average(testArray) +
                    " : " + (correct ? "CORRECT" : "INCORRECT" +
                    "\n\n----------------------ALL TESTS BELOW THIS ARE INVALID, FIX AVERAGE METHOD BEFORE MOVING ON----------------------"));
            System.out.println();
        }
        System.out.println();


        //---------------------------------------------------  MAX  ----------------------------------------------------
        System.out.println("*** TESTING MAX METHOD (with indexes) ***");
        System.out.println();
        for (int i = 0; i < testInputs.length; i++)
        {
            int[] testArray = testInputs[i];
            for (int j = 0; j < minMaxTestIndexes[i].length; j++)
            {
                int startIndex = minMaxTestIndexes[i][j][0];
                int endIndex = minMaxTestIndexes[i][j][1];
                int correctMax = maxIndexOutputs[i][j];
                int max = IntArrayMethods.max(testArray, startIndex, endIndex);
                boolean correct = correctMax == max;
                System.out.println("    Your max method for " + IntArrayMethods.toString(testArray) +
                        " with startIndex " + startIndex + " and endIndex " + endIndex +
                        " is " + max + " : " + (correct ? "CORRECT" : "INCORRECT" +
                        "\n\n----------------------ALL TESTS BELOW THIS ARE INVALID, FIX MAX METHOD BEFORE MOVING ON----------------------"));
                System.out.println();
            }
        }
        System.out.println();


        System.out.println("*** TESTING MAX METHOD (without indexes) ***");
        System.out.println();
        for (int i = 0; i < testInputs.length; i++)
        {
            int[] testArray = testInputs[i];
            int max = IntArrayMethods.max(testArray);
            int correctMax = maxOutputs[i];
            boolean correct = max == correctMax;
            System.out.println("    Your max method for " + IntArrayMethods.toString(testArray) +
                    " is " + max + " : " + (correct ? "CORRECT" : "INCORRECT" +
                    "\n\n----------------------ALL TESTS BELOW THIS ARE INVALID, FIX MAX METHOD BEFORE MOVING ON----------------------"));
            System.out.println();
        }


        //---------------------------------------------------  MIN  ----------------------------------------------------
        System.out.println("*** TESTING MIN METHOD (with indexes) ***");
        System.out.println();
        for (int i = 0; i < testInputs.length; i++)
        {
            int[] testArray = testInputs[i];
            for (int j = 0; j < minMaxTestIndexes[i].length; j++)
            {
                int startIndex = minMaxTestIndexes[i][j][0];
                int endIndex = minMaxTestIndexes[i][j][1];
                int correctMin = minIndexOutputs[i][j];
                int min = IntArrayMethods.min(testArray, startIndex, endIndex);
                boolean correct = correctMin == min;
                System.out.println("    Your min method for " + IntArrayMethods.toString(testArray) +
                        " with startIndex " + startIndex + " and endIndex " + endIndex +
                        " is " + min + " : " + (correct ? "CORRECT" : "INCORRECT" +
                        "\n\n----------------------ALL TESTS BELOW THIS ARE INVALID, FIX MIN METHOD BEFORE MOVING ON----------------------"));
                System.out.println();
            }
        }
        System.out.println();


        System.out.println("*** TESTING MIN METHOD (without indexes) ***");
        System.out.println();
        for (int i = 0; i < testInputs.length; i++)
        {
            int[] testArray = testInputs[i];
            int min = IntArrayMethods.min(testArray);
            int correctMin = minOutputs[i];
            boolean correct = min == correctMin;
            System.out.println("    Your min method for " + IntArrayMethods.toString(testArray) +
                    " is " + min + " : " + (correct ? "CORRECT" : "INCORRECT" +
                    "\n\n----------------------ALL TESTS BELOW THIS ARE INVALID, FIX MIN METHOD BEFORE MOVING ON----------------------"));
            System.out.println();
        }

        //----------------------------------------------  SWAP ELEMENTS  -----------------------------------------------

        System.out.println("*** TESTING SWAP ELEMENTS ***");
        System.out.println();
        for (int i = 0; i < swapElementsTestIndexes.length; i++)
        {
            int[] testArray = testInputs[i];
            for (int j = 0; j < swapElementsTestIndexes[i].length; j++)
            {
                int[] testCopy = IntArrayMethods.copy(testArray);
                IntArrayMethods.swapElements(testCopy, swapElementsTestIndexes[i][j][0], swapElementsTestIndexes[i][j][1]);
                boolean correct = IntArrayMethods.equals(testCopy, swapElementsValidation[i][j]);
                System.out.println("   Your swapElements method for " + IntArrayMethods.toString(testArray) +
                        " with indexes " + swapElementsTestIndexes[i][j][0] + " and " + swapElementsTestIndexes[i][j][1] +
                        " results in " + IntArrayMethods.toString(testCopy) + " which is " +
                        (correct ? "CORRECT" : "INCORRECT" +
                        "\n\n----------------------ALL TESTS BELOW THIS ARE INVALID, FIX MIN METHOD BEFORE MOVING ON----------------------"));
                System.out.println();
            }


        }


        //----------------------------------------------  SELECTION SORT  ----------------------------------------------
        System.out.println("*** TESTING SELECTION SORT ***");
        System.out.println();
        for (int i = 0; i < testInputs.length; i++)
        {
            int[] testArray = testInputs[i];
            int[] sorted = IntArrayMethods.selectionSort(testArray);
            System.out.println("    Result of sorting " + IntArrayMethods.toString(testArray) +
                    " with Selection Sort is " + IntArrayMethods.toString(sorted));
            boolean correct = IntArrayMethods.equals(sorted, testInputsSorted[i]);
            System.out.println("    Your sorted array is : " + (correct ? "CORRECT" : "INCORRECT" +
                    "\n\n----------------------ALL TESTS BELOW THIS ARE INVALID, FIX SELECTION SORT METHOD BEFORE MOVING ON----------------------"));
            System.out.println("    Editing sorted array...");
            sorted[0] = 12345;
            correct = IntArrayMethods.equals(testArray, testInputsValidation[i]);
            System.out.println("    Editing sorted array " + (correct ? "DID NOT" : "DID") + " edit original : " +
                    (correct ? "GOOD" : "BAD" +
                            "\n\n----------------------ALL TESTS BELOW THIS ARE INVALID, FIX SELECTION SORT METHOD BEFORE MOVING ON----------------------"));
            System.out.println();
        }
        System.out.println();


        //------------------------------------------------  BUBBLE SORT  -----------------------------------------------
        System.out.println("*** TESTING BUBBLE SORT ***");
        System.out.println();
        for (int i = 0; i < testInputs.length; i++)
        {
            int[] testArray = testInputs[i];
            int[] sorted = IntArrayMethods.bubbleSort(testArray);
            System.out.println("    Result of sorting " + IntArrayMethods.toString(testArray) +
                    " with Bubble Sort is " + IntArrayMethods.toString(sorted));
            boolean correct = IntArrayMethods.equals(sorted, testInputsSorted[i]);
            System.out.println("    Your sorted array is : " + (correct ? "CORRECT" : "INCORRECT" +
                    "\n\n----------------------ALL TESTS BELOW THIS ARE INVALID, FIX BUBBLE SORT METHOD BEFORE MOVING ON----------------------"));
            System.out.println("    Editing sorted array...");
            sorted[0] = 12345;
            correct = IntArrayMethods.equals(testArray, testInputsValidation[i]);
            System.out.println("    Editing sorted array " + (correct ? "DID NOT" : "DID") + " edit original : " +
                    (correct ? "GOOD" : "BAD" +
                            "\n\n----------------------ALL TESTS BELOW THIS ARE INVALID, FIX BUBBLE SORT METHOD BEFORE MOVING ON----------------------"));
            System.out.println();
        }
        System.out.println();
    }

    static boolean compareDoubles(double d1, double d2)
    {
        return Math.abs(d1-d2) < 0.0001;
    }
}
