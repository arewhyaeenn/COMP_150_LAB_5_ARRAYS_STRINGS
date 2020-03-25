# COMP 150 Lab 5 - Arrays, Strings, etc

In this lab:

* What arrays are and how to create, access and edit them.
* Traversing arrays and the enhanced `for` loop.
* Passing by reference, redundant references and copying.
* Nestability and multi-dimensional arrays.
* Algorithms, pseudocode and implementation via searching sorting.
* `String`s as sequences of `char`s
* Indexing `String`s, substrings, and other `String` methods.
* Escape sequences.
* Regular expressions and pattern matching.
* ArrayLists.

## Arrays

So far, each variable we have created has stored one piece of data. The statement `int x = 5;` creates a variable `x` which can store a single integer value, and assigns that value to `5`.

Often, it is convenient to store multiple values in sequence in a single variable; this is where arrays come into play. Arrays can store a sequence of values (all of a specified type).

We will start our discussion of arrays with an example:

```java
String[ ] dayNames = {
	"Sunday", 
	"Monday", 
	"Tuesday", 
	"Wednesday", 
	"Thursday", 
	"Friday", 
	"Saturday"
};
```

The snippet above creates an array of `String`s called `dayNames` containing 7 `String` values (the days of the week). The pieces of data contained in an array are called its **elements**. The array above has seven elements: the names of the seven days of the week, stored in `String` form.

### Declaration

Adding square brackets `[ ]` after the data type in a declaration indicates that an array is being declared. The data type for an array if `String`s is `String[ ]`, that for an array of `int`s is `int[ ]`, and so on. Arrays can be declared to store any data type. All of the following would are valid array declarations (though some of them require importing the class stored in the array):

`int[ ] testScores;`  
`double[ ] monthlyRainfall`  
`String[ ] dayNames;`  
`Point[ ] corners;`  
`MyClass[ ] arrayFilledWithMyClassInstancesWithAnObnoxiouslyLongIdentifier;`  

### Initialization

Arrays can be initialized in two ways. The most obvious way is with an array literal, which consists of curly braces `{ }` containing the values in the array, separated by commas.

For instance:

`int[ ] numbers = { 100, 97, 99, 82, 85, 74, 93 };`

The line above declares an array of integers called `numbers` and initializes it as with seven integer values specified in the curly braces.

Arrays can also be initialized without initial values; the number of elements in the array must be specified, but their values need not be specified. This is done like an object construction, because arrays are objects:

`int[ ] numbers = new int[7];`

When an array is declared in this fashion, its elements are all set to the default value for the specified data type; `null` for objects, `0` for numeric primitives, `false` for `boolean`s, and the null character `'\0'` for `char`s. The array `numbers` above would be an array containing seven `int`s, each with value `0`.

### Indexing

Each element of an array has an integer location, called its **index**. The first element in an array has index `0`, the second has index `1`, and so on.

If an array is initialized as follows:

`int[ ] numbers = { 100, 97, 99, 82, 85, 74, 93 };`

Then the following table shows the `numbers` array's values and their corresponding indices:

| **VALUE** | `100`   | `97`    | `99`    | `82`    | `85`    | `74`    | `93`    |
| :-------: | :-----: | :-----: | :-----: | :-----: | :-----: | :-----: | :-----: |
| **INDEX** | **`0`** | **`1`** | **`2`** | **`3`** | **`4`** | **`5`** | **`6`** |

Notice that the largest index is `6` even though the array has 7 elements; this is because the indexing starts at `0`, not at `1`! You can think of the index as the **distance** from the start of the array; the first element **is** the start of the array, so its distance from the start is `0`.

Array elements can be accessed with their index in square brackets; to get the value `100` from the `numbers` array above, one would use the expression `numbers[0]`. To get the `99`, one would use the expression `numbers[2]`.

### Traversing and the `length` attribute

The number of elements in an array can be accessed using its `length` attribute with the accessor operator `.`. The length of the numbers array above is `7`, and this value can be accessed with `numbers.length`.

You can go through every element in an array by incrementing an index in a loop. Because the first index is `0`, the last index is 1 less than the array length, so the index must remain less than the array length. The two loops in the snippet below both print all of the elements of the `dayNames` array.

