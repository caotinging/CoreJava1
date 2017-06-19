package chapter05.arrays;

import java.lang.reflect.*;
import java.util.*;

/**
 * This program demonstrates the use of the reflection for manipulating arrays.
 * @version 1.7.0_80 2017/4/4
 * @author CaoTing
 */

public class CopyOfTest {
	public static void main (String[]args) {
		int[] a = { 1, 2, 3 };
		a = (int[]) goodCopyOf(a,10);
		System.out.println(Arrays.toString(a));
		String[] b = { "Tom", "Dick", "Harry" };
		b = (String[]) goodCopyOf(b,10);
		System.out.println(Arrays.toString(b));
	}
	/**
	 * This method attempts to grow an array by allocating a new array and copying all elements.
	 * @param a the array to grow
	 * @param newLength the new length
	 * @return a larger array that contains all elements of a. 
	 * However, the returned array has type Object[], not the same type as a
	 * 教材2017页
	 */
	public static Object[] badCopyOf(Object[] a, int newLength) {//not useful
		Object[] newArray = new Object[newLength];
		System.arraycopy(a, 0, newArray, 0, Math.min(a.length, newLength));//min方法返回两个数中较小的那个
		return newArray;//这个方法实际是错的会抛出异常
	}
	
	/**
	 * This method grows an array by allocating a new array of the same type and coping all elements.
	 * @param a the array to grow. This can bean object array or a primitive type array.
	 * @return a larger array that contains all elements of a.
	 */
	public static Object goodCopyOf (Object a, int newLength) {
		Class<?> cl = a.getClass();
		if (!cl.isArray()) return null;
		Class<?> componentType = cl.getComponentType();
		int length = Array.getLength(a);
		Object newArray = Array.newInstance(componentType, length);
		System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
		//System.out.println(cl);
		return newArray;
	}
}
