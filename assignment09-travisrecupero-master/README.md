# assignment09 DUE FRIDAY NOVEMBER 2, 11:59pm

Problem 1 FROM THE TEXTBOOK) Implement a class `SubstrgGen` that generates all substrings of a String. In the class write two static methods `public static Set<String> subStrs(String starter)`--which returns a `TreeSet<String>` and `public static List<String> subStr1(String starter)`--which returns an `ArrayList<String>`. Note List, Set, ArrayList and TreeSet are all in java.util.

Note that a _Set_ of Strings will only allow you to add a certain String to it once, which actually makes this exercise easier, as you won't have to account for trying to insert the same substring multiple times here. Also, a tree set is going to order the Strings in natural order. This means that for our first method above, calling subStrs("rum") should produce `[, m, r, ru, rum, u, um]` as output, the empty string being first and then adding the words in lexicographical order. 

On the other hand, if we call `subStr1` on "rum", it should print as follows: `[r, ru, rum, u, um, m, ]`, which are the following strings as in the textbook "r", "ru", "rum", "u", "um", "u", "m", ""

For subStr1, we want this EXACT ORDER. Again, for subStrs the order will be different as mentioned above.

HINTS
* First enumerate all substrings that start with the first character. There are n of these if the string has length n. Then enumerate the substings of the string that you obtain by removing the first character.
* For `subStr1`, it seems a helper method will be useful `public static List<String> subStrHelper(String starter, List<String> temp)`, where you add `starter` to `temp` if `starter.length()` is 0 and return `temp`. After that add all the substrings that start with the first character to `temp`. Lastly, make a recursive call with arguments `starter.substring(1)` and `temp`.

Problem 2) Complete all the methods in NaiveQuickSort and then run the main method in GraphSortResults.java to see how even a primitive version of quick sort is faster than insertion sort

Problem 3) Complete all the methods in StringTree and check that the given main method gives the expected results.
