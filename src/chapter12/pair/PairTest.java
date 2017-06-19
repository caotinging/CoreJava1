package chapter12.pair;

/**
 * @version 1.01 2017/5/18
 * @author caoting
 */
public class PairTest {
	public static void main(String[] args) {
		String[] words = {"Mary", "had", "a", "little", "lamb"};
		Pair<String> mm = ArrayAlg.minmax(words);
		System.out.println("��Сֵ�� :" + mm.getFirst());
		System.out.println("���ֵ�� :" + mm.getSecond());
	}
}

class ArrayAlg {
	public static Pair<String> minmax (String[] a) { //��̬��������ֱ�ӵ���
		if(a == null || a.length == 0) return null;
		
		String min = a[0];
		String max = a[0];
		for(int i = 1; i < a.length; i++) {
			if(min.compareTo(a[i]) > 0) min = a[i];
			if(max.compareTo(a[i]) < 0) max = a[i];
		}
		return new Pair<String> (min, max);
	}
}
