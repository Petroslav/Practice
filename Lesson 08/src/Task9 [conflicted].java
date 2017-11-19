import java.util.Scanner;

public class Task9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		
		text = text.replaceAll("[^0-9, -]", " ");
		System.out.println(text);
		char[] newText = text.toCharArray();
		int sum = 0;
		int num = 0;
		int pwr = 1;
		boolean negative = false;
		for (int i = 0; i < newText.length; i++) {
			if(newText[i] != ' '){
				if(newText[i] == '-'){
					negative = true;
					num+= newText[i]*pwr;
				}
			}
		}
				//replace all characters except - and digits with blank space

	}
}


////split the string by spaces
//System.out.println(digits);
//int sum = 0;
//for (int i = 0; i < digits.length; i++) {
//	System.out.println(digits[i]);
//	sum+=digits[i];
//}
////sum all the numbers
//System.out.println(sum);

//char[] digits = text.toCharArray();
//System.out.println(Arrays.toString(digits));
//boolean neg = false;
//int pwr = 1;
//int num = 0;
//int sum = 0;
//for (int i = 0; i < digits.length; i++) {
//	if(neg && digits[i] == '-'){
//		System.out.println(num);
//		sum+=num;
//		continue;
//	}
//	if(digits[i] == '-'){
//		neg = true;
//	}
//	if(digits[i] < 9 && digits[i] > 0){
//		num+=digits[i]*pwr;
//		pwr*=10;
//	}else{
//		if(neg){
//			num = -num;
//			neg = false;
//			System.out.println(num);
//			sum+=num;
//		}
//	}
//		
//}
//char a = '6';
//int sum = a;
//System.out.println("sum: "+sum);
