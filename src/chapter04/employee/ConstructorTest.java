package chapter04.employee;



/*
 * ʱ��:2017.3.21
 * �ó������õ������ص��ù�����
 * �Լ���̬��ʼ����
 */

public class ConstructorTest {
public static void main(String[] args){
	Employee2[] staff = new Employee2[3];
	
	staff[0] = new Employee2("harry",40000);
	staff[1] = new Employee2(6000);
	staff[2] = new Employee2();
	
	System.out.println("��Ա��Ϣ����: ");
	for(Employee2 e : staff) {
		System.out.println("name = "+e.getName()+" salary = "+e.getSalary()+" id = "+e.getId());
	}
}
}
