package javaBasic;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc =  new Scanner(System.in);
		System.out.println("Enter number ");
		int no = sc.nextInt();
		int rev=0, original = no;
		while(no!=0)
		{
			rev = rev*10 + no%10;
			no = no/10;
		}
		System.out.println("reversed no is - "+rev);
		if(original == rev)
		{
			System.out.println("no is palindrome");
		}else {
			System.out.println("no is not palindrome");
		}
		
	}

}
