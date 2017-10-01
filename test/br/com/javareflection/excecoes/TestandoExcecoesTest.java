package br.com.javareflection.excecoes;

import org.junit.Assert;
import org.junit.Test;

import br.com.javareflection.model.Pessoa;

public class TestandoExcecoesTest {

//	@Rule
//	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void deveriaNaoEncontrarMetodoParaInvocacao() {
//		thrown.expect(NoSuchMethodException.class);
//		thrown.expectMessage("br.com.javareflection.model.Pessoa.testPessoaw()");

		try {
			TestandoExcecoes.executaMetodo(new Pessoa(), "testPessoaw");
		} catch (NoSuchMethodException e) {
			Assert.assertTrue(true);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
	}
	
	@Test
	public void deveriaExecutarMetodoInvocado() {

		try {
			TestandoExcecoes.executaMetodo(new Pessoa(), "testPessoa");
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
	}

}
