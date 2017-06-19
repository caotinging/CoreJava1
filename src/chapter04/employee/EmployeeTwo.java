package chapter04.employee;
/*
 * Ê±¼ä:2017.3.20
 */
class EmployeeTwo {
private String name;
private double salary;
public EmployeeTwo(String n,double s){
	name = n;
	salary = s;
}
public String getName(){
	return name;
}
public double getSalary(){
	return salary;
}
public void raiseSalary(double byPercent){
	double raise = salary * byPercent / 100;
	salary += raise;
}
}
