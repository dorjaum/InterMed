package br.com.exame;


import org.junit.Assert;
import org.junit.Test;

import br.com.exame.utils.ValidadorUtils;

public class ValidadorUtilsTest {

	@Test
	public void testaValidadorCpf(){
		Assert.assertTrue("Deveria ser valido.", ValidadorUtils.isCpfValido("063.161.559-80"));
		Assert.assertTrue("Deveria ser valido.", ValidadorUtils.isCpfValido("06316155980"));
		
		Assert.assertFalse("Deveria ser invalido.", ValidadorUtils.isCpfValido("45.245.781/0001-12"));
		Assert.assertFalse("Deveria ser valido.", ValidadorUtils.isCpfValido("0631615598"));
	}
	
	@Test
	public void testaValidadorCnpj(){
		Assert.assertTrue("Deveria ser valido.", ValidadorUtils.isCnpjValido("45.245.781/0001-12"));
		Assert.assertTrue("Deveria ser valido.", ValidadorUtils.isCnpjValido("45245781000112"));
		
		Assert.assertFalse("Deveria ser invalido.", ValidadorUtils.isCnpjValido("06.161.559-80"));
		Assert.assertFalse("Deveria ser invalido.", ValidadorUtils.isCnpjValido("4524578100011"));
	}
}
