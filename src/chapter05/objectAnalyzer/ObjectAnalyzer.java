package chapter05.objectAnalyzer;

import java.lang.reflect.*;
import java.util.ArrayList;

public class ObjectAnalyzer {
	private ArrayList<Object> visited = new ArrayList<>();
	
	/**
	 * Converts an object to a string representation that lists all fields.
	 * @param obj an object
	 * @return a string with object's class name and all field names and values
	 * @author CaoTing
	 */
	public String toString (Object obj) {
		if (obj == null)
			return "null";
		if (visited.contains(obj))
			return "...";
		visited.add(obj);
		Class<?> cl = obj.getClass();
		if (cl == String.class)
			return (String) obj;
		if (cl.isArray()) {
			//getComponentType����һ������������������͡��������ಢ������һ�������෽������null
			String r = cl.getComponentType() + "[]{";
			for (int i = 0 ; i < Array.getLength(obj) ; i++) {
				if (i > 0) r += ",";
				Object val = Array.get(obj, i);
				//���cl�����Ԫ��������ԭʼ����  ִ��r += val
				if (cl.getComponentType().isPrimitive()) r += val;
				else r += toString(val);//�ݹ����
			}
			return r + "}";
		}
		//���ִ�е�����һ��˵��obj������������
		String r = cl.getName();
		//inspect the fields of this class and all superclass
		do {
			r += "[";
			Field[] fields = cl.getDeclaredFields();
			//����������ķ���Ȩ��
			AccessibleObject.setAccessible(fields, true);
			//get the names and values all of the class
			for (Field f : fields) {
				if (!Modifier.isStatic(f.getModifiers())) {
					if (!r.endsWith("[")) r += ",";
					r += f.getName() +"=";
					try {
						Class<?> t = f.getType();
						Object val = f.get(obj);
						if (t.isPrimitive()) r += val;
						else r += toString(val);
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			r += "]";
			cl = cl.getSuperclass();
		}
		while (cl != null);
		return r;
	}
}
