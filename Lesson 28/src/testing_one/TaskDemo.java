package testing_one;

import java.util.Scanner;

public class TaskDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input a number: ");
		int number = sc.nextInt();
		System.out.println("Your number is: " + number);
		System.out.println("Your number on drugs is: " + (number*0.25 + 3.14));
	}
}
