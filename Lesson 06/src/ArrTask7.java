
public class ArrTask7 {

	public static void main(String[] args) {
		int[][] arr = {
				{11,12,13,14,15,16,},
				{21,22,23,24,25,26,},
				{31,32,33,34,35,36,},
				{41,42,43,44,45,46,},
				{51,52,53,54,55,56,},
				{61,62,63,64,65,66}
			};
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j <= i-1; j++) {
				sum+=arr[i][j];
			};
		}
		System.out.println(sum);
	}
}
