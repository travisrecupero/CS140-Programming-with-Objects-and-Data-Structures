Assignment 2, due Wednesday September 5, 11:59pm
===

Everything goes in the <b>package assignment02</b>.

<h1>One Change Class</h1>  
  
Make a class **`OneChange`**. It has a private field **`int[] array`**. Give it a constructor with one parameter that is an array of int that sets the value of this field.
  
Provide a method **`public int smallestAfter(int start)`** that returns the first index in the array greater than or equal to **`start`** where **`array[index]`** is the smallest value among the array elements 
> `array[start], array[start+1],...array[array.length-1]`.

Provide a second method **`public int[] modify(int start)`** which has the effect of moving the element at index **`smallestAfter(start)`** over to index **`start`** and moves the other elements over to fill the gap that is left. Here is how to do that:

In the <b>modify</b> method, first make an array <b>`temp`</b> that is the same length as the field <b>`array`</b>. Set <b>`var k = smallestAfter(start)`</b>. In a for loop for index <b>`0`</b> to index <b>`start - 1`</b> (please use <b>`j < start`</b> instead of <b>`j <= start - 1`</b>, if <b>`j`</b> is the counter in your for loop), copy each element in array to the corresponding element of <b>`temp`</b>.  Next set <b>`temp[start]`</b> equal to <b>`array[k]`</b>. After that copy <b>`array[j]`</b> to <b>`temp[j+1]`</b> for each <b>`j`</b> from <b>`j = start`</b> to <b>`j = k - 1`</b> (please use <b>`j < k`</b> instead of <b>`j <= k - 1`</b>). Lastly copy the elements from <b>`array`</b> to <b>`temp`</b> for each index from <b>`j = k+1`</b> to the end of the array (<b>`j < array.length`</b>). Return <b>`temp`</b>.
  
See the attached modify.PNG for an example, which explains what the modify method is supposed to be doing. Suppose we called modify(3) with the starting array [3,7,9,2,4,1,8].  
  
In this example, start = 3. The index 3 corresponds to the number 2. Note that the smallest value at or after index 3 is the value 1, which occurs at index 5. So, we have reassemble the array in 4 steps.
>First, keep the numbers to the left of the start index the same, which is 3,7,and 9 in the example.  
Second, put the smallest value at the start index, so in this case 1 where the 2 used to be.  
Third, move all values that were between the start index and the index where the smallest value was found leftward. In this case, 2 and 4 get shifted to the left, since 1 was placed where 2 used to be.  
Fourth, copy over all values that occured after the index of the smallest value, in this case the 8.  
  
Thus, calling modify(3) with the starting array [3,7,9,2,4,1,8] would become [3,7,9,1,2,4,8].
  
<h1>OneChange Test class</h1>  
  
Make a test class, <b>OneChangeTester.java</b> that imports <b>`java.util.Arrays`</b> and with a main method containing

```java
int[] test = {3,7,9,10,2,6,3,1,2};
OneChange one = new OneChange(test);
System.out.println(Arrays.toString(test));
System.out.println(Arrays.toString(one.modify(4)));
```
and verify you get

> [3, 7, 9, 10, 2, 6, 3, 1, 2]  
[3, 7, 9, 10, 1, 2, 6, 3, 2]

Of course this example is not very interesting or useful. Next we see that if we use modify repeatedly we will be able to sort the array into increasing order.

<h1>Weird Sorter</h1>  
  
Make a class <b>`WeirdSorter`</b> with a private field <b>`int[] array`</b>. Make a constructor to set the value of that field as we did in the class above. Next write a method <b>`public int[] sorted()`</b>, which returns the sorted version of <b>`array`</b> (it also modifies the field so that it is sorted).
  
In order to implement the sorted method, for <b>`int i`</b> from <b>`0`</b> to the <b>`length`</b> of the <b>`array - 1`</b>, do the following two instructions: make a new <b>`OneChange`</b> object and call <b>`modify(i)`</b> on that object. At the end of the method return <b>`array`</b>.

<h1>Weird Sorter Tester</h1>  
  
Write a test class, <b>WeirdSorterTester.java</b> with a main method that creates an array <b>`test`</b> as shown above in the first tester, then makes a <b>`WeirdSorter ws`</b> using <b>`test`</b> and prints <b>`test`</b> and <b>`ws.sorted()`</b> using <b>`Arrays.toString`</b> as above (import <b>`java.util.Arrays`</b>), to get
  
>[3, 7, 9, 10, 2, 6, 3, 1]  
[1, 2, 3, 3, 6, 7, 9, 10]
  
Write classes <b>`OneChange1`</b>, <b>`WeirdSorter1`</b>, that sort the array in descending order so the test would give
  
>[3, 7, 9, 10, 2, 6, 3, 1]  
[10, 9, 7, 6, 3, 3, 2, 1]
  
This needs very few, albeit subtle, changes.  
  
<b>Hint to get Started:</b> <b>`OneChange1`</b> will be similar to <b>`OneChange`</b>, but it will want to return the index in the array that holds the first occurence of the largest value after (or at) <b>`start`</b>, rather than the smallest value after (or at) <b>`start`</b>. Name the method something more appropriate than <b>smallestAfter</b>, say <b>largestAfter</b>.  

<h1>Reuse of Book Class</h1>  
  
Get your class <b>`Book`</b> from Lab02 and add the method <b>`public String toString()`</b>, which has one line:
  
>return "\n" + title + ", " + numPages + " pages";

<h1>Book Tester class</h1>  
  
In a new tester called <b>BookTester.java</b>, add a main method, and make an array of <b>`Book`</b>s. Print the array using <b> `Arrays.toString` </b>. It will automatically invoke the <b>`toString()`</b> method above.  

<h1>OneChangeBook and WeirdSorterBook</h1>  
  
Now make classes <b>`OneChangeBook`</b> and <b>`WeirdSorterBook`</b>, where the <b>`int[]`</b> arrays are replaced everywhere with <b>`Book[]`</b> arrays. Instead of comparisons using <b>`array[i]`</b> use comparisons using <b>`array[i].getTotalPages()`</b> so that the when the books are sorted, they will be in increasing page counts.

<h1>Some final testing</h1>  
  
Add the following code to the <b>BookTester.java</b>'s main method:

``` java
Book[] test1 = {
	new Book("Book A", 3), 
	new Book("Book B", 7),
	new Book("Book C", 9),
	new Book("Book D", 10),
	new Book("Book E", 2),
	new Book("Book F", 6),
	new Book("Book G", 3),
	new Book("Book H", 1)
};
WeirdSorterBook ws2 = new WeirdSorterBook(test1);
System.out.println(Arrays.toString(ws2.sorted()));
``` 

Running it should give

>[Book H, 1 pages,  
Book E, 2 pages,  
Book A, 3 pages,  
Book G, 3 pages,  
Book F, 6 pages,  
Book B, 7 pages,  
Book C, 9 pages,  
Book D, 10 pages]  
  
In <b>BookTester.java</b>, add the method <b>`public static double avgPagesInLibrary(Book[] books)`</b> which gives the average number of pages over all the books. This is a double, for example if you have 4 books with numbers of pages 100, 176, 150, and 209, the average must be 158.75. Beware of integer division here.

Test the method <b>`avgPagesInLibrary`</b> in <b>BookTester</b>'s main method.

 
