import java.util.Arrays;

public class Task13 {

	public static void main(String[] args) {
		int[] arr2 = {1,2,4,5,6,2,2};
		int[] arr1 = {12,5,32,34,43,6,3,2,76};
		int[] mix = mixArrays(arr1, arr2);
		System.out.println(Arrays.toString(mix));
		System.out.println(mix.length);
	}
	
	static int[] mixArrays(int[] a1, int[] a2){
		int max = a1.length > a2.length? a1.length : a2.length;
		int[] mixed = new int[max];
		if(a1.length > a2.length){
			for (int i = 0; i < a2.length/2+1; i++) {
				mixed[i] = a2[i];
			}
			for (int i = a2.length/2+1; i < a1.length; i++) {
				mixed[i] = a1[i];
			}
		}else{
			for (int i = 0; i < a1.length/2+1; i++) {
				mixed[i] = a1[i];
			}
			for (int i = a1.length/2+1; i < a2.length; i++) {
				mixed[i] = a2[i];
			}
		}
		return mixed;
		
				
	}
}
