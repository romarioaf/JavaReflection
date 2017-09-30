package br.com.javareflection.validador;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.javareflection.model.Pessoa;

public class ValidadorTest {

	@Test
	public void deveriaValidarObjeto() {
		try {
			
			List<String> erros = Validador.valida(dadoUmaPessoaValida());
			Assert.assertEquals("Validação do objeto", 0, erros.size());
			
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deveriaInvalidarObjeto() {
		try {
			
			List<String> erros = Validador.valida(dadoUmaPessoaInvalida());
			Assert.assertEquals("Validação do objeto", 1, erros.size());
			
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	private Pessoa dadoUmaPessoaValida() {
		Pessoa p = new Pessoa();
		p.setNome("João");
		p.setIdade(20);
		
		return p;
	}
	
	private Pessoa dadoUmaPessoaInvalida() {
		Pessoa p = new Pessoa();
		p.setNome("João");
		p.setIdade(null);
		
		return p;
	}

}
