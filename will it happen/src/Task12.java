import java.util.Scanner;

public class Task12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please input the day: ");
		int day = sc.nextInt();
		System.out.print("Please input the month: ");
		int month = sc.nextInt();
		System.out.print("Please input the year: ");
		int year = sc.nextInt();
		
		boolean isLeap = false;
		boolean bigMonth = false;
		boolean isFeb = false;
		
		if(year % 4 == 0 && year % 400 < 100){
			isLeap = true;
		}
		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
			bigMonth = true;
		}
		if(month == 2){
			isFeb = true;
			if(isLeap && day > 29){
				System.out.println("No such date exists on our calendar.");
				return;
			}
			if(!isLeap && day > 28){
				System.out.println("No such date exists on our calendar.");
				return;
			}
		}
		if(month < 1 || month > 12 || day < 1 || day > 31 || year < 0 ){
			System.out.println("No such date exists on our calendar.");
			return;
		}

		if(day > 30 && !bigMonth){
			System.out.println("No such date exists on our calendar.");
			return;
		}
		
		System.out.println("Current date: "+day+"."+month+"."+year);
		if(month < 12 && !isFeb && (bigMonth && day == 31 || !bigMonth && day == 30)){
			day = 1; 
			month++;
		}
		if(month == 12 && day == 31){
			year++;
			day = 0;
			month = 1;
		}
		if(isFeb && ((isLeap && day == 29) || (!isLeap && day == 28))){
			day = 1;
			month++;
		}else{
			day++;
		}
		System.out.println("Tomorrow's date: "+day+"."+month+"."+year);
		
	}
}
