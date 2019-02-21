package lab03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class VectorMath{

	//returns the magnitude of vector
	public static Optional<Double> magnitude(List<Double> vect){
		//square each number then find square root of total
		if (vect == null){
			return Optional.empty();
		}

		double sum = 0;	
		
		//copy vector so it doesn't change original
		List<Double> copyVect = new ArrayList<>(vect.size());
		for (Double item : vect){
			copyVect.add(new Double(item));
		}
		
		//operation
		for (int i = 0; i < copyVect.size(); i++)
		{ 
			copyVect.set(i, Math.pow(copyVect.get(i), 2)); 	
		}	
		for (int i = 0; i < copyVect.size(); i++)
		{
			sum = sum + copyVect.get(i); 	
		}
		sum = Math.sqrt(sum);
		return Optional.of(sum);

	}

	//multiplies vect by some scalar value
	//actually modifies the vector, does not return a separate one
	public static void scalarProduct(List<Double> vect, double scale){
		double sProduct = 0;
		
		if(vect == null){
			return;
		}
		if(vect.isEmpty()){
			return;
		}
		
		for (int i = 0; i < vect.size(); i++){
			sProduct = vect.get(i) * scale;
			vect.set(i, sProduct);
		}
	}

	//returns the dotProduct between two vectors
	public static Optional<Double> dotProduct(List<Double> vect1, List<Double> vect2){
		double dotProduct1 = 0;
		
		if(vect1 == null || vect2 == null){
			return Optional.empty();
		}
		
		if((vect1.isEmpty() == true) || (vect2.isEmpty() == true)){
			return Optional.of(0.0);
		}
		
		for (int i = 0; i < vect1.size() && i < vect2.size(); i++){
				dotProduct1 = dotProduct1 + (vect1.get(i) * vect2.get(i));
		}
			
		return Optional.of(dotProduct1);
	}

	//returns whether two vectors are orthogonal
	public static boolean isOrthogonal(List<Double> vect1, List<Double> vect2){
		Optional<Double> dotProduct1 = dotProduct(vect1, vect2);
		
		if (dotProduct(vect1, vect2) == Optional.of(0.0)){
			return true;
		}
		
		if(dotProduct1.isPresent()){
			return true;
		} 
		else {
			return false;
		}
		
	}

	//performs vector addition, returning a new vector
	//add each corresponding position
	public static Optional<List<Double>> vectorAddition(List<Double> vect1, List<Double> vect2){
		double size = 0.0;
		double sum = 0.0;
		List<Double> addedVect = new ArrayList<>();
		
		if ((vect1 == null) || (vect2 == null))
		{
			return Optional.empty();
		}
		
		
		//copy vectors so original doesn't change
		List<Double> copyVect1 = new ArrayList<>(vect1.size());
		for (Double item : vect1){
			copyVect1.add(new Double(item));
		}
		List<Double> copyVect2 = new ArrayList<>(vect2.size());
		for (Double item : vect2){
			copyVect2.add(new Double(item));
		}
		
		
		//append 0's to smaller vector
		if (copyVect1.size() > copyVect2.size()){
			for(int i = copyVect2.size(); i < copyVect1.size(); i++){
				copyVect2.add(i, 0.0);
			}
		}
		if (copyVect1.size() < copyVect2.size()){
			for(int i = copyVect1.size(); i < copyVect2.size(); i++){
				copyVect1.add(i, 0.0);
			}
		}
		
		
		//add vectors
		for(int i = 0; i < copyVect1.size() && i < copyVect2.size(); i++){
				sum = copyVect1.get(i) + copyVect2.get(i);
				addedVect.add(i, sum);
		}
		return Optional.of(addedVect);
		
		//		double size = 0.0;
//		if ((vect1 == null) || (vect2 == null))
//		{
//			return Optional.empty();
//		}
//		
//		if (vect1.size() > vect2.size()){
//			size = vect1.size();
//		} else if (vect1.size() < vect2.size()){
//			size = vect2.size();
//		} else {
//			size = vect1.size();
//		}
//		
//		List<Double> vectSum = new ArrayList<>();
//		for (int i = 0; i < size; i++){
//			vectSum.add(0.0);
//		}
//		
//		List<Double> copyVect1 = new ArrayList<>(vect1.size());
//		for (Double item : vect1){
//			copyVect1.add(new Double(item));
//		}
//		List<Double> copyVect2 = new ArrayList<>(vect2.size());
//		for (Double item : vect2){
//			copyVect2.add(new Double(item));
//		}
//		
//		for(int i = 0; i < copyVect1.size() && i < copyVect2.size(); i++){
//				double sum = copyVect1.get(i) + copyVect2.get(i);
//				vectSum.set(i, sum);
//		}
//		
//		return Optional.of(vectSum);
	}
}
