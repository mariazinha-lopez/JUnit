package carrinho;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import junit.framework.AssertionFailedError;
import produto.Produto;
import produto.ProdutoNaoEncontradoException;

@DisplayName("Classe para teste do carinho")
public class CarrinhoTest {

	private Carrinho car;
	private Carrinho car2;
	private Produto borracha;
	private Produto caneta;
	private Produto lapiseira;
	private Produto caderno;
	private Produto lumicolor;

	@BeforeEach
	public void inicializa() {
		borracha = new Produto("Faber-Castell borracha", 5.20);
		caneta = new Produto("Caneta ponta 0.5 Unibol", 3.10);
		lapiseira = new Produto("Lapiseira Pentel ponta 0.7", 6.00);
		caderno = new Produto("Caderno Tilibra Universtário", 16.00);
		lumicolor = new Produto("Lumicolor Kit - Cor: Amarela", 2.30);
		car = new Carrinho();
		car2 = new Carrinho();
		car.addItem(borracha);
		car.addItem(caneta);
		car.addItem(lapiseira);
		
	}

	@Test
	public void testCalculaValTotalCarrinho() {
		double total = car.getValorTotal();
		assertEquals(14.30, total);
	}

	@Test
	public void testInsercaoElementoCarrinho() {
		car.addItem(lumicolor);
		assertTrue(car.getItem(car.getQtdeItems()-1)==lumicolor);
		System.out.println("Produto Inserido com sucesso!");
		
		}

	@Test
	public void testRemocaoElementoCarrinho() {
		try {
			car.removeItem(caneta);
			System.out.print("Produto removido com sucesso!");
		} catch (ProdutoNaoEncontradoException e) {
			assertEquals(null, e.getMessage());
		}
	}
	  
	@Test
	public void testCarrinhoVazio(){
		car.esvazia();
		assertTrue(car.getQtdeItems()==0);	  
	 }
	  
	
	@Test
	public void testQtdeItemsTotal() {
		car.addItem(caneta);
		car.addItem(lumicolor);
		car.addItem(lumicolor);
		assertEquals(car.getQtdeItems(), 6);
	}
	
	@Test
	public void testVerificarCarinhos() {
		for (int i=0; i<car.getQtdeItems(); i++) {
			car2.addItem((Produto) car.getItem(i));
		}
		///car2.addItem(borracha);
		assertArrayEquals(car2.getAllItems(), car.getAllItems(), "Carrinhos diferentes");
	}
}