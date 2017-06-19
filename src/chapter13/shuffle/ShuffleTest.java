package chapter13.shuffle;

import java.util.*;

/**
 * 这个类随机打乱列表 并将打乱的列表的前6个值排序 打印
 * @version 1.11 2017/5/27
 * @author caoting
 */
public class ShuffleTest {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		
		for(int i = 1; i <= 50; i++) {
			numbers.add(i);
		}
		Collections.shuffle(numbers);
		List<Integer> winningCombination = numbers.subList(0, 6);
		Collections.sort(winningCombination);
		System.out.println("中奖的前6个号码是: " + winningCombination);
	}
}
