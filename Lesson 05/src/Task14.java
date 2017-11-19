import java.util.Arrays;

public class Task14 {

	public static void main(String[] args) {
		double[] arr1 = {7.1, 8.5, 0.2, 3.7, 0.99, 1.4, -3.5, -110, 212, 341, 1.2};
		double[] arr2 = new double[arr1.length];
		
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr1.length; j++) {
				if(arr1[j] <= 2.99 && arr1[j] >= -2.99){
					arr2[i] = arr1[j];
					i++;
				}
			}
			break;
		}
		
		System.out.println(Arrays.toString(arr2));
	}
}
