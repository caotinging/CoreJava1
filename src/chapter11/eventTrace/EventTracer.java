package chapter11.eventTrace;

import java.awt.*;
import java.beans.*;
import java.lang.reflect.*;

/**
 * @version 1.31 2017/5/16
 * @author caoting
 */
public class EventTracer {
	private InvocationHandler handler;
	
	/*
	 * InvocationHandler �Ǵ���ʵ���ĵ��ô������ ʵ�ֵĽӿڡ� 
	 * ÿ������ʵ��������һ�������ĵ��ô������
	 * �Դ���ʵ�����÷���ʱ�����Է������ý��б��벢����ָ�ɵ����ĵ��ô������� invoke ����
	 */
	public EventTracer() {
		handler = new InvocationHandler() {
			public Object invoke(Object proxy, Method method, Object[] args) {
				System.out.println(method + " : " + args);
				return null;
			}
		};
	}
	
	public void add(Component c) {
		try {
			BeanInfo info = Introspector.getBeanInfo(c.getClass());
			
			EventSetDescriptor[] eventSets = info.getEventSetDescriptors();
			for(EventSetDescriptor eventSet : eventSets) 
				addListener(c, eventSet);
		}
		catch(IntrospectionException e) {
		}
		
		if(c instanceof Container) {
			for(Component comp : ((Container) c).getComponents())
				add(comp);
		}
	}
	
	/**
	 * Add a listener to the given event set
	 * @param c acomponent
	 * @param eventSet a descriptor of a listener interface
	 */
	public void addListener(Component c, EventSetDescriptor eventSet) {
		//		Ϊ������������ʹ����������
		Object proxy = Proxy.newProxyInstance(null, new Class[] { eventSet.getListenerType() }, handler);
		
		/*
		 * newProxyInstance(ClassLoader loader, class<?>[] interfaces, InvocationHandler h)
		 * ���� : loader - ������������������  interfaces - ������ʵ�ֵĽӿ��б�  h - ���ȷ������õĵ��ô����� 
		 * ����: ������ָ��������������岢ʵ��ָ���ӿڵĴ������ָ�����ô������Ĵ���ʵ��
		 */
		Method addListenerMethod = eventSet.getAddListenerMethod();
//		�����������¼��������ķ���
		
		try {
			addListenerMethod.invoke(c, proxy);
//			�Դ���ָ��������ָ����������ɴ� Method �����ʾ�ĵײ㷽��
		}
		catch(ReflectiveOperationException e) {
		}
	}
}
