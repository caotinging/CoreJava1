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
	 * InvocationHandler 是代理实例的调用处理程序 实现的接口。 
	 * 每个代理实例都具有一个关联的调用处理程序。
	 * 对代理实例调用方法时，将对方法调用进行编码并将其指派到它的调用处理程序的 invoke 方法
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
		//		为这个监听器类型创建代理对象
		Object proxy = Proxy.newProxyInstance(null, new Class[] { eventSet.getListenerType() }, handler);
		
		/*
		 * newProxyInstance(ClassLoader loader, class<?>[] interfaces, InvocationHandler h)
		 * 参数 : loader - 类加载器来定义代理类  interfaces - 代理类实现的接口列表  h - 调度方法调用的调用处理函数 
		 * 返回: 具有由指定的类加载器定义并实现指定接口的代理类的指定调用处理程序的代理实例
		 */
		Method addListenerMethod = eventSet.getAddListenerMethod();
//		获得用来添加事件侦听器的方法
		
		try {
			addListenerMethod.invoke(c, proxy);
//			对带有指定参数的指定对象调用由此 Method 对象表示的底层方法
		}
		catch(ReflectiveOperationException e) {
		}
	}
}
