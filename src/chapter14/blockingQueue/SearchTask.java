package chapter14.blockingQueue;

import java.io.*;
import java.util.concurrent.*;
import java.util.*;

/**
 * 这个类将阻塞队列中的文件take出来 检测是否包含关键字 并打印关键字所在文件的行号和行内容
 * @version 1.8 2017/6/4
 * @author caoting
 */
public class SearchTask implements Runnable {
	private BlockingQueue<File> queue;
	private String keyWard;
	
	public SearchTask(BlockingQueue<File> queue, String keyWard) {
		this.queue = queue;
		this.keyWard = keyWard;
	}
	
	public void run() {
		try {
			boolean done = false; //来标识是否遍历完了整个队列  阻塞队列的最后一个文件是虚拟文件DUMMY
			
			while(!done) {
				File file = queue.take();
				if(file == FileEnumerationTask.DUMMY)
					done = true;
				else {
					search(file);
				}
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(InterruptedException e) {}
	}
	
	public void search(File file) throws IOException {
		try(Scanner in = new Scanner(file)) {
			int lineNumber = 0;
			while(in.hasNextLine()) {
				lineNumber++;
				String line = in.nextLine();
				if(line.contains(keyWard)) {
					System.out.printf("%s : %d : %s%n", file.getPath(), lineNumber, line);
				}
			}
		}
	}
}