```java
String[ ] dayNames = { 
	"Sunday", 
	"Monday", 
	"Tuesday", 
	"Wednesday", 
	"Thursday", 
	"Friday", 
	"Saturday"
};

for (int index = 0; index < dayNames.length; index++)
{
	System.out.println( dayNames[index] );
}

int index = 0;
while (index < dayNames.length)
{
	System.out.println( dayNames[index] );
	index++;
}	
```

### Traversing with the enhanced `for` loop

There is an additional type of `for` loop for iterating through sequences. The loop below does the same as the two above (it prints every value in the `dayNames` array). The `:` can be thought of as "in" as far as understanding what the loop syntax means in english.

```java
for (String name : dayNames)
{
    System.out.println( name );
}
```

<a name=""></a>**[EXERCISE]()** Consider the following array declaration and instantiation:

```java
int[] myIntArray = { 1, 3, 5, 7, 9 };
```

1. What is the `length` of `myIntArray`?
2. What is the smallest index in `myIntArray`?
3. What value is stored at `myIntArray[2]`?
4. What is the largest index in `myIntArray`?

<a name=""></a>**[SOLUTION]()**

1. The `length` of `myIntArray` is `5`; it has 5 elements.
2. The smallest index in any array is `0`. Indexing starts at `0`.
3. The value stored at index `2` in `myIntArray` is `5`. Index `0` contains `1` and index `1` contains `3`.
4. The largest index is always 1 less than the length, because indexing starts at `0`. Thus, the largest index in `myIntArray` is `4`.

<a name=""></a>**[EXERCISE]()** Consider the following snippet:

```java
double[] myDoubleArray = new double[10];
        
for (int i = 0; i < 10; i++)
{
    myDoubleArray[i] = Math.sqrt(i);
}
```

1. Before the `for` loop runs, what does `myDoubleArray` contain?
2. After the `for` loop runs, what is the first element in the array?
3. After the `for` loop runs, what is the last element in the array? What is its index?

<a name=""></a>**[SOLUTION]()**

1. Before the `for` loop runs, `myDoubleArray` contains 10 of the default `double` value, which is `0.0`.
2. After the `for` loop runs, the first element in the array (at index `0`) is `Math.sqrt(0)`, which is `0.0`.
3. After the `for` loop runs, the last element in the array (at index `9`) is `Math.sqrt(9)`, which is `3.0`.

<a name=""></a>**[EXERCISE]()** Find the error(s) in the following snippet. Fix it so it does what the comments say. What do you think an `ArrayIndexOutOfBoundException` signifies?

```java
// declare and instantiate an array with the first 8 fibonacci numbers
int[] myIntArray = {0, 1, 1, 2, 3, 5, 8, 13};

// print out every element in the array
for (int i = 1; i <= myIntArray.length; i++)
{
	System.out.println(myIntArray[i]);
}
```

<a name=""></a>**[SOLUTION]()**

An `ArrayIndexOutOfBoundsException` signifies that an array (or some other indexable object) was accessed with an invalid index. The index might be negative, or it might be larger than the largest index in the array.

```java
// declare and instantiate an array with the first 8 fibonacci numbers
int[] myIntArray = {0, 1, 1, 2, 3, 5, 8, 13};

// print out every element in the array
for (int i = 0; i < myIntArray.length; i++)
{
    System.out.println(myIntArray[i]);
}
```

### Editing arrays

Values within arrays can be reassigned just like variables.

```java
int[ ] numbers = {9, 8, 3, 6, 5, 4, 3, 2, 1};
        
numbers[2] = 7;
```

<a name=""></a>**[EXERCISE]()**

Create a program which repeatedly prompts the user for integers from 0 to 100. Each input integer should be classified on a grading scale as follows:

* 0-59 : F
* 60-69 : D
* 70-79 : C
* 80-89 : B
* 90-100 : A

Store, in an array, the number of A's, B's, C's, D's and F's. When the user enters a number greater than 100 or less than 0, stop looping and print the number of occurences of each grade that the user input. You may use the `Scanner` class's `nextInt` method, and do not need to worry about dealing with bad user inputs.

<a name=""></a>**[SOLUTION]()**  
Program:

