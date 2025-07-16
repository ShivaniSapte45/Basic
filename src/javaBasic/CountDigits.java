package javaBasic;

public class CountDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int no = 127403, count=0;
		while(no>0)
		{
			no=no/10;
			count ++;		
		}
		System.out.println(count);
	}

}
