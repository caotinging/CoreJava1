package chapter15.IO.demo7;

public class Test {
	public static void main(String[] args) {
		System.out.println("==============");
		try{
			int i = 0/0;
			System.out.println(i);
		}catch(Exception e){
			System.out.println("Òì³£²¶×½");
		}
		System.out.println("==============");
	}
}
