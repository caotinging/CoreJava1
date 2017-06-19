package chapter06.staticInner;

/**
 * This program demonstrates the use of static inner class.
 * @version 1.7.0_80 2017/4/10
 * @author caoting
 */
public class StaticInnerClassTest {
	public static void main(String[] args) {
		double[] d = new double[20];
		for (int i= 0; i < d.length; i++) {
			d[i] = 100 * Math.random();
		}
		ArrayAlg.Pair p = ArrayAlg.minmax(d);
		System.out.println("最大值是: "+p.getFirst());
		System.out.println("最小值是: "+p.getLast());
	}
}
class ArrayAlg {
	/**
	 * a pair of floating-point numbers
	 */
	public static class Pair {
		private double first = 0;//最大值
		private double last = 0;//最小值
		
		/**
		 * Constructs a pair from two floating-point numbers
		 * @param f the first number
		 * @param s the last number
		 */
		public Pair(double first, double last) {
			this.first = first;
			this.last = last;
		}
		/**
		 * Returns the max number
		 * @return the first number
		 */
		public double getFirst () {
			return first;
		}
		/**
		 * Returns the min number
		 * @return the last number
		 */
		public double getLast (){
			return last;
		}
	}
	
	/**
	 * Computes both the minimun and the maximun of an array
	 * @param values an array of floating-pointer numbers
	 * @return a pair class whose first element is the maximun and whose last element is the minimum
	 */
	public static Pair minmax (double[] values) {
		double min = Double.MAX_VALUE;
		double max = Double.MIN_VALUE;
		for (double v : values) {
			if (v > max) max = v;
			if (v < min) min = v;
		}
		return new Pair(max, min);
	}
}