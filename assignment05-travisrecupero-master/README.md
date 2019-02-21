# assignment05 due Sept 28, 11:59pm
The code goes in the package `assignment05`

<h2> Update 1: Added a bit more advice here </h2>

Make a class `TwoDimNumArr` with a private field `int[][] array`. Write a constructor `public TwoDimNumArr(String fileName) throws FileNotFoundException` 
that takes a multi-line input file of `ints` like the one in Assignment 4. Copy the code from NumReader so that this constructor fills `array` 
with rows of ints from the file. <b>Hint: You can and probably should copy over the `private static int readString()` method from assignment04, and use it in the constructor here.</b>

<h2>Update 2: Wrong return type mentioned here, should return a String not void</h2>

Write a method `public String toString()` which returns a single String that will print the original fill (almost).

For example if the input file "input.txt" is 

```
1 4 2 18 12   

2
 1 5 23 -10 6 8   
7 -100
   34 6 0 
```

and var test = new TwoDimNumArr("input.txt");
then System.out.println(test); will be

```
1 4 2 18 12
2
1 5 23 -10 6 8
7 -100
34 6 0
```
NOTE the blank line has been lost and spaces at the start of a line are gone. 

<h2>Update 3: Meant to use StringBuilder not StringBuffer</h2>

IMPORTANT: Learn about [StringBuilder](https://docs.oracle.com/javase/10/docs/api/java/lang/StringBuilder.html) for this method. 
Note that using StringBuffer to build up a String is more efficient that using lots of concatenations.

```java
public String toString() {
	StringBuilder sb = new StringBuilder();
	for(var row : array) {
        for(var num : row) {
            //look up the append method of StringBuffer to append (num + " ") to sb
        }
	    // set the length of sb to sb.length()-1 to get rid of last space on the line
	    //Hint: you will need StringBuilder's setLength() method, see the API mentioned in the link above
	    // append a new line character "\n"
	}
	return sb.toString();
}
```
<h2>Update 4: Added some things to note here</h2>

Write a method `public boolean compare(String filename) throws FileNotFoundException ` that returns true if field `array` has the same ints 
in the same order as the file. You can copy the `flatten` method into this class. <b>You will notice that it is similar to the compare method from assignment04, however, the method is no longer static. We are comparing the contents inside fileName to the field `array` now, that is the only major difference.</b>

<h2>Update 5: more information provdied about compareTo</h2>

Write a method `public int compareTo(TwoDimNumArr other)` which returns [Arrays.compare(flatten(this.array), flatten(other.array))](https://docs.oracle.com/javase/10/docs/api/java/util/Arrays.html#compare(int%5B%5D,int%5B%5D))

<b>The compareTo() method returns an integer value. In general, when we call a.compareTo(b), we are essentially putting an ordering on the objects a and b. We say we are comparing object a to b. We want a notion as to whether one object is bigger/smaller than the other. There are three possible return values.</b>  

>if a.compareTo(b) returns a negative value, that means that a is considered strictly less than b.  
if a.compareTo(b) returns a positive value, that means that a is considered strictly greater than b.   
if a.compareTo(b) returns zero, that means a is considered equal to b.  
  
It is also important to note that b.compareTo(a) (comparing b to a) is different from a.compareTo(b) (comparing a to b).
The order matters here.
Note that if a.compareTo(b) returns a positive value, that means a is greater than b (in other words, b is less than a).
Thus, b.compareTo(a) would have return a negative value, since b is less than a. 

Why is this useful? Well, it's nice to be able to compare integers right, for instance we know 3 < 5. It is also desirable to put an ordering on objects in general, because then we can sort them for instance. 

<h2>Update 6: Need to change the last compareTo() here</h2>

Create a Tester class with a main method for testing. Find three files test1.txt, test2.txt, test3.txt. so that we get these results:

```
var v1 = new TwoDimNumArr("test1.txt"); 
var v2 = new TwoDimNumArr("test2.txt"); 
var v3 = new TwoDimNumArr("test3.txt");
System.out.println(v1.compareTo(v2)); // prints a negative number
System.out.println(v1.compareTo(v3)); // prints 0 but test1.txt and text2.txt have different numbers of rows

//NOTE THIS WAS CHANGED, USED TO BE v3.compareTo(v2). You need to update this!
System.out.println(v2.compareTo(v3)); // prints a positive number
```

Make a class `Locations`. It is just for practice with arrays but let's also introduce the class [`java.util.Random`](https://docs.oracle.com/javase/10/docs/api/java/util/Random.html)
There is a private field `int[] array` and a field `public static final Random rand = new Random()`. It is public so that in the Tester class we 
can use `Locations.rand.nextInt()` for example. In the class Locations make two constructors. One is for the TAs to test your code: it has one `int[]` 
parameter to set the value of the field `array`. The other is as follows:

```java
public Locations() {
	make an int len with the value 10+rand.nextInt(50);
	set array to be an int array with length len
	in a for loop set each array[i] to some randome value: rand.nextInt(100);
}
```
Provide a getter method for the field `array`.

Write a method `public int[] lessEQ(int[] test)` that returns an array of all the indices where `array[i] <= test[i]`. This time we will do it the easy way!
If array is null or test is null the return value is null. If array or test have length 0, the return value is the empty array. Make a List<Integer> instantiated as 
an ArrayList. Loop through the elements of array and test together, stopping at the end of the shorter one. Each time `array[i] <= test[i]` add `i` to the list.
At the end make an `int[] retVal` of length equal to the size() of the list and copy the elements of the list into this `retVal`. Return this array. 

In the Tester class make a Locations object using the random constructor and check that `lessEQ` works for the null, empty and non-empty values of `test`.

Make a class DiaryEvent. There are 3 private fields description (String), start ([LocalDateTime](https://docs.oracle.com/javase/10/docs/api/java/time/LocalDateTime.html)), duration (int).

Write a constructor `public DiaryEvent(String des, int year, int month, int day, int hr24, int min, int dur)`. Note that `dur` is the duration of the event in minutes. Use this `of` [method of LocalDateTime](https://docs.oracle.com/javase/10/docs/api/java/time/LocalDateTime.html#of(int,int,int,int,int)), note that the hr24 parameter is a value from 0 to 23 (the 24-hour clock) 
<b>Based off the documentation, note we need the import `java.time.LocalDateTime` here.</b>
Write a simple toString method that will return "Office Hours at 2018-09-18T14:30, lasting 60 minutes" if the constructor habeen called as `var test = new DiaryEvent("Office Hours", 2018, 9, 18, 14, 30, 60);` NOTE the format 2018-09-18T14:30 comes from the toString already provided in LocalDataTime. What is being done here is that you are returning a String with the three fields interspersed with " at ",  ", lasting " and " minutes"
Add the following methods:

```java
public boolean before(DiaryEvent de) {
	return start.compareTo(de.start) < 0;
}
public boolean after(DiaryEvent de) {
	return start.compareTo(de.start) > 0;
}
```
The `compareTo` method is provided in the Java library, which means you do not need an import to use it.

<h2>Update 7: Added more clarity for monthBreakdown</h2>
  
Write a method `public static int[] monthBreakdown(DiaryEvent[] array)` which returns an array `arr` of length 13 so that `arr[i]` is the number of DiaryEvents that hava a start in month `i`. Please use getMonthValue(), a method that you can call on the `start` field inside each DiaryEvent. Also note that for the returned array, index 0 is not going to be used here, index 1 corresponds to January, and index 12 corresponds to December.

<h2>Update 8: Added more clarity for earliest()</h2>
  
Write a method `public static DiaryEvent earliest(List<DiaryEvent> list)`, which returns the `DiaryEvent` that has a `start` before any other `DiaryEvent` in `list`. If there are several, return the first in the list. <b>Note you can utilize the before or after methods we had you include to compare DiaryEvents.</b>

<h2>Update 9: Added clarity here</h2>

Add test cases to Tester so that monthBreakdown() returns an array that indicates the DiaryEntry[] passed in held:
>5 months containing at least 1 DiaryEntry  
>4 other months containing at least 2 DiaryEntries  
>at least 1 month different from the above 9 months, containing at least 3 DiaryEntries.  
>note that this means you should have at least 10 months with DiaryEntries  
  
Write a class `Counter5`.  It has 2 methods: `public static int[] counter(String[] strings, char ch)` and `public static List<Integer> counter(List<String> strings, char ch)`. 
  
The first counter method returns `null` if `strings` is `null` and otherwise an array `retVal` of length 3, where `retVal[0]` is the number of null Strings in the array `strings`, `retVal[1]` is the number of empty Strings in `strings`, and `retVal[2]` if the total number times the char `ch` in upper or lower case occurs in all the Stings in `strings`. 
  
Tips: `[Character.toUpperCase(c)](https://docs.oracle.com/javase/10/docs/api/java/lang/Character.html#toUpperCase(char))` will give you the upper case version of any char `c`. There is a similar method `[Character.toLowerCase(ch)](https://docs.oracle.com/javase/10/docs/api/java/lang/Character.html#toLowerCase(char))`. It is also useful to use `for(var c : str.toCharArray())...` to go through the array instead of `for(var i = 0; i < str.length(); i++) { var c = str.charAt(i); ...`
  
The method `public static List<Integer> counter(List<String> strings, char ch)` is similar. The return value `List<Integer> retVal` is an ArrayList, which is `null` if `strings` is `null`, otherwise `retVal.get(0), retVal.get(1), retVal.get(2)` are respectively the number of null Strings, the number of empty Strings and the number of upper or lower case occurrences of `ch` in all the Strings in `strings`.  Rather than making an array and coverting that to a List at the end of the method, please do the extra work of modifying the ArrayList directly: for example, `retVal.set(2, ret.get(2)+1)`.
  
Add test cases to the Tester class to tests the null cases of thse two methods as well as non-null cases where all three elements in the return values are not zero. 

<h2>Update 10: A hint about the null tests</h2>
  
One thing to note: we say the counter method has been overloaded here, there are two methods with the same name in this class. However, each method takes slightly different arguments, which means java knows which counter() method you are calling based on what type of arguments you are passing in. For the null test cases, you probably will run into issues if you just pass in null for the first argument. Is it a null List or a null array? Try this for yourself. You will run into an error message that says "reference to counter is ambiguous". Think of a way to be able to test the null edge cases, such that it can differentiate which compare() method you intend to call.
