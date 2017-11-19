import java.util.Scanner;

public class ExtraTask1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		System.out.println(checkStart(s1, s2));
	}
	
	static boolean checkStart(String s1, String s2){
		boolean atStart = false;
		if(s2.contains(s1)){
			for (int i = 0; i < s1.length(); i++) {
				if(s2.charAt(i)==s1.charAt(i)){
					atStart = true;
				}else{
					atStart = false;
					break;
				}
			}
		}
		return atStart;
	}
}
