package br.com.javareflection.testador;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Testador {
	
	public static void invocaTestes(Object o) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Class<?> clazz = o.getClass();
		
		for (Method m: clazz.getMethods()) {
			if(m.getName().startsWith("test") 
					&& m.getReturnType() == void.class
					&& m.getParameterTypes().length == 0) {
				
				m.invoke(o);
			}
		}
	}
}
