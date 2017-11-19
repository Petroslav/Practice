
public class Task1 {

	public static void main(String[] args) {
		int[] array = {10, 3, 5, 8, 6, -3, 7};
		int min = array[0];
		for (int i = 0; i < array.length; i++) {
			if(array[i]%3 == 0 && array[i] < min){
				min = array[i];
			}
		}
		System.out.println(min);
	}
}
