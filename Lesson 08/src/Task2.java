import java.util.Scanner;


public class Task2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String text1 = null;
		String text2 = null;
		do{
			System.out.println("Input text (10-20 characters): ");
			text1 = sc.nextLine();			
		}while(text1.length() > 20 || text1.length() < 10);
		
		do{
			System.out.println("Input another text (10-20 characters): ");
			text2 = sc.nextLine();			
		}while(text2.length() > 20 || text2.length() < 10);
		System.out.println(text1.length() > text2.length()? text1.length() +" "+ revStartString(text2, text1) : text2.length() +" "+ revStartString(text1, text2));
		
		
		
	}
	
	static String revStartString(String s1, String s2){
		String s3 = s1.substring(0, 4) + s2.substring(5);		
		return s3;
	}
}
