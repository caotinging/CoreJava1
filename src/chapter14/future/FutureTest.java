package chapter14.future;

import java.util.*;
import java.io.*;
import java.util.concurrent.*;

/**
 * �������������Ŀ¼������Ŀ¼�����������ؼ��ֵ��ļ� ��ͳ���ļ�������ӡ����
 * @date 2017/6/5
 * @author caoting
 */
public class FutureTest {
	public static void main(String[] args) {
		String directory;
		String keyWard;
		try(Scanner in = new Scanner(System.in)) {
			System.out.println("����Ҫ�������ļ�·�� : ");
			directory = in.nextLine();
			System.out.println("����Ҫ�����Ĺؼ��� : ");
			keyWard = in.nextLine();
		}
		
		MatchCounter counter = new MatchCounter(new File(directory), keyWard);
		FutureTask<Integer> task = new FutureTask<>(counter);
		new Thread(task).start();
		
		try {
			System.out.println("һ����  " + task.get() + " ���ļ����йؼ���");
		}
		catch(ExecutionException e) {
			e.printStackTrace();
		}
		catch(InterruptedException e) {}
	}
}
