import java.util.Scanner;

public class Task21 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input a number from the deck: ");
		int num;
		
		do{
			num = sc.nextInt();
		}while(num < 1 || num > 51);
		int suit = 0;
		int pwr = 2;
		
		for(int j=1; j<=num; j++){
			if(suit==5){
				suit=1; pwr++;
			}
			suit++;
		}
		System.out.println(pwr);
		System.out.println("suit "+suit);
		
		for (int i = suit; i < 5; i++) {
			if(suit == 1){
				if(pwr < 11){ System.out.println(pwr+" spatiq, ");}
				if(pwr == 11){System.out.println("J spatiq, ");};
				if(pwr == 12){System.out.println("Q spatiq");};
				if(pwr == 13){System.out.println("K spatiq, ");};
				if(pwr == 14){System.out.println("A spatiq, ");};
			}
			if(suit == 2){
				if(pwr < 11){ System.out.println(pwr+" karo, ");}
				if(pwr == 11){System.out.println("J karo, ");};
				if(pwr == 12){System.out.println("Q karo");};
				if(pwr == 13){System.out.println("K karo, ");};
				if(pwr == 14){System.out.println("A karo, ");};
			}
			if(suit == 3){
				if(pwr < 11){ System.out.println(pwr+" kupa, ");}
				if(pwr == 11){System.out.println("J kupa, ");};
				if(pwr == 12){System.out.println("Q kupa");};
				if(pwr == 13){System.out.println("K kupa, ");};
				if(pwr == 14){System.out.println("A kupa, ");};
			}
			if(suit == 4){
				if(pwr < 11){ System.out.println(pwr+" pika, ");}
				if(pwr == 11){System.out.println("J pika, ");};
				if(pwr == 12){System.out.println("Q pika");};
				if(pwr == 13){System.out.println("K pika, ");};
				if(pwr == 14){System.out.println("A pika, ");};
			}
			suit++;
		}
		pwr++;
		int setPwr = pwr;
		for (int i = 1; i < 5; i++) {
			for (int j = pwr; j < 15; j++) {
				if(i == 1){
					if(pwr < 11){ System.out.println(pwr+" spatiq, ");}
					if(pwr == 11){System.out.println("J spatiq, ");};
					if(pwr == 12){System.out.println("Q spatiq");};
					if(pwr == 13){System.out.println("K spatiq, ");};
					if(pwr == 14){System.out.println("A spatiq, ");};
				}
				if(i == 2){
					if(pwr < 11){ System.out.println(pwr+" karo, ");}
					if(pwr == 11){System.out.println("J karo, ");};
					if(pwr == 12){System.out.println("Q karo");};
					if(pwr == 13){System.out.println("K karo, ");};
					if(pwr == 14){System.out.println("A karo, ");};
				}
				if(i == 3){
					if(pwr < 11){ System.out.println(pwr+" kupa, ");}
					if(pwr == 11){System.out.println("J kupa, ");};
					if(pwr == 12){System.out.println("Q kupa");};
					if(pwr == 13){System.out.println("K kupa, ");};
					if(pwr == 14){System.out.println("A kupa, ");};
				}
				if(i == 4){
					if(pwr < 11){ System.out.println(pwr+" pika, ");}
					if(pwr == 11){System.out.println("J pika, ");};
					if(pwr == 12){System.out.println("Q pika");};
					if(pwr == 13){System.out.println("K pika, ");};
					if(pwr == 14){System.out.println("A pika, ");};
				}
				pwr++;
			}
			pwr = setPwr;
		}
	}
}