```java
import java.util.Scanner;

public class GradeCounter
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner( System.in );

        int userInput;

        final int A_INDEX = 0;
        final int B_INDEX = 1;
        final int C_INDEX = 2;
        final int D_INDEX = 3;
        final int F_INDEX = 4;

        String[] gradeNames = {"A", "B", "C", "D", "F"};
        int[] grades = {0,0,0,0,0};

        while (true)
        {
            System.out.print("Enter the next grade : ");
            userInput = scan.nextInt();

            if (userInput < 0 || userInput > 100)
            {
                break;
            }
            else if (userInput >= 90)
            {
                grades[A_INDEX] += 1;
            }
            else if (userInput >= 80)
            {
                grades[B_INDEX] += 1;
            }
            else if (userInput >= 70)
            {
                grades[C_INDEX] += 1;
            }
            else if (userInput >= 60)
            {
                grades[D_INDEX] += 1;
            }
            else
            {
                grades[F_INDEX] += 1;
            }
        }

        System.out.println("You entered the following grades:");

        for(int i = 0; i < grades.length; i++)
        {
            System.out.println(gradeNames[i] + " : " + grades[i]);
        }
    }
}
```

Sample Run:

```
Enter the next grade : 89
Enter the next grade : 88
Enter the next grade : 95
Enter the next grade : 77
Enter the next grade : 89
Enter the next grade : 99
Enter the next grade : 92
Enter the next grade : 87
Enter the next grade : 83
Enter the next grade : 72
Enter the next grade : 66
Enter the next grade : 67
Enter the next grade : 89
Enter the next grade : 72
Enter the next grade : 55
Enter the next grade : -1
You entered the following grades:
A : 3
B : 6
C : 3
D : 2
F : 1

Process finished with exit code 0
```

### Arrays are passed by reference

Arrays are objects, so they are passed by reference. In the snippet below, `array_1` and `array_2` are actually references to **the same array**, so editing `array_2` also edits `array_1`.

```java
int[ ] array_1 = {9, 8, 3, 6, 5, 4, 3, 2, 1};
int[ ] array_2 = array_1;

System.out.println("array_1's address : " + array_1.toString());
System.out.println("array_2's address : " + array_2.toString());

array_1[2] = 7;

System.out.println("array_1's element at index 2 : " + array_1[2]);
System.out.println("array_2's element at index 2 : " + array_2[2]);
```

This has many implications. The most immediate example is: if a method edits an array that was passed in as an argument, the original array is also edited! To demonstrate, consider the following example:

```java
public class Sandbox
{
    public static void main(String[] args)
    {
        // declare and initialize an int
        int myInt = 5;

        // print the int's value
        System.out.println("myInt before the incrementInt call : " + myInt);

        // call incrementInt on the int
        incrementInt(myInt);

        // print the ints value again
        System.out.println("myInt after  the incrementInt call : " + myInt);

        // declare and initialize an array of ints
        int[ ] myIntArray = {0, 2, 4, 6, 8};

        // use a loop to print all of the array's values
        System.out.print("myIntArray before the incrementIntArrayElements call : ");
        for (int x : myIntArray)
        {
            System.out.print(" " + x);
        }

        // call incrementIntArrayElements on the array
        incrementIntArrayElements(myIntArray);

        // print the arrays values again
        System.out.print("\nmyIntArray after  the incrementIntArrayElements call : ");
        for (int x : myIntArray)
        {
            System.out.print(" " + x);
        }
    }

    public static void incrementInt(int integer)
    {
        // increment the integer
        integer++;
    }

    public static void incrementIntArrayElements(int[] integer_array)
    {
        // go through the array, incrementing each element
        for (int i = 0; i < integer_array.length; i++)
        {
            integer_array[i]++;
        }
    }
}
```

# TODO exercise from example above

### Copying Arrays

Often, it is necessary to create an edited version of an array while keeping the original unedited. Because arrays are passed by reference, and not by value, it is necessary to copy the original array and then edit the copy.

To copy an array:

* declare and initialize another array with the same data type and length.
* copy each element from the original array into the copy.

The following class `IntArrayUtils` contains the method `copyIntArray` which takes an `int[ ] ` as an argument, and copies this array into a second array, which it returns.

<a name = "IntArrayUtils"></a>

```java
public class IntArrayUtils
{
    public static int[ ] copyIntArray(int[ ] original)
    {
        int[ ] copy = new int[original.length];

        for (int i = 0; i < original.length; i++)
        {
            copy[i] = original[i];
        }
        return copy;
    }
}
```

### `StringBuilder`

