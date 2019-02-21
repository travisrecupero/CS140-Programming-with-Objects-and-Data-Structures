# assignment03 DUE FRIDAY Sept 14, 11:59pm

The code goes in package `assignment03`. Copy the `Student` class you have from Lab03 but make the following changes: 
1. The fields are private Strings: bnumber, lastname, firstname.
2. Write a method private String normalize(String input), which converts any String so that it is all lower-case except the first letter which is upper-case, for example normalize("jAckSoN") will be "Jackson". I used `input = input.toLowerCase()`, `input.charAt(0)`, and `input.substring(1)` from the class `String`, `Character.toUpperCase(input.charAt(0))` from the `Character` wrapper class. Then put the pieces together with concatenaton "+".
3. Make a constructor that sets the values of the 3 fields but each one must be normalized: `this.lastname = normalize(lastname)`, etc., including the `B-number`.
4. `getBnumber` replaces `getId`. The `getName` method must show the completed name in the `lastname, firstname` format, for example "Lander, Leslie". The toString method just returns getName().
5. Add a method `public static int compareBnum(Student s1, Student s2)`. We will use the `compareTo` method of `String`. The return value is `s1.bnumber.compareTo(s2.bnumber)`. We assume B-numbers are unique.
6. Add a method `public static int compareName(Student s1, Student s2)`. The return value starts as `s1.lastname.compareTo(s2.lastname)`. If that value is not 0, then that is the value returned. However, if that is 0, the return value changes to `s1.firstname.compareTo(s2.firstname)` and if that also turns out to be 0, the return value is changed to `s1.bnumber.compareTo(s2.bnumber)`

Next copy `ClassRoom` from Lab03. 
1. Change dropStudent to take a String parameter `bnum` (the B-number). You look for the index k in the roster where `roster.get(k).getId().equals(bnum)`. `k` is -1 is no element is found. Then if `k >= 0`, you call `roster.remove(k)`
2. Modify you sortById, where you change the comparison in the central if statment to 
`if(Student.compareBnum(roster.get(j-1), roster.get(j)) > 0)`
3. Copy this code to sortByName, where you change the comparison in the central if statment to 
`if(Student.compareName(roster.get(j-1), roster.get(j)) > 0)`

Rewrite the ClassRoomTester so that it creates rosters with these more complex Students, removes one correctly and then sorts by Id and sorts by name and prints out the results.

Clean up of assignment 1. Make sure you have a completed copy of Assignment 1. Now that we have Lists, we can make the Person's history more flexible.
1. Introduce the following very simple Java `interface`
```java
package assignment03;
public interface Occupation {
	void print();
}
```
2. Change the declaration of history to `private List<Occupation> history = new LinkedList<>();` (import `List` and `LinkedList` from `java.util`)
3. Comment out the printHistory method (use `/* ... */` around the method because you will need the code that prints things out.
4. Put the following new printHistory in the class Person
```java
public void printHistory() {
	System.out.println("History of " + name);
	for(Occupation oc : history) {
		oc.print();			
	}		
}
```
Look how simple that is!  
5. Remove the method `getHistory()` and insert the method `public void addOccupation(Occupation occ) `, which adds occ to history.  
6. Change the HighSchoolStudent to being `public class HighSchoolStudent implements Occupation {` and in the constructor change `person.getHistory()[0] = this;` to `person.addOccupation(this);`  
7. Add the method 
```java
public void print() {
	System.out.println("\tHigh school: " + getHighschool().getName());		
}
```
This println code is essentially the code that was in the `printHistory` method in `Person`, except `hss.getHighschool().getName()` changes to `getHighschool().getName()`  
8 Follow the same 3 steps for `UniversiytStudent` and `Employee`  
9 Run your original tester, things should work as before.  
10. Now in HighSchoolStudent, add a method that changes High School:  
```java
public HighSchoolStudent changeHighSchool(HighSchool sch) {
	return new HighSchoolStudent(sch, this.person);
}
```
11. Similarly in UniversityStudnet add a method `transferUniversity` to transfer to a new univeristy and in `Employee` add a method `changeJob` to move from one job to another.  
12. Add a test case to your tester class where a Person attends 2 HighSchools, 2 Universities and has 2 jobs using the new methods we have added.
