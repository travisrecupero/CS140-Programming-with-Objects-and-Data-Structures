# assignment08 DUE ON WEDNESDAY 10/24/18 at 11:59pm
assignment08
This is going to be an implmentation of a pretty well know example of the Decorator Design Pattern: Building a Burger.

A lot of GUI files are provided, some in Chinese. I am very interested to correct the errors in the Chinese--there must be many!
The Chinese (and the other langauges) have been developed using http://translate.google.com/?tl=zh#auto/zh-CN/ and then the Unicide has been developed using http://weber.ucsd.edu/~dkjordan/resources/unicodemaker.html

Make a package `assignment08`. Make a class `public abstract class BurgerAbstraction`, with private fields `BurgerNaming name`
and	`BurgerAbstraction next`. Provide a constructor with 2 parameters to set the values of the fields. Provide _getter_ methods for both fields and a _setter_ method for the `next` field. We will give the other methods in a moment. 

Make a subclass `public class BurgerTopping extends BurgerAbstraction`. It does not have any fields of its own. Make a subclass `public class ConcreteBurger extends BurgerAbstraction`, whihc also does not have any fields of its own. These two classes will override the methods in the parent in different ways.

A burger will be a ConcreteBurger and a set of BurgerToppings. The are all linked together using their `next` fields of the toppigs. The concrete burger is always at the end of the linked list, with the toppings in front of it. I will post a graphic on Blackboard some time over the weekend.

The methods of `BurgerAbstraction`:

`public BurgerAbstraction removeTopping(BurgerNaming name)` will return `this`.

`public BurgerAbstraction sort()` will return `this`.

```java
public double getPrice() {
		return BurgerNaming.costInCents.get(name)==null?0:BurgerNaming.costInCents.get(name);
}
```
Look up the ternary operator online "...?...:..." to see how it works (here is one https://alvinalexander.com/java/edu/pj/pj010018)

`public int getCalories()` returns `BurgerNaming.calories.get(name)`

Two abstract methods`public abstract int getTotalCalories()` and `public abstract double getTotalCost()`

`protected int toppingsCount()` that returns 0.

`protected boolean hasTopping(BurgerNaming name)` that returns false

`public String toString()` that returns `name` and, if `next` is not null concatenates "->" + next.toString().
Note that the GUI code provided depends on the syntax being exactly this way. If you print a burger that has some toppings, you might see ONIONS->BACON->MAYONNAISE->BASE_BURGER. This is using the fact that the toString built into an `enum` will just print the value as-is.

Next we modify the basic code of some of these methods to get richer behavior.

First in ConcreteBurger, the constructor with two parameters passes them on to the parent using `super`.

Override `public int getTotalCalories()` to return `getCalories()`.

Override `public double getTotalCost()` to return `getPrice()`.

That was easy!

In `BurgerTopping`, the constructor with two parameters passes them on to the parent using `super`. 

Override `public int getTotalCalories()` to return `getCalories()` plus `getTotalCalories()` applied to `getNext()`. This will add the total calories of all the toppings and the base burger.

Override `public double getTotalCost()` in a similar way.

Override `protected int toppingsCount()` by adding 1 plus `toppingsCount()` applied to `getNext()`.

Override `public BurgerAbstraction removeTopping(BurgerNaming aName)` as follows: first understand that we do not need ".equals" for `enums`. There is only one object for each of the `enum` values, so that can be compared using "==". If aName equals getName(), return `getNext()`. Continue the code by passing `getNext().removeTopping(aName)` as the argument to `setNext()` and then return `this`. 
What this code does is that if the first topping is the one to be remove, simply toss it and let the burger point at the next element in the list. Otherwise remove the topping from later in the list, make the first topping link to the resulting list and keep the burger pointing at the first topping.

Override `protected boolean hasTopping(BurgerNaming aName)` by returning true if `aName` equals `getName()` followed by returning the result of calling `hasTopping(aName)` on `getNext()`.

The Override of `public BurgerAbstraction sort()` is exciting because we asking a list to sort itself! It is simple but not very efficient. Fortunately we only have 9 toppings.

<h2>Update: Fixed bug in sort() method, read and implement carefully. </h2>

Before implementing sort(), go to line 137 in the provided ScreenManager.java file, and change the first line of the body of the lambda expression from:

> burger.sort();

To: 

> burger = burger.sort();

If toppingsCount() > 1 we will execute some code. After the if, simply return `this`, which takes care of the case there are no toppings. Inside the if, make the variable `b` be `getNext()`. Call `b.sort()` to recursively sort the shorter list <b> and set the returned value equal to `b`. This will ensure we update `b` to be the head of the smaller linked list after its has been recursively sorted. Furthermore, we need to relink the first element (`this`) back up to the potentially new head of the smaller linked list (`b`). So, after the we call`b.sort()`, we need to call `this.setNext(b)`</b>. 

Next use the fact that `enums` are Comparable using the order in which they are defined (we defined them in alphabetical order, by the way). So if `getName().compareTo(((BurgerTopping)b).getName())` is positive we have to move `this` into later in the list: set the next element of <b>`this`</b> to `b.getNext()` using `setNext()`. Set that next element of `b` to point at this using `b.setNext(this)`. Those 2 steps flipped the order of the first two elements. <b> However, although we swapped `this` and `b`, we may need to resort the smaller linked list again, since this could have to be swapped down the line. To remedy that issue, call `b.setNext(b.getNext().sort());`, which will sort the smaller linked list recursively, and set the returned head of it to be what `b` 's next is. Notice that b.getNext() now is this, so equivalently we could have done `b.setNext(this.sort());` either should work for you. Finally, return `b` and we are done with this inner if block. CAUTION: we do not return b in the outer if block, we only return b if we have actually swapped this and b.</b>

NOTE THAT THE `*.JPG` FILES MUST GO AT THE TOP LEVEL OF THE ECLIPSE PROJECT (OUTSIDE OF src). The `*.java` files go inside assignment08.

Download all the code provided an run the class `Client`. It will take over your screen!!! ALT-F4 or Apple-Command + W (may also be Apple-Command + Q) should close it.