When building a `String` in pieces, it is prudent to use the `StringBuilder` class instead of repeatedlying using `String` addition. The reason has to do with how memory is allocated for `String` variables under the hood. When you create a `String`, enough space is allocated to store all of its contained characters, and then the variable is given a pointer to that allocated space to reference the `String` value.

Whenever a `String` variable is given a new value (say, through `String` addition), space is allocated for the entirety of this new `String` value and then the new value is written, character by character, into this new space. Then, the space for the old `String` value is deallocated (assuming there are no other references to it).

Memory allocation and deallocation are expensive and we generally want to avoid doing them more than necessary; it is also wasteful to repeatedly copy the start of a `String` into larger and larger spaces when adding more to the end of it. In the example below, each time the `+=` operator is used in the loop, memory for the new `String` value is allocated, then the value is copied into this space, and then the memory for the old `String` value is deallocated.

```java
Scanner scan = new Scanner(System.in);

System.out.println("Enter 10 words");
String words = "";
    
for (int i = 0; i < 10; i++)
{
    words += scan.next() + " ";
}

System.out.println("You entered: " + words);
```

The `StringBuilder` stores a list of individual `String`s, so that they can all be "added up" at once. The snippet below does the same as the one above, but uses `StringBuilder` to save time.

```java
Scanner scan = new Scanner(System.in);

System.out.println("Enter 10 words");
StringBuilder words = new StringBuilder();

for (int i = 0; i < 10; i++)
{
    words.append(scan.next());
    words.append(" ");
}

System.out.println("You entered: " + words.toString());
```

This does not help the memory allocation and deallocation issue in terms of the **number** of allocations, as each "chunk" of the final `String` mush have space allocated, but it does make the **size** of the allocated chunks smaller, which makes allocation easier. It also saves us from repeatedly copying the first word in the `String` each time another word is added to the end.

If you type the first snippet (which uses `+=` on `String`s in a loop) in IntelliJ, the `+=` operator will be highlighted in yellow. Mousing over this highlight will reveal the warning `String concatenation '+=' in loop` along with a suggestion (in blue) to use the `StringBuilder` class instead. Clicking this suggestion will change the snippet to one very similar to the second one above, which uses `StringBuilder`.

### Swapping array elements

When swapping array elements, there is a small problem which must be overcome. If one value is used to overwrite the other value, then the overwritten value is no longer accessible and cannot be used to overwrite the other. This problem is dealt with useing a temporary storage variable. The snippet below swaps the values at index `3` and `5` in the `numbers` array.

```java
int[ ] numbers = {9, 8, 7, 4, 5, 6, 3, 2, 1};
        
int temp = numbers[3];
numbers[3] = numbers[5];
numbers[5] = temp;
```

## Start Task 1

Here, you'll want to download 

## Pseudocode, Sorting and Searching Arrays

