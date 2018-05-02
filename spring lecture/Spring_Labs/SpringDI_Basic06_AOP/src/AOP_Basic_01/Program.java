package AOP_Basic_01;

public class Program {

	public static void main(String[] args) {
		Cal cal = new Cal();
		int result = cal.Add(10000000,10213241);
		System.out.println("Add : " + result);
		int result2 = cal.Mul(100,10213241);
		System.out.println("Mul : " + result2);
		}

}
