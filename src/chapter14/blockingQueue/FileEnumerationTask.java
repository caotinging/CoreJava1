package chapter14.blockingQueue;

import java.io.*;
import java.util.concurrent.*;

/**
 * ����ǰĿ¼������Ŀ¼�е��ļ�put������������
 * @version 1.8 2017/6/4
 * @author caoting
 */
public class FileEnumerationTask implements Runnable {
	public static File DUMMY = new File("");
	private BlockingQueue<File> queue;
	private File startingDirectory;
	
	public FileEnumerationTask(BlockingQueue<File> queue, File startingDirectory) {
		this.queue = queue;
		this.startingDirectory = startingDirectory;
	}
	
	public void run() {
		try {
			enumerate(startingDirectory);
			queue.put(DUMMY);
		}
		catch(InterruptedException e) {}
	}
	
	public void enumerate(File fileDirectory) throws InterruptedException {
		File[] files = fileDirectory.listFiles();
		
		for(File file : files) {
			if(file.isDirectory()) enumerate(file);
			else queue.put(file);
		}
	}
}
