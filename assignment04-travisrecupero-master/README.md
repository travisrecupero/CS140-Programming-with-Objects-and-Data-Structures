# assignment04 DUE FRIDAY SEPT 21, 11:59pm

Since we have Wednesday off for Yom Kippur and some of the class need to travel, we will make this assignment due on Friday.

The work goes in the package `assignment04`.

Make a text file, for example `test.txt` and out in several integers over several lines. There should be some blank lines and a line with only one integer but most lines should have several integers with a different number of integers in each line (all separated by spaces--including spaces at the start of the line), for example

```
1 4 2 18 12

2
 1 5 23 -10 6 8
7 -100
   34 6 0 
```

DO NOT put any integers that are not ints (they must be between Integer.MIN_VALUE (-2147483648) and Integer.MAX_VALUE (2147483647)

Make a class `NumberReader.java`. In this class make a method `private static int[] readString(String line)`. It is private because it will only be used by one of the other methods in the class and not from outside the class. We assume that `line` will be like a line from the test file above and will be a String that only contains integers separated by spaces. Here is the structure we want, with some comments for explanation:

```java
private static int[] readString(String line) {
	// first count how many integers are in the line
	var count = 0; // in Java 10 we can use "var" and Java infers the type.
	try(var lineScan = new Scanner(line)){ // this is "try with resources"
						// the Scanner will be closed automatically
						// if anything goes wrong
		while(lineScan.hasNextInt()) {
			// increase count
			// use nextInt() to move to the next integer
		}
	}
	// make an array with length count
	var retVal = ....
	try(var lineScan = new Scanner(line)){ // open the scanner again from the start
		// in a for loop with i from 0 up to but not including count
		// set retVal[i] = lineScan.nextInt();
	}		
	return retVal;
}
```

NOTE the nuisance that we have to traverse `line` twice: once to find out how many integers are there and once to out the integers into the array that has the correct length.

<h2>Update 1: NumberReader1 was a typo</h2>

In `NumberReader` make a method `public static int[][] readArray(String fileName) throws FileNotFoundException`, which will store all the numbers from your test file in an array of arrays (a 2-dimensional array)

The structure is the same as readString

1. Make a counter `count`
2. Open the Scanner with `try(var scan = new Scanner(new File(fileName))) {` (note this is the line that could throw FileNotFoundException)
3. In a while loop that has the condition `scan.hasNextLine()` add 1 to the counter and move to the next line using `scan.nextLine()`.
4. Now make a 2 dimensional array for the return value (note we know the number of rows is equal to the number of lines in the file but that is all we know at this point):

```
var retVal = new int[count][];
```

5. Reopen the scanner using instruction 2 above.
6. In a for loop with `i` from 0 up to but not including `count` set `retVal[i] = readString(scan.nextLine())`
7. Return `retVal`

Make a class `NumberReader2.java`. In this class make a method `private static List<Integer> readString2(String line)`, which returns an `ArrayList` version of the array returned by `readString` in the class `NumberReader`. As before, we are assuming `line` contains integers separated by spaces. Note that we only need a single _while_ loop (and no for loop) because there is no need to find out how big to make the ArrayList before putting the elements into it.

<h2>Update 2: readList2 should be a static method</h2>

Make a method `public static List<List<Integer>> readList2(String fileName) throws FileNotFoundException` which returns and ArrayList of ArrayLists similar to the 2 dimensional array returned by `readArray` in the class `NumReader`. HINT: the return value is declared this way: `List<List<Integer>> retVal = new ArrayList<>();` and in the while loop you should have `retval.add(readString2(scan.nextLine()))`

Write a `Tester` class that checks that the array and the list produced by `readArray` and `readList2` by printing out the content and seeing that all the integers are there. NOTE that the `main` method should throw `FileNotFoundException`.

Back int `NumberReader` write a method `public static int[] flatten(int[][] arrays)`, which makes one long one-dimensional array by joining together all the rows of the two dimensional array. First add up all the lenghts of the rows:

```java
//either 
for(var arr : arrays) add up each arr.length
//or
for(int i = 0; i < arrays.length; i++) add up theeach arrays[i].length
//not that the length of each row arrays[i] may be different.
```
Make a 1-dimensional array of this total length and loop through all the rows inserting the elements into this 1-dimensional array.

For the 2-dimensional array obtained from the file above, the result of flatten will be
`[1, 4, 2, 18, 12, 2, 1, 5, 23, -10, 6, 8, 7, -100, 34, 6, 0]`

In `NumberReader2` write a method `public static List<Integer> flatten2(List<List<Integer>> list)` which does the same flattening to make a single list from the list of lists. Of course, you do not have to compute the total length of the output before copying over the elements of the rows into the output.

Add tests to your `Tester` to make sure these flatten methods work.

In `NumberReader` write a method `public static boolean compare(int[][] arrays, String filename) throws FileNotFoundException` which compares the sequence of all the numbers in the file to all the numbers in the rows of the 2-dimensional array. You do this by making the 1-dimensional array `var flat = flatten(arrays)` and use a Scanner to go though the ints in the file (use a try-with-resources to create the Scanner). As you go through `flat` compare the elements with the `nextInt()` in the Scanner--if thers is one. If you find two elements that do not match the return value is `false`. If you run out of elements from the Scanner while there are elements in `flat`, the return value is `false`; if the file has more elements after `flat` is exhausted, the return value is `false`. Otherwise, if everything matches, you return `true`.

Take the test file above, make 3 copies. In one remove an element, in a second add an element, and in a thirf change one of the elements. Then in `Tester` check that the `compare` method gives `true` with the original file and `false` with the 3 modified files.

In `NumberReader2` write a corresponding method `public static boolean compare(List<List<Integer>> list, String filename) throws FileNotFoundException` and insert tests in the `Tester`.

PART 2. We have seen the use of the Java-defined `List<>` interface and we built our own `Occupation` interface in Assignment 3. Today we will use the very helpful `Set<>` interface. A set is jsut like a mathematical set: you can add things and remove them but the set will only keep one copy of an element even if you add it several times. Just as `List<>` needs a concrete implementation such as `ArrayList<>`, `Set<>` needs a concrete implementation and this time we use `HashSet<>`. Both `Set<>` and `HashSet<>` are imported from `java.util`. 

The next new feature we will introduce is the `enum` type. I will explain the components of this enum in class on Monday. To use this class you need to know that you refer to elements as `Courses.CS140`, `Courses.CS220`, `Courses.CS573`, etc., and you can use crs.getPrereqs() to see the list of Courses that are prerequisites of the course crs (where crs is one of `Courses.CSXXX` in the enum).

Here is the `enum` but NOTE that MATH and some other prerequisites, as well as some electives, are missing. Note that "Set.of" works like "List.of", which we used in a previous Lab. "Set.of" makes an immutable set of the elements listed. Save the enum as `Courses.java`.

```java
package assignment04;
import java.util.Set;
public enum Courses {
	//DISCLAIMERS:
	//NOT ALL ELECTIVES ARE HERE
	//ALL MATH PREREQS ARE MISSING
	//CS301 PREREQS ARE MISSING A "C" GENED AND CS220 OR CS240
	//THE DESIGN OF THIS ENUM CANNOT HANDLE "corequisites" OR 
	//ALTERNATIVE PREREQS
	CS101(null), CS110(null), CS120(Set.of(CS110)), CS140(Set.of(CS110)), 
	CS220(Set.of(CS120,CS140)),	CS240(Set.of(CS120,CS140)), 
	CS301(Set.of(CS101)), CS320(Set.of(CS220)), 
	CS350(Set.of(CS220,CS240)), CS373(Set.of(CS140)), CS375(Set.of(CS240)), 
	CS471(Set.of(CS373,CS375)),	CS402(Set.of(CS220,CS240)), 
	CS426(Set.of(CS350)), CS428(Set.of(CS350)),	CS431(Set.of(CS428)), 
	CS432(Set.of(CS375)), CS435(Set.of(CS375)), CS436(Set.of(CS375)), 
	CS440(Set.of(CS240,CS350)),	CS442(Set.of(CS140,CS375)), 
	CS445(Set.of(CS375));
	
	private Set<Courses> prereqs;
	Courses(Set<Courses> set){
		prereqs = set;
	}
	public Set<Courses> getPrereqs() {
		return prereqs;
	}	
}
```
Write a class `Student`, with 2 _private_ fields: `String name` and `Set<Courses> taken = new HashSet<>()`. Provide a constructor with a String parameter that sets the value of `name`. Write getter methods for the 2 fields. Write a method 
`public void addCourse(Courses crs)` which adds `c` to `taken`: `taken.add(c);`

ADD 2 MORE REAL ELECTIVES WITH THEIR PREREQUISITES TO THE LIST IN Courses (THEY MUST GO BEFORE THE ";" AT THE END OF THE enum VALUES)

Back in `Student`, write a method `public Set<Courses> needToTakeBefore(Courses crs)` which gives a list of all the CS courses the student needs to take before taking courses `crs`, based on the courses the student has taken so far (assuming at least a C-).

It is a bit tricky to avoid `ConcurrentModificationException` while adding the courses that need to be taken. Here is one approach:

<h2>Update 3: Added an alternative way to remove taken courses, using an Iterator</h2>

```java
public Set<Courses> needToTakeBefore(Courses crs) {
	// make a Set called needed (declated and instantiated the same as taken)
	// add crs to needed
	// this is like "bubble sort"
	// declare a boolean changed set to true
	while(changed) {
		//set changed to false
		//make a temporary int with the value needed.size();
		//make another Set called temp (just line needed)
		for(Courses d : needed) //if the getPrereqs of d are not null, call
			temp.addAll(d.getPrereqs());
		//addAll of temp to needed
		//if the size if needed is now bigger than the values stored earlier
		//set changes to true;
	}
	//for each of the Courses in taken remove it using needed.remove(...);
	//You could alternatively use an iterator here, create an Iterator<Courses> iter of needed
	//use a while loop, where the condition is iter.hasNext()
	//and if taken.contains() a Courses gotten from iter.next(), then call remove on the iterator in such a case.
	//(If the other works for you, you are not required to use an iterator here.)
	
	//remove crs form needed
	return needed;
}

```
Test your method. You may put the main method in the class Student for testing if you wish. You add a course to a `student` using `student.addCourse(Courses.CS140)`. When you test your code, it may be that the needed courses include Courses.CS110 when the student had CS 110 waived. Don't panic, that just shows how complicated it is to write a program that can take care of all the special cases--this one does not.

