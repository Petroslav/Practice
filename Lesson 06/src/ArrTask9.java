import java.util.Arrays;

public class ArrTask9 {

	public static void main(String[] args) {
		int[][] arr = {
				{11,12,13,14,15,16,},
				{21,22,23,24,25,26,},
				{31,32,45,46,35,36,},
				{41,42,55,56,33,34,},
				{51,52,53,54,43,44,}
			};
		int sum = 0;
		int maxMum = 0;
		int[][] maxM = new int[2][2];
				
		
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr[i].length-1; j++) {
				sum+=arr[i][j]+arr[i+1][j]+arr[i][j+1]+arr[i+1][j+1];
				if(sum > maxMum){
					maxMum = sum;
					maxM[0][0] = arr[i][j];
					maxM[0][1] = arr[i][j+1];
					maxM[1][0] = arr[i+1][j];
					maxM[1][1] = arr[i+1][j+1];
					
				}
				sum = 0;
			}
		}
		for (int i = 0; i < maxM.length; i++) {
			for (int j = 0; j < maxM.length; j++) {
				System.out.print(maxM[i][j]+", ");
			}
			System.out.println();
		}
	}
}
