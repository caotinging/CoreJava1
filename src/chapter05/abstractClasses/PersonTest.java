package chapter05.abstractClasses;


/*
 * Person��������ĳ������
 * @version 1.7.0_80 2017/3/26
 * @author CaoTing
 */

public class PersonTest {
	public static void main(String[] args) {
		Person[] people = new Person[2];
		people[0] = new Student("Hecker",7070228);
		people[1] = new EmployeeCopy("Hurry",107265);
		
		for(Person e : people) {
			System.out.println(e.getDestricption());
		}
	}
}
