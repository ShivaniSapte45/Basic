package javaBasic;

import java.util.Scanner;

public class ReverseNo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter value ");
		
		int no = sc.nextInt();
		int rev = 0;
		while(no!=0)
		{
			rev = rev*10 + no%10;
			no=no/10;
		}
		System.out.println("Reversed no is "+rev);
				

	}

}
