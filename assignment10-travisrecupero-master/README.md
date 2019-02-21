# assignment10 due 11:59pm Friday November 9
The code will go in `assignment10`

_Question 1:_ Go to Question 1 of assignment09. IF you solved `subsTrs` using recursive call somewhere then rewrite it here using only loops. IF you solved `subsTrs` using only loops, solve it here using code that contains a recursive call somewhere--you will have to include loops as well--by now we have seen examples of code where the recursive call occurs inside a loop.

Go to the `main` method of the class `BinarySeachTree.java` from `lab09` and paste in this test:

```
BinarySearchTree<String> sTree1 = new BinarySearchTree<>(Comparator.comparingInt(String::length));
sTree1.insert("John");
sTree1.insert("Jane");
sTree1.insert("July");
sTree1.insert("June");
sTree1.insert("Jeff");
sTree1.insert("Jedd");
sTree1.insert("Johl");
sTree1.insert("Jude");
sTree1.insert("Julie");
sTree1.insert("Molly");
sTree1.prettyPrint();
System.out.println(sTree1.height());
System.out.println(sTree1.getElements());
System.out.println(sTree1.nonLeaves());
```

SURPRISE! only 2 Strings got stored! You should get the same result using the comparator that you wrote with an explicit lambda expression. This is because the `insert` method ignores Strings where the `comparator.compare` method returns 0.

Let's make a new BST that stores all the elements you put in.

_Question 2:_ Copy over `BinarySearchTree.java` from `lab09`. Also copy over `BinaryTreeTester.java`. In `assignment10`, in the Package Explorer of Eclipse, right click on `BinarySearchTree.java` and select _Refactor_ and then click on _Rename_. Change the name `BinarySearchTree` to `BSTwithListData`. 

Change `private T data` to `private List<T> data`

In the constructor `public BSTwithListData(T data, Comparator<T> comp)` change `this.data = data` to instantiate this.data as a new ArrayList and add the parameter `data` to that list.

<h2>Update 1: Fixed small typo. Add element to data if data does NOT contain element </h2>

In the method `insert` if `data` is null, instantiate `data` as a new ArrayList and add `element` to the list; next the `comparator.compare` calls must compare `element` and `data.get(0)`: if `(comparator.compare(element, data.get(0)) == 0)`, then you add `element` to `data` if `!data.contains(element)`--fortunately ArrayList has that useful method implemented already!

In the `find` method, if `(comparator.compare(element, data.get(0)) == 0)`, then you use the `contains` method of the ArrayList `data` to decide whether to return `element` or `null`.

In the `getElements` method you `addAll` the ArrayList `data` where the original code just added `data`.

In the prettyPrint helper method you can still use `System.out.println(data)`. It will print a list instead of a single element.

<h2>Update 2: You need to implement height and nonLeaves if you have not already </h2>

In `nonLeaves` you use `addAll` instead of `add`, when adding `data`. If you did not implement nonLeaves in lab09, you will need to implement it here. Same goes for the height method from the Bonus of lab09.

Run the main method and observe that the tree stores all the Strings that have the same length.

Note that the `BinarySearchTester` will not distinguish the changes because it only tests with numbers and we cannot have two numbers that compare to 0. 

_Question 3:_ Change the beginning of `BinaryTreeTester` from

```
private final List<Integer> data = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 0, -1, 2, 3)); 
private final Comparator<Integer> intComp = (i, j) -> i - j;
private BSTwithListData<Integer> ints;
```
TO

```
    private final List<String> data = new ArrayList<>(Arrays.asList("a", "ab", "d", "cdef", "abscde", "we", "x")); 
    private final Comparator<String> strComp = Comparator.comparingInt(String::length);
    private BSTwithListData<String> strs;
```

and change the two tests so that they work (e.g. change `for(int i ...` to `for(String i ...` and all the `ints` to `strs`)

