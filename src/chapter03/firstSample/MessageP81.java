package chapter03.firstSample;

//import java.util.Arrays;

/*
 * ʱ��:2017.3.13
 * �ó������ڼ�������������в���
 * args�ַ�������*/
public class MessageP81 {
public static void main(String[] args){
	if(args[0].equals("-h"))
		System.out.print("Hello,");
	//��������е�һ������Ϊ-h���hello
	else if(args[0].equals("-g"))
		System.out.print("Goodbye,");
	//��������е�һ��������-g���Goodbye
	for(String ml:args)
		System.out.print(" "+ml);
	//System.out.print(Arrays.toString(args));
	//Arrays.toString()����һ����������Ԫ�ص��ַ�������ЩԪ�ط������������ö��ŷָ�
	//��������������������鱾80ҳfor eachѭ����
	System.out.println("!");
	//���д˳�����Ҫ���������в����������������Ա��������Ա��������������
}
}
