package javaBasic;

public class Piryamid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i, j, row=5;
		// outer loop to handle number of rows
        //  row in this case
		for(i=0; i<row; i++)
		{
			 // inner loop to handle number spaces
            // values changing acc. to requirement
			for(j=row-i; j>1; j--)
			{
				// printing spaces
				System.out.print(" ");
			}
		//  inner loop to handle number of columns
            //  values changing acc. to outer loop
			for(j=0; j<=i; j++)
			{
				System.out.print("* ");
			}
			// ending line after each row
			System.out.println();
		}

	}

}
