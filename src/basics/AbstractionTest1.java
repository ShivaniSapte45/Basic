package basics;

 abstract class Animal {
	  abstract void sleep();

	public void sound()
	{
		System.out.println("Animal sound test");
	}
}
  class Cat extends Animal {

	@Override
	void sleep() {
		// TODO Auto-generated method stub
		System.out.println("Cat is sleeping");
	}
	 
 }
public class AbstractionTest1 {

	public static void main(String[] args)
	{
		Cat ca = new Cat();
		ca.sound();
		ca.sleep();
	}
}
