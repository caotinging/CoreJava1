package chapter04.employee;


/*
 * 时间:2017.3.19
 * 该程序中有一个静态域和一个静态方法
 * 将三个Employee对象写入数组然后打印
 * 最后打印下一个可用雇员ID展示静态方法
 * */

public class StaticTest {
public static void main(String[] args){
	EmployeeCopy[] staff = new EmployeeCopy[3];
	staff[0] = new EmployeeCopy("Tom",40000);
	staff[1] = new EmployeeCopy("Bob",50000);
	staff[2] = new EmployeeCopy("Tenny",60000);
	for(EmployeeCopy e : staff){
		e.setId();	
		System.out.print("下一个可用ID是: "+EmployeeCopy.getnextId()+"\n");//调用静态方法
	}
	System.out.println("雇员信息如下:");
	for(EmployeeCopy e : staff){
		System.out.println("name = "+e.getName()+" ,id = "+e.getId()+" ,salary = "+e.getSalary());
	}
}
}
