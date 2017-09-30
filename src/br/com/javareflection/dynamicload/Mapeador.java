package br.com.javareflection.dynamicload;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author romario
 */
public class Mapeador {

	private Map<Class<?>, Class<?>> mapa = new HashMap<>();
	
	public void load(String nomeArquivo) throws FileNotFoundException, IOException, ClassNotFoundException {
		Properties p = new Properties();
		p.load(new FileInputStream(nomeArquivo));
		
		for(Object key: p.keySet()) {
			Class<?> interf = Class.forName(key.toString());
			Class<?> impl = Class.forName(p.get(key).toString());
			
			mapa.put(interf, impl);
		}
	}
	
	public Class<?> getImplementacao(Class<?> interf) {
		return mapa.get(interf);
	}
	
	public Object getInstancia(Class<?> interf) throws InstantiationException, IllegalAccessException {
		Class<?> impl = mapa.get(interf);
		return impl.newInstance();
	}
}
