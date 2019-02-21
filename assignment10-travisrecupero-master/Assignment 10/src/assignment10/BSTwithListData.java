package assignment10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * A class to implement the Binary Search Tree data structure.
 * The structure is generic in the type of Objects it contains.
 * @param <T> the type of the contained elements this structure is to hold
 */
public class BSTwithListData<T> {
    private Comparator<T> comparator;
    private List<T> data;
    private BSTwithListData<T> left;
    private BSTwithListData<T> right;
    private int insertCount;

    /**
     * Constructs an empty BST with a Comparator
     * @param comp the Comparator to use to impose an ordering on instances of T
     */
    public BSTwithListData(Comparator<T> comp) {
        this.comparator = comp;
    }

    /**
     * Constructs a BST with data and a Comparator
     * @param data the data this BST should hold
     * @param comp the Comparator to use to impose an ordering on instances of T
     */
    public BSTwithListData(T data, Comparator<T> comp) {
    	this.data = new ArrayList<>();
    	this.data.add(data);
        this.comparator = comp;
    }
    
    public BSTwithListData(List<T> data, Comparator<T> comp) {
    	this.data = data;
    	this.comparator = comp;
    	
    }

    /**
     * Inserts an element into this BST
     * if element is null, do not insert element
     * it is worth noting that the only time data could be null is if we created a BST with no initial data
     * in that case, if data is null, we just update data to equal element, and the insertion is done
     * if the element to be inserted compares equal to another value that is already in the tree, do not insert element
     * we do this for the sake of simplicity, forcing elements in the tree to be unique
     * @param element the element to insert into this BST
     */
    public void insert(T element) {
    	//System.out.println("inserting: " + element);
    	
    	//returns is element is already in the tree
    	if(find(element) != null) {
        	return;
    	}
    	
    	//returns if element is null
    	if(element == null) {
        	return;
        }
    	
    	//base cases didnt execute therefore there will be an insert
    	insertCount++;
    	
    	//data == null so element will be the first item in tree
    	if(data == null) {
    		data = new ArrayList<>();
    		data.add(element);
    	}
    	
        //if you try adding a number == to root
    	else if(comparator.compare(element, data.get(0)) == 0) {
        	if (!data.contains(element)){
        		data.add(element);
        	 }
        }
        
        //try adding a number that is less than root
        else if(comparator.compare(data.get(0), element) > 0) {
        	if(left == null) {
            	left = new BSTwithListData<T>(element, comparator);
        	} else {
        		left.insert(element);
        	}	
            
        } 
        else {
        	if(right == null) {
        		right = new BSTwithListData<T>(element, comparator);
        	} else {
        		right.insert(element);
        	}
        }
        
        if(insertCount == 10) {
        	insertCount = 0;
        	List<List<T>> nodes = this.getGroups();
        	data = nodes.get(nodes.size()/2);
        	List<List<T>> leftNodes = new ArrayList<>();
        	List<List<T>> rightNodes = new ArrayList<>();
        	
        	
        	for(int i = 0; i < nodes.size()/2; i++) {
        		leftNodes.add(nodes.get(i));
        	}
        	for(int i = nodes.size()/2 + 1; i < nodes.size(); i++) {
        		rightNodes.add(nodes.get(i));
        	}
        	
        	left = makeBalancedTree(leftNodes);
        	right = makeBalancedTree(rightNodes);
        }
        
        
        
    }

    public BSTwithListData<T> makeBalancedTree(List<List<T>> nodes){
    	if(nodes == null || nodes.size() == 0) {
    		return null;
    	}
    	
    	BSTwithListData<T> retVal = new BSTwithListData<T>(nodes.get(nodes.size()/2), comparator);
    	List<List<T>> leftNodes = new ArrayList<>();
    	List<List<T>> rightNodes = new ArrayList<>();
    	
    	
    	for(int i = 0; i < nodes.size()/2; i++) {
    		leftNodes.add(nodes.get(i));
    	}
    	for(int i = nodes.size()/2 + 1; i < nodes.size(); i++) {
    		rightNodes.add(nodes.get(i));
    	}
    	
//    	System.out.println("left nodes: " + leftNodes);
//    	System.out.println("new root: " + data);
//    	System.out.println("right nodes: " + rightNodes);

    	
    	retVal.left = makeBalancedTree(leftNodes);
    	retVal.right = makeBalancedTree(rightNodes);
    	
    	return retVal;
    }
    
