package javaBasic;

public class CountNo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[]{1, 1, 0, 1, 0, 1, 1, 0};
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        System.out.println("count of 1's::" + sum);
        System.out.println("count of 0's::" + (arr.length - sum));

	}

}
