public class Task16 {

	public static void main(String[] args) {
		double[] arr = {-1.12, -2.43, 3.1, 4.2, 0, 6.4, - 7.5, 8.6, 9.1, -4};
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] >= 0){
				System.out.print(arr[i]+"; ");
			}
		}
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] < -0.231){
				arr[i] = (i+1)*(i+1) + 41.25;
			}else{
				arr[i] = (i+1)*arr[i];
			}
			System.out.print(arr[i]+"; ");
		}
		
	}
}
