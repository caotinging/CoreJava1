package chapter04.employee;


/*
 * 时间：2017.3.16
 * 该程序用于存储职员的薪水
 * */

public class EmployeeTestP107 {
public static void main(String[] args){
	Employee[] staff = new Employee[3];
	staff[0] = new Employee("caoting",6666,1998,5,15);
	staff[1] = new Employee("xiaobb",9999,2025,5,20);
	staff[2] = new Employee("yuanhao",22222,1999,11,12);
	for(Employee e:staff)
		e.raiseSalary(5);//加薪水
	for(Employee e:staff)
	{
		System.out.println("name = "+e.getName()+", salary = "+e.getSalary());
		System.out.println("hireDay = "+e.getDate());
		System.out.println();
	}
}
}
/*class Employee{
		private String name;
		private double salary;
		private Date hireDay;
public Employee(String n,double s,int year,int month,int day){
			name = n;
			salary = s;
			GregorianCalendar calendar = new GregorianCalendar(year,month-1,day);
			hireDay = calendar.getTime();
}
		public String getName(){
			return name;
		}
		public double getSalary(){
			return salary;
		}
		public Date getDate(){
			return hireDay;
		}
		public void raiseSalary(double byPercent){
			double raise = salary * byPercent/100;
			salary += raise;
		}
}*/
