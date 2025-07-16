package javaBasic;

public class RevserseEachWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "Hello World";
		String words[] = str.split("\\s");
		String reverse = "";
		for (String w: words)
		{
			 StringBuilder sb=new StringBuilder(w);  
		        sb.reverse();  
		        reverse+=sb.toString()+" ";  
		}
		System.out.println(reverse);
		

	}
	

}
