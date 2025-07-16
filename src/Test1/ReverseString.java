package Test1;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String original="Hello World";
		String reverse="";
		
		for(int i=0; i<original.length(); i++)
		{
			reverse=original.charAt(i)+reverse;
		}
		System.out.println(reverse);

	}

}
