package chapter15.IO.demo3;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * ����10��1-100������������ŵ�һ��������
	(1)�������д��ڵ���10�����ַŵ�һ��list�����У�����ӡ������̨��
	(2)�������е����ַŵ���ǰ�ļ��е�number.txt�ļ���
 * @author caoting
 *
 */

public class TaskDemo5 {
	public static void main(String[] args) {
		//����һ��ArrRandom����ArrRandom�Ĺ������Զ�������һ���������
		ArrRandom arrR = new ArrRandom();
		//���û�ȡ����10�����ֵķ���
		List<Double> list = arrR.getBig();
		//��listת��ΪString���ݸ�ArrTen���е�outputToFile����
		String string = Arrays.toString(list.toArray());
		ArrTen.outputToFile(new File("G:\\number.txt"), string);
		System.out.println("\n=============================");
		System.out.println("д��ɹ���");
	}
}
