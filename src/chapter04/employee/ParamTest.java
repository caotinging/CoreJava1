package chapter04.employee;


/*
 * ʱ��:2017.3.20
 * �˳������ڼ��Java����������ʹ�����
 * 1��һ�����������޸Ļ����������ͣ���ֵ�ͺͲ����ͣ�
 * 2��һ���������Ըı���������״̬
 * 3��һ�����������ö����������һ���µĶ���
 * ������ļ�����һP123
 */

public class ParamTest {
public static void main(String[] args){
	
	System.out.println("����һ :");
	double percent = 10;
	System.out.println("ԭʼ���ݵ�ֵ:");
	System.out.println("percent = "+percent);
	percent = tripleValue(percent);
	//tripleValue(percent);
	System.out.println("���з������ֵ: percent = "+percent);
	
	System.out.println("����� :");
	EmployeeTwo wow = new EmployeeTwo("caoting",50000.0);
	System.out.println("��Աԭʼ��Ϣ: \n����: "+wow.getName()+" нˮ: "+wow.getSalary());
	tripleSalary(wow);
	System.out.println("���з������Ա��ϢΪ: \n����: "+wow.getName()+" нˮ: "+wow.getSalary());
	
	System.out.println("������: ");
	EmployeeTwo a = new EmployeeTwo("Tom",4000);
	EmployeeTwo b = new EmployeeTwo("Bob",5000);
	System.out.println("a,b��ԭʼ��Ϣ����: ");
	System.out.println("a����Ϣ: \n����: "+a.getName()+" нˮ: "+a.getSalary());
	System.out.println("b����Ϣ: \n����: "+b.getName()+" нˮ: "+b.getSalary());
	a = swap(a,b);
	//swap(a,b);
	System.out.println("a,b�����з�������Ϣ����: ");
	System.out.println("a����Ϣ: \n����: "+a.getName()+" нˮ: "+a.getSalary());
	System.out.println("b����Ϣ: \n����: "+b.getName()+" нˮ: "+b.getSalary());
}
/*public static void tripleValue(double x){
	x *= 2;
	System.out.println("x��ֵ: "+x);
}*/

public static double tripleValue(double x){
	x *= 2;
	System.out.println("x��ֵ: "+x);
	return x;
}
//�����޸ĺ���ȷ�ķ���һ
public static void tripleSalary(EmployeeTwo x){
	x.raiseSalary(200);
	System.out.println("x����Ϣ: \n����: "+x.getName()+" нˮ: "+x.getSalary());
}
/*public static void swap(EmployeeTwo x,EmployeeTwo y){
	EmployeeTwo temp = x;
	x = y;
	y = temp;
	System.out.println("x(a),y(b)����Ϣ����: ");
	System.out.println("x����Ϣ: \n����: "+x.getName()+" нˮ: "+x.getSalary());
	System.out.println("y����Ϣ: \n����: "+y.getName()+" нˮ: "+y.getSalary());
}*/
public static EmployeeTwo swap(EmployeeTwo x,EmployeeTwo y){
	EmployeeTwo temp = x;
	x = y;
	y = temp;
	System.out.println("x(a),y(b)����Ϣ����: ");
	System.out.println("x����Ϣ: \n����: "+x.getName()+" нˮ: "+x.getSalary());
	System.out.println("y����Ϣ: \n����: "+y.getName()+" нˮ: "+y.getSalary());
	return x;
}//�����޸ĺ����ȷ������
}
