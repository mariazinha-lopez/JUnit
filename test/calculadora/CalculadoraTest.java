package calculadora;


import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
//	@DisplayName("Testa a soma de dois números")
//	@Test
//	public void testSomaDoisNumeros() {
//		int soma = calc.soma(4, 5);		
//		Assertions.assertEquals(9, soma);		
//	}
//	
//	@Test
//	public void testDivisaoDoisNumeros() {
//		int divisao = calc.divisao(8, 4);
//		assertTrue(divisao == 2);
//	}
//	
//	@Test
//	public void testDivisaoPorZero() {
//		try {
//			int divisao = calc.divisao(8, 0);
//			fail("Exceção não lançada");
//		}catch (ArithmeticException e) {
//			assertEquals("/ by zero", e.getMessage());
//		}		
//	}
//	
//	@Test
//	public void testDivisaoPorZeroComAssertThrows() {
//		assertThrows(ArithmeticException.class,
//				() -> calc.divisao(8, 0));
//	}
//	
//==========================================================================================

	@Test
	public void testSubtracaoDoisNumerosResultNegativo() {
		int sub = calc.subtracao(2, 9);		
		Assertions.assertEquals(-7, sub);		
	}
	
	@Test
	public void testMultiplicacaoDoisNumeros() {
		int mult = calc.multiplicacao(2, 3);
		assertTrue(mult == 6);
	}
	
	@Test
	public void assertionSomaEMultiplicacaoComHamcrestMatcher() {
		assertThat(calc.multiplicacao(3,0), equalTo(0));
		assertThat(calc.multiplicacao(90, 0), equalTo(0));
	}
	
	@Test
	public void testMultiplicacaoPorOperacoesSoma() {
		int a,b,q,r,result;
		a=2;
		b=5;
		q = calc.divisao(b, 2);
		r = b%2;
		result = 0;
		for (int i=0; i<=q;i++) {
			result += a;
		}
		if (r != 0){
			for (int i=0; i<=r;i++) {
				result += a;
			}
		}
		assertFalse(calc.multiplicacao(a, b) != result);		
	}
		
	@Test
	public void testNumeroPositivo() {
		int a=7;
		assertTrue(calc.ehPositivo(a));
	}
	
	@Test
	public void testSomatorio() {
		assertEquals(calc.somatoria(12), 78);
	}
	
	@Test
	public void testSomatorioNumeroNegativo() {
		assertEquals(calc.somatoria(-12), 0);
	}
	
	@Test
	public void testComparacao() {
		int a,b;
		b = 0;
		a = 4;
		assertFalse(calc.compara(a, b) == 0);
	}
	
	@Test
	public void testComparacaoNumerosComMesmaReferencia() {
		int a,b,c;
		b = c = 0;
		a = 4;
		assertSame(calc.compara(a, c), calc.compara(a, b));
	}
	
	@Test
	public void testComparacaoNumerosNegativoPositivo() {
		int a,b;
		b = 2;
		a = -24;
		assertEquals(calc.compara(a, b), -1);
	}
	
	@Test
	public void testDivisaoDivisorNegativo() {
		
		System.out.print(calc.divisao(5, 22));
	}
	
	@Test
	public void testDivisaoDivisorZero() {
			try{
				calc.divisao(1,0);
				}catch (ArithmeticException msgErro) {
					msgErro = assertThrows(
							ArithmeticException.class,
							() -> { throw new ArithmeticException("/by zero"); });
					assertEquals("/by zero", msgErro.getMessage());
					}
			}
	}
