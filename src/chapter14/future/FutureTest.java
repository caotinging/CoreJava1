package chapter14.future;

import java.util.*;
import java.io.*;
import java.util.concurrent.*;

/**
 * 这个类搜索给定目录及其子目录的所含给定关键字的文件 并统计文件数量打印出来
 * @date 2017/6/5
 * @author caoting
 */
public class FutureTest {
	public static void main(String[] args) {
		String directory;
		String keyWard;
		try(Scanner in = new Scanner(System.in)) {
			System.out.println("输入要搜索的文件路径 : ");
			directory = in.nextLine();
			System.out.println("输入要搜索的关键字 : ");
			keyWard = in.nextLine();
		}
		
		MatchCounter counter = new MatchCounter(new File(directory), keyWard);
		FutureTask<Integer> task = new FutureTask<>(counter);
		new Thread(task).start();
		
		try {
			System.out.println("一共有  " + task.get() + " 个文件含有关键字");
		}
		catch(ExecutionException e) {
			e.printStackTrace();
		}
		catch(InterruptedException e) {}
	}
}
