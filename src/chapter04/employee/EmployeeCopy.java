package chapter04.employee;

/*
 * ������Employee�ļ򻯰�
 */

class EmployeeCopy 
{
	private static int nextId = 1;//��̬����
	private String name;
	private double salary;
	private int id;
	public EmployeeCopy(String n,double s)
	{
		name = n;
		salary = s;
		id = 0;
		System.out.println("���ǵ�һ�й�����");
	}
	public EmployeeCopy(double s){
		this("EmployeeCopy #"+nextId,s);//(String = "EmployeeCopy #1",double = s);
		System.out.println("���ǵڶ��й�����");//���������˹�����ʹ��this������һ��������
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
		return nextId;//��̬������������ķ���
	}
	public static void main(String[] args){
		System.out.println("�Ҳ�̫����������˼����ֻ֪��:");
		EmployeeCopy e = new EmployeeCopy(2222.2);
		System.out.println(e.getName() + " " + e.getSalary());
	}
}
