package chapter04.employee;



/*
 * 时间:2017.3.21
 * 该程序运用到了重载调用构造器
 * 以及静态初始化块
 */

public class ConstructorTest {
public static void main(String[] args){
	Employee2[] staff = new Employee2[3];
	
	staff[0] = new Employee2("harry",40000);
	staff[1] = new Employee2(6000);
	staff[2] = new Employee2();
	
	System.out.println("雇员信息如下: ");
	for(Employee2 e : staff) {
		System.out.println("name = "+e.getName()+" salary = "+e.getSalary()+" id = "+e.getId());
	}
}
}
