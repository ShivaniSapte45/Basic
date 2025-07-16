package javaBasic;

public class SwappingNo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 33, b=20;
		System.out.println("Original no a = "+a+" b = "+b);
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println("After swapping a = "+a+" b = "+b);
	}

}
