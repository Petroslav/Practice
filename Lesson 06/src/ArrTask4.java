import java.util.Arrays;

public class ArrTask4 {

	public static void main(String[] args) {
		int[] arr = {0,1,1,0,0,1,1,0,0,1,0,1,0,1,0};
		int one = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == 1){
				one++;
				arr[i] = 0;
			}
		}
		for (int i = arr.length-one; i < arr.length; i++) {
			arr[i] = 1;
		}
		System.out.println(Arrays.toString(arr));
	}
}
