package chapter04.employee;


/*
 * ʱ��:2017.3.19
 * �ó�������һ����̬���һ����̬����
 * ������Employee����д������Ȼ���ӡ
 * ����ӡ��һ�����ù�ԱIDչʾ��̬����
 * */

public class StaticTest {
public static void main(String[] args){
	EmployeeCopy[] staff = new EmployeeCopy[3];
	staff[0] = new EmployeeCopy("Tom",40000);
	staff[1] = new EmployeeCopy("Bob",50000);
	staff[2] = new EmployeeCopy("Tenny",60000);
	for(EmployeeCopy e : staff){
		e.setId();	
		System.out.print("��һ������ID��: "+EmployeeCopy.getnextId()+"\n");//���þ�̬����
	}
	System.out.println("��Ա��Ϣ����:");
	for(EmployeeCopy e : staff){
		System.out.println("name = "+e.getName()+" ,id = "+e.getId()+" ,salary = "+e.getSalary());
	}
}
}
