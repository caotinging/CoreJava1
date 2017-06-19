package chapter14.threadPool;

import java.util.concurrent.*;
import java.io.*;
import java.util.*;

public class ThreadPool {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("������Ҫ�������ļ�·�� : ");
		String directory = in.nextLine();
		System.out.println("������Ҫ�����Ĺؼ��� :");
		String keyWard = in.nextLine();
		
		ExecutorService pool = Executors.newCachedThreadPool();
		MatchCounter counter = new MatchCounter(new File(directory), keyWard, pool);
		Future<Integer> result = pool.submit(counter);
		
		try {
			System.out.println("һ���� " + result.get() + " ���ļ������ؼ��� ");
		}
		catch(ExecutionException e) {
			e.printStackTrace();
		}
		catch(InterruptedException e) {}
		pool.shutdown();
		in.close();
		
		int largestPoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
		System.out.println("�̳߳�������߳�������Ϊ: " + largestPoolSize);
	}
}

class MatchCounter implements Callable<Integer> {
	private File directory;
	private String keyWard;
	private int count;
	private ExecutorService pool;
	
	public MatchCounter(File directory, String keyWard, ExecutorService pool) {
		this.directory = directory;
		this.keyWard = keyWard;
		this.pool = pool;
	}
	
	public Integer call() {
		count = 0;
		try {
			File[] files = directory.listFiles();
			List<Future<Integer>> results = new ArrayList<>();
			
			for(File file : files) {
				if(file.isDirectory()) {
					MatchCounter counter = new MatchCounter(file, keyWard, pool);
					results.add(pool.submit(counter));
//					pool.submit���ظ��̵߳�Future����
				}
				else {
					if(search(file)) count++;
				}
			}
			
			for(Future<Integer> result : results) {
				try {
					count += result.get();
				}
				catch(ExecutionException e) {
					e.printStackTrace();
				}
			}
		}
		catch(InterruptedException e) {}
		return count;
	}
	
	public boolean search(File file) {
		boolean found = false;
		try {
			try(Scanner in = new Scanner(file)) {
				while(!found && in.hasNextLine()) {
					String line = in.nextLine();
					if(line.contains(keyWard)) found = true;
				}
			}
			return found;
		}
		catch(IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}