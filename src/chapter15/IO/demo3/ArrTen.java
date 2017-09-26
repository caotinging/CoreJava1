package chapter15.IO.demo3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ArrTen {
	private int[] arr;
	
	public ArrTen() {
		arr = new int[10];
	}
	public ArrTen(int[] arr) {
		this.arr = arr;
	}
	
	//ȥ�������д���10����
	public int[] removeBig() {
		int j = 0;
		for(int i = 0; i<10; i++) {
			if(arr[i] < 10) {
				j++;
			}
		}
		int[] arr2 = new int[j];
		for(int i = 0, n = 0; i<10; i++) {
			if(arr[i] < 10) {
				arr2[n] = arr[i];
				n++;
			}
		}
		
		return arr2;
	}
	
	//������ļ��ķ���
	public static void outputToFile(File file, String string) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(file, true);
			writer.write(string);
			writer.flush();
		}catch(IOException ex) {
			System.out.println(ex);
			throw new RuntimeException("�ļ�д��ʧ�ܣ�");
		}finally {
			try{
				if(writer!=null) writer.close();
			}catch(IOException ex) {
				throw new RuntimeException("��Դ�ͷ�ʧ�ܣ�");
			}
		}
	}
}
