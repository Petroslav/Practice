import java.util.Arrays;

public class Task18 {

	public static void main(String[] args) {
		int[] arr1 = {18,19,32,1,3, 4, 5, 6, 7, 8};
		int[] arr2 = {1, 2, 3,4,5,16,17,18,27,11};
		int[] arr3 = new int [arr1.length];
		
		for (int i = 0; i < arr3.length; i++) {
			if(arr1[i] > arr2[i]){
				arr3[i] = arr1[i];
			}else{
				arr3[i] = arr2[i];
			}
		}
		System.out.println(Arrays.toString(arr3));
	}
}
