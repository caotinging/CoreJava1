package chapter14.blockingQueue;

import java.io.File;
import java.util.*;
import java.util.concurrent.*;

public class BlockingQueueTest {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("输入要查询的文件路径 (eg. /user/local/jdk1.6.0/src) : ");
		String directory = in.nextLine();
		System.out.println("输入要查询的关键词 : ");
		String keyWard = in.nextLine();
		
		final int FILE_QUEUE_SIZE = 10;
		final int SEARCH_THREADS = 100;
		
		BlockingQueue<File> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);
		FileEnumerationTask enumerator = new FileEnumerationTask(queue, new File(directory));
		new Thread(enumerator).start();
		
		for(int i = 1; i <= SEARCH_THREADS; i++) {
			new Thread(new SearchTask(queue, keyWard)).start();
		}
		in.close();
	}
}
