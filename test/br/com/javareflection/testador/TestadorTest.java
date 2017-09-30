package br.com.javareflection.testador;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.lang.reflect.InvocationTargetException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.javareflection.model.Pessoa;

public class TestadorTest {

	@Mock
	private Pessoa pessoa;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void deveriaInvocaDeTestes() {
		try {

			Testador.invocaTestes(pessoa);
			
			verify(pessoa, times(1)).testPessoa();
			
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
