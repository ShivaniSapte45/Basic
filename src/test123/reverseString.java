package test123;

public class reverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String original = "shivani";
		String reverse ="";
		char ch;
		for(int i = 0; i<original.length(); i++)
		{
			ch = original.charAt(i);
			reverse = ch +reverse;
		}
		System.out.println(reverse);
	}

}
