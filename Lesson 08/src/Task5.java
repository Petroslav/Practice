import java.util.Scanner;

public class Task5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		int cross1 = 0;
		int cross2 = 0;
		boolean match = false;
		
		for (int i = 0; i < s1.length(); i++) {
			if(s2.charAt(0) == s1.charAt(i)){
				cross1 = i;
				match = true;
				break;
			}
		}
		if(!match){
			for (int i = 0; i < s1.length(); i++) {
				for (int j = 0; j < s2.length(); j++) {
					if(s1.charAt(i) == s2.charAt(j)){
						cross1 = i;
						cross2 = j;
						match = true;
						break;
					}
				}
			}
		}
		System.out.println(cross1);
		System.out.println(cross2);
		for (int i = 0; i < s1.length(); i++) {
			if(cross2 > 0 && cross2 != i){
				for (int j = 0; j < cross2; j++) {
					System.out.print(" ");
				}
			}if(cross2 == 0 && cross1 == i){
				System.out.println(s2);
				i++;
			}
			if(cross2 == i && cross2 != 0){
				System.out.println(s2);
				i++;
			}else{
				System.out.println(s1.charAt(i));
			}
		}

		if(!match){
			System.out.println("No matching characters");
		}
		
		
		
		
	}
}
