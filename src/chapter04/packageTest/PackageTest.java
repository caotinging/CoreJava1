package chapter04.packageTest;

/*
 * 时间:2017/3/23
 * 嗯，这个类没什么好说的名字薪水老问题
 * 这个类需要的类第三章的包里面
 */


import chapter03.firstSample.Employee;
import static java.lang.System.*;

public class PackageTest {
public static void main(String[] args) {
	Employee harry = new Employee("herry Hacker",5000,1989,10,1);
	Employee Mary = new Employee("Mary",4000);
	
	harry.raiseSalary(5);
	
	out.println("name = "+harry.getName()+" salary = "+harry.getSalary()+" Date = "+harry.getDate());
	out.println("name = "+Mary.getName()+" salary = "+Mary.getSalary()+" Date = "+Mary.getDate());
}
}
