package chapter04.employee;

/*
 * 此类是Employee的简化版
 */

class EmployeeCopy 
{
	private static int nextId = 1;//静态变量
	private String name;
	private double salary;
	private int id;
	public EmployeeCopy(String n,double s)
	{
		name = n;
		salary = s;
		id = 0;
		System.out.println("这是第一行构造器");
	}
	public EmployeeCopy(double s){
		this("EmployeeCopy #"+nextId,s);//(String = "EmployeeCopy #1",double = s);
		System.out.println("这是第二行构造器");//这里重载了构造器使用this调用另一个构造器
		nextId++;
	}
	public String getName(){
		return name;
	}
	public double getSalary(){
		return salary;
	}
	public int getId(){
		return id;
	}
	public void setId(){
		id = nextId;
		nextId++;
	}
	public static int getnextId(){
		return nextId;//静态方法，属于类的方法
	}
	public static void main(String[] args){
		System.out.println("我不太明白您的意思，我只知道:");
		EmployeeCopy e = new EmployeeCopy(2222.2);
		System.out.println(e.getName() + " " + e.getSalary());
	}
}
