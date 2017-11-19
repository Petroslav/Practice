
public class Task7 {

	public static void main(String[] args) {
		int[][] arr = {
				{11,12,13,14,15,16,},
				{21,22,23,24,25,26,},
				{31,32,33,34,35,36,},
				{41,42,43,44,45,46,},
				{51,52,53,54,55,56,},
				{61,62,63,64,65,66}

		};

		int i = 1;
		int j = 1;
		int sum = 0;
		int sumAll = 0;
		while(i < arr.length){
			if(j > arr[i-1].length){
				System.out.print("the sum of the row is: "+sum);
				sum=0;
				i++;
				j = 1;
				System.out.println();
			}
			if((i+j)%2 ==0){
				sum+=arr[i][j-1];
				sumAll+=arr[i][j-1];
				System.out.print(arr[i][j-1]+", ");
			}
			j++;
		}
		System.out.println("Full sum is: "+sumAll);
	}
}
