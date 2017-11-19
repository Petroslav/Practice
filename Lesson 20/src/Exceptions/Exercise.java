package Exceptions;

public class Exercise {

	public static void main(String[] args) {
		int[] array = null;
		printArrayInfo(array);
	}
	
	public static void printArrayInfo(int[] array){
		try{
			System.out.println("Array length: " + array.length);
			System.out.println("Some text.");
			System.out.println("Third element of the array: " + array[2]);			
		}catch(NullPointerException e){
			System.out.println("The array is null!");
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("The array must have at least 3 elements");
		}
	}
}
