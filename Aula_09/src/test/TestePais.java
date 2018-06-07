package test;

import static org.junit.Assert.assertEquals;
import model.Pais;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import service.PaisService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestePais {
	Pais pais, copia;
	PaisService paisService;
	static int id = 0;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		pais = new Pais();
		pais.setId(id);
		pais.setNome("Brasil");
		pais.setPopulacao(17100475);
		pais.setArea(9000.0);
		copia = new Pais();
		copia.setNome("Brasil");
		copia.setPopulacao(17100475);
		copia.setArea(9000.0);
		paisService = new PaisService();

		System.out.println(pais);
		System.out.println(copia);
		System.out.println(id);;
		
	}
	
	/*@Test
	public void test00Carregar() {
		System.out.println("carregar");
		//para funcionar o cliente 1 deve ter sido carregado no banco por fora
		Pais fixture = new Pais();

		fixture.setId(-1);
		fixture.setNome("Carlos Drummond de Andrade");
		pais.setPopulacao(654321);
		pais.setArea(9999.0);
		PaisService novoService = new PaisService();
		Pais novo = novoService.carregar(5);
		assertEquals("testa inclusao", novo.getId(), fixture.getId());
	}*/
	

	@Test
	public void test01Criar() {
		System.out.println("Criar" + "\n-------------");
		id = paisService.criar(pais);
		System.out.println(id);
		copia.setId(id);
		assertEquals("testa criacao", pais.getId(), copia.getId());
	}
	
/*	@Test
	public void test02Atualizar() {
		System.out.println("Atualizar" + "\n-------------");
		pais.setNome("Tanto faz");
		copia.setNome("Tanto faz");		
		paisService.atualizar(pais);
		pais = paisService.carregar(pais.getId());
		assertEquals("testa atualizacao", pais.getNome(), copia.getNome());
	}*/
	
/*	@Test
	public void test03Excluir() {
		System.out.println("Excluir" + "\n-------------");

		copia.setId(-1);
		copia.setNome(null);
		copia.setPopulacao(0);
		copia.setArea(0);
		
		paisService.excluir(id);
		pais = paisService.carregar(id);
		
		assertEquals("testa exclusao", pais.getId(), copia.getId());
	}*/
	
	/*@Test
	public void test04MaiorPop() {
		System.out.println("Maior populacao");
		paisService.maiorPopulacao(pais);
		long populacao = pais.getPopulacao();
		copia.setPopulacao(populacao);
		assertEquals("Testando maior populacao",pais.getPopulacao(),copia.getPopulacao());
		System.out.println(pais.toString());
}
	
	@Test
	public void test05MenorArea() {
		System.out.println("Menor Area");
		paisService.menorArea(pais);
		double area = pais.getArea();
		copia.setArea(area);
		System.out.println(pais.toString());
		assertEquals("Testando menor area",pais.getPopulacao(),copia.getPopulacao());
		
	
		
	}
	
	@Test
	public void teste7() {
		System.out.println("Vetor de paises");
		String[] array = paisService.vetorTresPaises();
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		assertEquals("Testando Vetor de paises",array.length,3);
}*/
	




}