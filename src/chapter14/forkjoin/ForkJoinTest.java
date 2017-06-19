package chapter14.forkjoin;

import java.util.concurrent.*;

/**
 * 这个类利用Fork-Join框架  实现将复杂的任务自然地分解为子任务递归执行
 * @date 2017/6/5
 * @author caoting
 */
public class ForkJoinTest {
	public static void main(String[] args) {
		final int SIZE = 10000000;
		double[] numbers = new double[SIZE];
		for(int i = 0; i < SIZE; i++) {
			numbers[i] = Math.random();
		}
		
		Counter counter = new Counter(numbers, 0, numbers.length, new Filter() {
			public boolean accept(double t) {
				return t > 0.5;
			}
		});
		
		ForkJoinPool pool = new ForkJoinPool();
		System.out.println("大于0.5的小数一共有: " + pool.invoke(counter));
	}
}

interface Filter {
	boolean accept(double t);
}

class Counter extends RecursiveTask<Integer> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int THRESHOLD = 1000;
	private double[] values;
	private int from;
	private int to;
	private Filter filter;
	
	public Counter(double[] values, int from, int to, Filter filter) {
		this.values = values;
		this.from = from;
		this.to = to;
		this.filter = filter;
	}
	
	protected Integer compute() {
		if(to-from < THRESHOLD) {
			int count = 0;
			for(int i = from; i < to; i++) 
				if(filter.accept(values[i]))
					count++;
			return count;
		}
		else {
			int mid = (to + from) / 2;
			Counter first = new Counter(values, from, mid, filter);
			Counter second = new Counter(values, mid, to, filter);
			invokeAll(first, second);
			return first.join() + second.join();
		}
	}
}
