package javaBasic;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String original = "Hello abc", reverse="";
		char ch;
		
		System.out.println("Original String - " + original);
		for(int i=0; i<original.length(); i++)
		{
			ch = original.charAt(i);
			reverse = ch + reverse;
			
		}
		System.out.println("Reversed string = "+reverse);
	
	//using string builder			
			String input2 = "Geeks for Test";
			 
	        StringBuilder input1 = new StringBuilder();
	 
	        // append a string into StringBuilder input1
	        input1.append(input2);
	 
	        // reverse StringBuilder input1
	        input1.reverse();
	 
	        // print reversed String
	        System.out.println(input1);
}
}