    /**
     * Searchs for a given element in this BST
     * if element is null, return null
     * @param element the element to search this BST for
     * @return the element in this BST matching the given element, if found,
     *         otherwise null if the given element is not in this BST
     */
    public T find(T element) {
    	if(element == null || data == null) {
    		return null;
    	}
    	
    	if(comparator.compare(element, data.get(0)) == 0) {
    		if (data.contains(element)){
        		return element;
        	 }
    		else if (!data.contains(element)){
    			return null;
    		}
    	}
    	
    	//element < root
    	if(comparator.compare(data.get(0), element) > 0) {
    		if(left == null) {
            	return null;
        	} else {
        		return left.find(element);
        	}
    	} else {
    		if(right == null) {
            	return null;
        	} else {
        		return right.find(element);
        	}
    	}

    	
    }

    /**
     * Gathers all the elements of this BST in order
     * @return a List holding the elements in this BST in order
     */
    public List<T> getElements() {
        List<T> list = new ArrayList<>();       
        if(left != null) {
        	list.addAll(left.getElements());
        }
        if(data != null) {
        	list.addAll(data);
        }
        if(right != null) {
        	list.addAll(right.getElements());
        }
        return list;
    }

    /**
     * Pretty prints the contents of this BST in a horizontal tree-like fashion
     */
    public void prettyPrint() {
        prettyPrint(0);
    }

    private void prettyPrint(int indentLevel) {
        // TODO
        // print `indentLevel` amount of spaces before printing data on its own line
	//HINT: you will want to do an in order traversal here. (see the Traversal section in the explanation of Binary Trees above)
        // you may use a for loop to print `indentLevel` amount of spaces
        // each time you recurse, you add to indentLevel
    	String s = "";
    	if(left != null) {
        	left.prettyPrint(indentLevel + 1);
        }
        if(data != null) {
        	for(int i = 0; i < indentLevel; i++) {
        		s = s + " ";
        	}
        	System.out.println(s + data);
        }
        if(right != null) {
        	right.prettyPrint(indentLevel + 1 );
        }
    }
    
    public List<List<T>> getGroups(){
        List<List<T>> list = new ArrayList<>();       
        if(left != null) {
        	list.addAll(left.getGroups());
        }
        if(data != null) {
        	list.add(data);
        }
        if(right != null) {
        	list.addAll(right.getGroups());
        }
        return list;	
    	
    	
    }

    /**
     * A main method supplied for any debugging needs
     */
    public static void main(String[] args) {
/*        System.out.println("\nString Comparator: \n");
        Comparator<String> sComp = (i, j) -> i.length() + j.length(); // lambda expression
        BSTwithListData<String> sTree = new BSTwithListData<>(sComp);
        sTree.insert("a");
        sTree.insert("hi");
        sTree.insert("test");
        sTree.insert("penta");
        sTree.insert("stella");
        sTree.insert("oranges");
        sTree.insert("oxymoron");
        sTree.insert("blackjack");
        sTree.prettyPrint();*/
    
    	Comparator<String> sComp = (i, j) -> i.length() - j.length(); // lambda expression
        BSTwithListData<String> sTree1 = new BSTwithListData<>(sComp);
        sTree1.insert("a");
        sTree1.insert("hi");
        sTree1.insert("cat");
        sTree1.insert("test");
        sTree1.insert("penta");
        sTree1.insert("stella");
        sTree1.insert("oranges");
        sTree1.insert("oxymoron");
        sTree1.insert("blackjack");
        sTree1.insert("a1");
        sTree1.insert("h1");
        sTree1.insert("ca1");
        sTree1.insert("tes1");
        sTree1.insert("pent1");
        sTree1.insert("stell1");
        sTree1.insert("orange1");
        sTree1.insert("oxymoro1");
        sTree1.insert("blackjac1");
        sTree1.insert("a2");
        sTree1.insert("h2");
        sTree1.insert("ca2");
        sTree1.insert("tes2");
        sTree1.insert("pent2");
        sTree1.insert("stell2");
        sTree1.insert("orange2");
        sTree1.insert("oxymoro2");
        sTree1.insert("blackjac2");
        sTree1.prettyPrint();
    }
    
    
    
    
}
