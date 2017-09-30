package br.com.javareflection.dynamicload;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author romario
 */
public class MapeadorTest {

	@Test
	public void testGetImplementacao() {
		Mapeador mapeador = new Mapeador();
		try {
			
			mapeador.load("classes.prop");
			
			Assert.assertNull(mapeador.getImplementacao(ArrayList.class));
			Assert.assertEquals("Retorno implementação", ArrayList.class, mapeador.getImplementacao(List.class));
			
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

}