_Question 4:_ Go back to `BSTwithListData` and add a private int field `insertCount`. We are going to try to keep the tree close to balanced using the idea of the Day–Stout–Warren (DSW) algorithm (https://en.wikipedia.org/wiki/Day%E2%80%93Stout%E2%80%93Warren_algorithm). However, we will not try to reuse the refences inside the tree to form the list and then rebuild the tree. We will use extra storage to do the work.

First add a method `public List<List<T>> getGroups()` than makes a list of the ArrayLists at each node. It is the same recursion as the `getElements` in `lab09`, with `getElements` replaced by `getGroups`. In particular, in the middle of the recursion, you go back to having `list.add(data)` because you want to add the whole `data` list as one element of the list of groups.

<h2>Update 3: Update to modification of Insert method</h2>

Modify the `insert` method so that if an element is actually inserted then 1 gets added to `insertCount`. Be careful, if you try to insert an `element` that is already in the tree, then it is ignored, so `insertCount` must not increase. So at the beginning of the method simply _return_ if `find(element)` is not `null`. After that you know you will insert `element` so add 1 to insertCount and proceed with the insert. At the end of the `insert` method, you rebuild the tree to be balanced if `insertCount` == 10 and then reset `insertCount` to 0. Hence we will rebalance the tree after every 10 inserts, i.e. we spread (the fancy name is _amortize_) the cost of running the rebalance over multiple inserts. The rebalancing is multiple steps and a call to a recursive method given below.

First add a new constructor to `public BSTwithListData(List<T> data, Comparator<T> comp)` that sets `this.data` to the parameter `data` and `this.comparator` to `comp`.

Back to the end of the `insert` method. If `insertCount==10`, set the count to 0. Make the `List<List<T>> nodes` by calling `this.getGroups()`. Change `data` to `nodes.get(nodes.size()/2)`. Make `List<List<T>> leftNodes` as an ArrayList with the elements `nodes.get(i)` for `i = 0` up to but not including `nodes.size()/2`. Make `List<List<T>> rightNodes` as an ArrayList with the elements `nodes.get(i)` for `i = nodes.size()/2 + 1` up to but not including `nodes.size`. Finally change `this.left` to `makeBalancedTree(leftNodes)`, which uses the method described below, and change `this.right` to `makeBalancedTree(rightNodes)`

Write the method `public BSTwithListData<T> makeBalancedTree(List<List<T>> nodes)`, so that it return `null` if `nodes` is _null_ or _empty_. Otherwise make `BSTwithListData<T> retVal` using the new constructor above with the arguments `nodes.get(nodes.size()/2)` and `comparator`. Make the lists `leftNodes` and `rightNodes` exactly as we did at the end of `insert`. Set retVal.left to `makeBalancedTree(leftNodes)` and `retVal.right` to `makeBalancedTree(rightNodes)`. Lastly return retVal;

If you add the code below to the main method, you will see the rebalancing taking effect. Note that Java's TreeSet uses a "red-black" tree which is not exactly balanced but close enough for efficiency and _every_ insert and delete operation keeps the tree in its "red-black" form. Note also that we have not approached trying to the write "delete" in this assingment.

```
        BSTwithListData<String> sTree = new BSTwithListData<>(strComp);
        sTree.insert("a");
        sTree.insert("hi");
        sTree.insert("cat");
        sTree.insert("test");
        sTree.insert("penta");
        sTree.insert("stella");
        sTree.insert("oranges");
        sTree.insert("oxymoron");
        sTree.insert("blackjack");
        sTree.insert("a1");
        sTree.insert("h1");
        sTree.insert("ca1");
        sTree.insert("tes1");
        sTree.insert("pent1");
        sTree.insert("stell1");
        sTree.insert("orange1");
        sTree.insert("oxymoro1");
        sTree.insert("blackjac1");
        sTree.insert("a2");
        sTree.insert("h2");
        sTree.insert("ca2");
        sTree.insert("tes2");
        sTree.insert("pent2");
        sTree.insert("stell2");
        sTree.insert("orange2");
        sTree.insert("oxymoro2");
        sTree.insert("blackjac2");
        sTree.prettyPrint();
```




