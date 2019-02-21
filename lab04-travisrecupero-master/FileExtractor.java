package lab04;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.util.Arrays;
import java.io.FileNotFoundException;
import java.util.Iterator;

public class FileExtractor {

	private int[] array;
	private List<Integer> list;

	public FileExtractor(String fileName){
	list = new ArrayList<Integer>();
    	// try-with-resources block (sc is the resource we are trying to use)
	try(Scanner sc = new Scanner(new File(fileName))){
		while(sc.hasNext()){			
			list.add(sc.nextInt());
		}
		array = new int[list.size()];
		for (int i = 0; i < list.size(); i++){
			array[i] = list.get(i);	
		}
	}
	catch(FileNotFoundException e){
		array = new int[0];

		System.out.println("File '" + fileName + "' not found, initializing both 'list' and 'array' to be empty\n");

	}
	catch(Exception e){	
    		System.out.println("Error occurred while extracting data:\n");
   		e.printStackTrace();
	}
	}

	public int[] getArray(){
		return array;
	}

	public List<Integer> getList(){
		return list;
	}
	
	public void removeOddElements(){
		int counter = 0;
		int[] temp;
		for(int i : array){
			if (i % 2 == 0){			
				counter += 1;
			}
		}
		temp = new int[counter];
		int index = 0;
		for(int j : array){
			if (j % 2 == 0){			
				temp[index] = j;
				index++;
			}
		}
		array = temp;
	}

	public void removeEvenElements(){
		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext()){
			Integer i = iter.next();
			if(i % 2 == 0) iter.remove();
		}

		/*for(Integer i : list){
    		//note i is not an index here, it is an Integer object found in list
    		if(i % 2 == 0) list.remove(i);
		}*/
	
	}

	public String toString(){
		return "array: " + Arrays.toString(array) + "\nlist: " + list.toString();	
	}

	








}
