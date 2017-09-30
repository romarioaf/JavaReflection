package br.com.javareflection.validador;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Validador {

	public static List<String> valida(Object o) throws IllegalArgumentException, IllegalAccessException {
		List<String> listaInvalidos = new ArrayList<>();
		Class<?> clazz = o.getClass();

		for (Field field : clazz.getDeclaredFields()) {
			field.setAccessible(true);
			Object value = field.get(o);
			
			if (value == null) {
				listaInvalidos.add(field.getName());
			}
		}
		
		return listaInvalidos;
	}
}
