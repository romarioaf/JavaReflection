package br.com.javareflection.excecoes;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestandoExcecoes {

	public static void executaMetodo(Object o, String m) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Class<?> clazz = o.getClass();
		Method metodo = clazz.getDeclaredMethod(m);
		metodo.invoke(o);
		
	}
	
}
