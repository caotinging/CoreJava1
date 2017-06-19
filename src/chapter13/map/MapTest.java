package chapter13.map;

import java.util.*;

import chapter05.equals.Employee;

/**
 * @version 1.11 2017/5/25
 * @author caoting
 */
public class MapTest {
	public static void main(String[] args) {
		Map<String, Employee> staff = new HashMap<>();
		staff.put("144-25-5464", new Employee("Amy Lee"));
		staff.put("567-24-2546", new Employee("Harry Hecker"));
		staff.put("157-62-7935", new Employee("Gary Cooper"));
		staff.put("456-62-5527", new Employee("Francesca Cruz"));
		
		System.out.println(staff);
		
//		�������������remove put get ���صĶ��Ǽ���Ӧ��ֵ  put(�������ǰ��ֵ�� 
		System.out.println("ɾ��ӳ��: " + staff.remove("567-24-2546"));
		System.out.println("���ӳ��: " + staff.put("456-62-5527", new Employee("Francesca Miller")));
		System.out.println("����ӳ��: " + staff.get("157-62-7935"));
		
		for(Map.Entry<String, Employee> entry : staff.entrySet()) {
			String key = entry.getKey();
			Employee value = entry.getValue();
			System.out.println("key = " + key + " value = " + value);
		}
	}
}
