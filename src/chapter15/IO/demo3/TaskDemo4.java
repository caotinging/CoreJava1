package chapter15.IO.demo3;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 * ��������10�������ŵ�������
	(1)ȥ���������д���10����
	(2)���������е�����д�뵽�����ļ�number.txt��
 * @author caoting
 *
 */

public class TaskDemo4 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] arr = new int[10];
		System.out.println("������10������");
		
		for(int i = 1; i<=10; i++) {
			System.out.print("��" +i+ "����");
			arr[i-1] = in.nextInt();
			System.out.println("========");
		}
		
		ArrTen arrten = new ArrTen(arr);
		//����ArrTen���з���ȥ������10����
		int[] arr1 = arrten.removeBig();
		
		System.out.println("������Ҫд�����ݵ��ļ�·��");
		
		File file = new File(in.next());
		//����д���ļ��ķ���
		if(file!=null) {
			ArrTen.outputToFile(file, Arrays.toString(arr1));
			System.out.println("�ļ�д��ɹ���");
		}
		in.close();
	}
}
