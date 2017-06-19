package chapter04.employee;


/*
 * 时间:2017.3.20
 * 此程序用于检测Java方法参数的使用情况
 * 1：一个方法不能修改基本数据类型（数值型和布尔型）
 * 2：一个方法可以改变对象参数的状态
 * 3：一个方法不能让对象参数引用一个新的对象
 * 详见核心技术卷一P123
 */

public class ParamTest {
public static void main(String[] args){
	
	System.out.println("试验一 :");
	double percent = 10;
	System.out.println("原始数据的值:");
	System.out.println("percent = "+percent);
	percent = tripleValue(percent);
	//tripleValue(percent);
	System.out.println("运行方法后的值: percent = "+percent);
	
	System.out.println("试验二 :");
	EmployeeTwo wow = new EmployeeTwo("caoting",50000.0);
	System.out.println("雇员原始信息: \n姓名: "+wow.getName()+" 薪水: "+wow.getSalary());
	tripleSalary(wow);
	System.out.println("运行方法后雇员信息为: \n姓名: "+wow.getName()+" 薪水: "+wow.getSalary());
	
	System.out.println("试验三: ");
	EmployeeTwo a = new EmployeeTwo("Tom",4000);
	EmployeeTwo b = new EmployeeTwo("Bob",5000);
	System.out.println("a,b的原始信息如下: ");
	System.out.println("a的信息: \n姓名: "+a.getName()+" 薪水: "+a.getSalary());
	System.out.println("b的信息: \n姓名: "+b.getName()+" 薪水: "+b.getSalary());
	a = swap(a,b);
	//swap(a,b);
	System.out.println("a,b的运行方法后信息如下: ");
	System.out.println("a的信息: \n姓名: "+a.getName()+" 薪水: "+a.getSalary());
	System.out.println("b的信息: \n姓名: "+b.getName()+" 薪水: "+b.getSalary());
}
/*public static void tripleValue(double x){
	x *= 2;
	System.out.println("x的值: "+x);
}*/

public static double tripleValue(double x){
	x *= 2;
	System.out.println("x的值: "+x);
	return x;
}
//这是修改后正确的方法一
public static void tripleSalary(EmployeeTwo x){
	x.raiseSalary(200);
	System.out.println("x的信息: \n姓名: "+x.getName()+" 薪水: "+x.getSalary());
}
/*public static void swap(EmployeeTwo x,EmployeeTwo y){
	EmployeeTwo temp = x;
	x = y;
	y = temp;
	System.out.println("x(a),y(b)的信息如下: ");
	System.out.println("x的信息: \n姓名: "+x.getName()+" 薪水: "+x.getSalary());
	System.out.println("y的信息: \n姓名: "+y.getName()+" 薪水: "+y.getSalary());
}*/
public static EmployeeTwo swap(EmployeeTwo x,EmployeeTwo y){
	EmployeeTwo temp = x;
	x = y;
	y = temp;
	System.out.println("x(a),y(b)的信息如下: ");
	System.out.println("x的信息: \n姓名: "+x.getName()+" 薪水: "+x.getSalary());
	System.out.println("y的信息: \n姓名: "+y.getName()+" 薪水: "+y.getSalary());
	return x;
}//这是修改后的正确方法三
}
