
public class ArrTask11 {

	public static void main(String[] args) {
		int[][] arr = new int[4][5];
		int cnt = 1;

		for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j <= i; j++) {
					arr[i-j][j] = cnt;
					cnt++;
				}
		}
		System.out.println(cnt);
		
		for (int i = arr.length-1; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				arr[arr.length-1-j][arr[0].length-i-1+j] = cnt;
				cnt++;
			}
			
		}
		System.out.println(cnt);
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+", ");
			}
			System.out.println();
		}		
		
	}
}


// po kolonki
//for (int i = 0; i < arr[0].length; i++) {
//for (int j = 0; j < arr.length; j++) {
//	arr[j][i] = cnt;
//	cnt++;
//}
//System.out.println();
//}
//for (int i = 0; i < arr.length; i++) {
//for (int j = 0; j < arr[i].length; j++) {
//	System.out.print(arr[i][j]+", ");
//}
//System.out.println();
//}

// po redove
//for (int i = 0; i < arr.length; i++) {
//	for (int j = 0; j < arr[i].length; j++) {
//		arr[i][j] = cnt;
//		cnt++;
//	}
//}
//for (int i = 0; i < arr.length; i++) {
//	for (int j = 0; j < arr[i].length; j++) {
//		System.out.print(arr[i][j]+", ");
//	}
//	System.out.println();
//}		
//
//}

/* zigzag
for (int i = 0; i < arr[0].length; i++) {
for (int j = 0; j < arr.length; j++) {
	arr[j][i] = cnt;
	cnt++;
}
i++;
if(i == arr[0].length){
	break;
}
for (int j = arr.length-1; j >= 0; j--) {
	arr[j][i] = cnt;
	cnt++;
}
}
for (int i = 0; i < arr.length; i++) {
for (int j = 0; j < arr[i].length; j++) {
	System.out.print(arr[i][j]+", ");
}
System.out.println();
}		

}
}
*/