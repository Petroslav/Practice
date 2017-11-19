
public class ArrTask8 {

	public static void main(String[] args) {
		boolean[][] arr = {
				{true,false,false,},
				{true,false,false},
				{false,true,true}
			};
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr[i].length; j++) {
				if(arr[i][j] == true){
					System.out.println(arr[i][j]);
				}
			}
		}
	}
}