Often it is desired to sort array data. There are many ways to do this. Before continuing, watch [this video](https://www.youtube.com/watch?v=g-PGLbMth_g) on Selection Sort.

Selection Sort is an **algorithm**: a finite sequence of well-defined, computer-implementable instructions, typically to solve a class of problems or to perform a computation. In this case, the problem being solved is that of sorting an array in non-decreasing order.

Algorithms are often represented in **pseudocode**. Pseudocode is simply a description of the algorithm written in a structured way (generally somewhat similar to code), but pseudocode is not written in any particular language; it is instead written for humans to read, so that they might implement algorithms in any desired language.

### Selection Sort

Below we have pseudocode for Selection Sort:

```
Selection Sort
IN: arr is an unsorted array of numbers, with length n, indexed 0 to n-1

for i in [0, n-2]
	min = i
	for j in [i+1, n-1]
		if arr[min] > arr[j]
			min = j
	swap the elements in arr at indices i and min

OUT: arr has been sorted in non-decreasing order
```

Notice that the algorithm above is not written in Java, and will not compile in Java. It is instead written in a less formal format for humans to read. Blocks, denoted in Java with curly braces `{}` in Java, are denoted via indentation above; you can tell what is "inside" the outer loop because its contents are indented below it. Pseudocode often uses a mix of notations from programming and mathematics. In the pseudocode above, the pairs in brackets `[0, n-1]` and `[i, n]` denote closed intervals. In general, these would be closed intervals of real numbers, but because we're using the elements of these intervals as indexes we know they must be integers---this does not need to be specified as formally as it would in an actual program, because the pseudocode is intended to be read by humans. This is most apparent in the last line of the outer loop, which is written out as a sentence.

The structure of the pseudocode is arbitrary; I simply wrote it in a way that make sense to me. Pseudocode can really be any unambiguous sequence of instructions. Any recipe which describe how and when to add ingredients is arguably pseudocode, so long as it is sufficiently unambiguous. Usually, when instructions are referred to as pseudocode, it is in the context of either mathematics or programming, though, and in these situations psuedocode usually looks like a mix of code and english describing an algorithm independent of any programming language.

When an algorithm is translated from pseudocode into a programming language, this is called an **implementation** of the algorithm. Below is an implementation of Selection Sort for use on `int[ ]`s in Java. 

```java
public static void selectionSort(int[ ] arrayToSort)
{
    for (int i = 0; i < arrayToSort.length-1; i++)
    {
        int min = i;
        for (int j = i+1; j < arrayToSort.length; j++)
        {
            if (arrayToSort[j] < arrayToSort[min])
            {
                min = j;
            }
        }
        int temp = arrayToSort[i];
        arrayToSort[i] = arrayToSort[min];
        arrayToSort[min] = temp;
    }
}
```

# TODO exercise add the implementation above to your IntArrayUtils class. Shorten the implementation above by using the swapIntArrayElements method made earlier. Test it and verify that it works!

### Searching Unsorted Arrays

It is sometimes necessary to search an array for a specified value. If the value is there, it's index is generally what is returned. If the array isn't sorted, this can be a painfully slow procedure, as it is necessary to simply iterate through the array, one element at a time, looking for the specified value. This is called a sequential search:

```
Sequential Search
IN: 	array A, desired value v

i = 0
while i < length(A)
	if A[i] is v, then return i
	i = i + 1

return -1

OUT:	the index of v, if A contains c
		-1, otherwise
```

### Searching Sorted Arrays

There are a variety of ways to search a sorted array for a specified value, all faster than sequential search. Check out [this video](https://www.youtube.com/watch?v=j5uXyPJ0Pew) on binary and sequential search. Note that the pseudo code written in the video looks more like Java than mine, but it is still pseudocode, not Java.

# TODO exercise implement sequential search in IntArrayUtils

# TODO exercise implement binary search in IntArrayUtils


### Bubble Sort

Watch [this video](https://www.youtube.com/watch?v=xli_FI7CuzA) on Bubble Sort.

Here is pseudocode for Bubble Sort:

```
Bubble Sort
IN: arr is an unsorted array of numbers with length n, indexed 0 to n-1

for i in [1, n-1]
	for j in [0, n-i-1]
		if arr[j] > arr[j+1]
			swap the elements in arr at indices j and j+1

OUT: arr is sorted
```

# TODO exercise implement and test Bubble Sort in your IntArrayUtils class.

## Array Nestability and Multi-Dimensional Arrays

Arrays can contain elements of any data type, including other arrays. In this way, multi-dimensional arrays can be made. The following snippet declares and instantiates an array representing the multiplication table for integers 0 through 9.

```java
int[ ][ ] multiplicationTable = {
        {0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
        {0,  1,  2,  3,  4,  5,  6,  7,  8,  9},
        {0,  2,  4,  6,  8, 10, 12, 14, 16, 18},
        {0,  3,  6,  9, 12, 15, 18, 21, 24, 27},
        {0,  4,  8, 12, 16, 20, 24, 28, 32, 36},
        {0,  5, 10, 15, 20, 25, 30, 35, 40, 45},
        {0,  6, 12, 18, 24, 30, 36, 42, 48, 54},
        {0,  7, 14, 21, 28, 35, 42, 49, 56, 63},
        {0,  8, 16, 24, 32, 40, 48, 56, 64, 72},
        {0,  9, 18, 27, 36, 45, 54, 63, 72, 81}
};
```

Here, each index of the `multiplicationTable` is a **sub-array** (i.e. a row) in the 2D array above; `multiplicationTable[0]` is `{0,  0,  0,  0,  0,  0,  0,  0,  0,  0}`, `multiplicationTable[3]` is `{0,  3,  6,  9, 12, 15, 18, 21, 24, 27}`, and so on.

These sub-arrays are, themselves, arrays, so they can be indexed; `multiplicationTable[0][0]` is the first element of `multiplicationTable[0]`, i.e. `1`. `multiplicationTable[5][6]` is `30`.

Note that `multiplicationTable` has 10 sub-arrays, each of which contain 10 integers. The same array can be made by first declaring an array with default values (`0`s) and then assigning new values in a nested loop like this:

```java
int[ ][ ] multiplicationTable = new int[10][10];
        
for (int i = 0; i < 10; i++)
{
    for(int j = 0; j < 10; j++)
    {
        multiplicationTable[i][j] = i * j;
    }
}
```

The above examples are 2 dimensional (notice the 2 sets of brackets in the data type `int[ ][ ]`). Arrays can be made with any desired dimension.

In a multi-dimensional array, sub-arrays do not need to all be the same shape. For instance, the following is a completely valid array initialization:

```java
int[ ][ ] numbers = {
        {1},
        {2, 3},
        {4, 5, 6, 7},
        {8, 9}
};
```

Here `numbers` is an array containing 4 `int[ ]`s which have lengths 1, 2, 4 and 2 respectively.

## `String` again, and Regular Expressions

We've explored some `String` methods briefly in prior labs. Here, we will explore a few of them in more detail. We will also touch on the `StringBuilder` class, which can be used to (you guessed it) build `String`s piece by piece, and regular expressions, which can be used to match patterns to more efficiently interpret and categorize `String` values.

### `String`s are sequences

Much like arrays, `String`s are sequences whose elements (`char`s) can be accessed with their index.

Consider the following snippet:

```java
String hello = "Hello";
```

The statement above creates a `String` called `hello` and stores in it the value `"Hello"`. We can visualize this value and its indexes much like an array:

| **`char`** | `'H'` | `'e'` | `'l'` | `'l'` | `'o'` |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: |
| **index** | **0** | **1**| **2** | **3**| **4** |

Where arrays use square brackets to access elements by their index, `String`s use the `charAt` method to access elements at specified indexes. From the for example, in the snippet above, `hello.charAt(1)` is an expression which would return the `'e'` from `"Hello"`.

# TODO String indexing exercise

### The `substring` method

A piece of a `String` containing multiple characters can be gotten with the `substring` method. The `substring` method takes two arguments: the start and end indexes of the desired substring. It returns a substring starting at the provided start index and ending with the index before the provided end index. With `hello` defined in the snippet above, `hello.substring(1, 4)` would return the substring `"ell"`; each character, starting at index `1` and before index `4`. The end index can be omitted; if it is, then all characters from the start index to the end of the `String` are included in the substring. For instance, `hello.substring(3)` returns `"lo"`: every character from index `3` to the end.

# TODO `substring` exercises

### The `indexOf` and `lastIndexOf` methods

The `String` class's `indexOf` and `lastIndexOf` methods can be used to find the index of specified characters or substrings. `indexOf` is polymorphic. Its simplest form takes a `char` as an argument, and outputs the index of the first occurrence of that `char` in the `String` calling it, or `-1` if there no occurence of the designated character. For instance, `hello.indexOf('l')` returns `2`, because `2` is the index of the first `'l'` character.

`lastIndexOf` is very similar to `indexOf`, and the difference in behavior is implied by its name. What does `hello.lastIndexOf('l')` return with `hello` defined as above?

There are more complex forms of each of these functions, which take extra arguments to perform more complex tasks (like, say, finding the index of the first occurrence of the designated character on or after a specified index, or finding the starting index of a designated substring). Check out the [Java 8 String API](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html) to learn more.

# TODO indexOf substring phone number and name exercises

### Escape Sequences

In a `String` literal, the backslash `\` is used to start **escape sequences**. Escape sequences are sequences of characters that have a different meaning than the literal sequence. They are often used to represent "special" characters (like newline `'\n'` and tab `'\t'`). They are also used to ensure that other characters are interpretted literally, when they would otherwise have some additional meaning in context. For instance, putting the double quote `'"'` character in a `String` literal requires a backslash, otherwise the double quote character **ends the string**. 

Try assigning and printing each of the following `String` literals to a `String` variable and printing them (if possible). Try to figure out what each of the escape sequences means, which examples below are invalid and why they're invalid.

`"She said "Hello""`  
`"She said \"Hello\""`  
`"Up here\nDown there"`  
`"Block\n\tIndentedBlock"`  
`"\"`  
`"\\"`  
`"\\\\"`  
`"\\\\\\"`  
`"Not this\rThis only but why?"`  

The last one escape sequence, `\r`, denotes a **carriage return**, an antique carried from the typewriter into early (bad) encodings for text files. On typewriters, going to a new line was done with two keystrokes, one to go down a line (the line feed) and one to go back to the left side (the carriage return). Most modern editors use just a line feed `\n` to denote **both** of these. Some editors (primarily on Windows machines) still use the carriage return after the line feed, which will lead to multiple headaches throughout your years of practice as a programmer when reading data from files.

# TODO escape sequence exercise

## Regular Expressions

Check out [this video](https://www.youtube.com/watch?v=sa-TUpSx1JA) on regular expressions. You can download the text editor that he's using (called Atom) [here](https://atom.io) if you'd like to experiment with regular expressions in it.

# TODO exercises regex

The video covers some universals of regular expressions. Most regular expression implementations have significantly more functionality built in. In Java, regular expressions are implemented through the `Pattern` class (imported from `java.util.regex`). You can find the documentation [here](https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html).

The regular expression `\d{3}-\d{3}-\d{4}` could be used to match phone numbers in the form **XXX-XXX-XXXX**. In order to use this regular expression in Java, we need to create a member of the `Pattern` class using the regular expression in `String` form. The program below prompts the user for a phone number in a specified format, and then checks if the input matches the pattern:

```java
import java.util.Scanner;

public class Sandbox
{
    public static void main(String[] args)
    {
        String phoneNumberRegex = "\\d{3}-\\d{3}-\\d{4}";

        System.out.println("Enter a phone number in the form XXX-XXX-XXXX");
        
        Scanner keyboard = new Scanner( System.in );
        String userPhoneNumber = keyboard.next();
        
        if (userPhoneNumber.matches(phoneNumberRegex))
        {
            System.out.println("That looks like a phone number to me!");
        }
        else
        {
            System.out.println("What is this garbage? I said a PHONE NUMBER.");
        }
    }
}
```

Notice the difference between the regular expression in the program above (in the Java implementation) and the one to match phone numbers before it: all of the escapes `\` are doubled. This is because the regex is being processed twice: first as a `String` and then as a regular expression. In other words, the `String` literal `\\d{3}-\\d{3}-\\d{4}` results in a `String` storing the sequence of characters `\d{3}-\d{3}-\d{4}`, because the backslash character `\` is a metacharacter in `String`s, so it must be escaped to appear in a `String`.

# TODO exercises regex in Java

## `ArrayList`

The `ArrayList` class is essentially an array wrapped in an object with a bunch of extra methods and capabilities. You can find its documentation [here](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html).

One of the most convenient differences between an `ArrayList` and an array is that `ArrayList`s are dynamically sized. This means that the number of elements they contain can be changed, and does not need to be specified during construction.

`ArrayList`s can only store objects, they cannot store primitives. Any time it would be convenient to store primitives in an `ArrayList`, just use the corresponding wrapper classes. For example, `int` data cannot be stored in an `ArrayList`, but `Integer` data can.

The `ArrayList` class contains many methods; we will only explore a few of them here, but the documentation describes them all.

The example below shows how to instantiate, and `ArrayList` with no elements, how to add elements to the end of the list, and how to access those elements, with their index.

```java
import java.util.ArrayList;
import java.util.Scanner;

public class Sandbox
{
    public static void main(String[] args)
    {
        ArrayList<String> words = new ArrayList<>();
        Scanner scan = new Scanner ( System.in );

        System.out.println("Enter words. Enter \"END\" to stop.");
        String userInput = scan.next();

        while (!userInput.equals("END"))
        {
            words.add(userInput);
            userInput = scan.next();
        }

        System.out.println("You entered " + words.size() + " words.");
        System.out.println("Here are the words you entered :");
        for (int i = 0; i < words.size(); i++)
        {
            System.out.println(i+1 + ". " + words.get(i) + " ");
        }
    }
}
```

Note the differences in how the `ArrayList` is accessed compared to the standard array: elements are accessed with their using the `get` method. The number of elements in the array is accessed using the `size` method. The value at a specified index can be changed using the `ArrayList`'s `set` method.

# TODO ArrayList exercises

# TODO Lab Tasks
