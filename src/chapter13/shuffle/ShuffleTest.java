package chapter13.shuffle;

import java.util.*;

/**
 * �������������б� �������ҵ��б��ǰ6��ֵ���� ��ӡ
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
		System.out.println("�н���ǰ6��������: " + winningCombination);
	}
}
