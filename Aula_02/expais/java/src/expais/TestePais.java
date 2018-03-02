package expais;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestePais {
	Pais pais, copia;
	static int id = 0;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		pais = new Pais(id, "Alemanha", 123456,654321);
		copia = new Pais(id, "Alemanha", 123456,654321);
		System.out.println(pais);
		System.out.println(copia);
		System.out.println(id);;
		
	}
	
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		//para funcionar o cliente 1 deve ter sido carregado no banco por fora
		Pais fixture = new Pais(3, "Japão",126730000, 377873 );
		Pais novo = new Pais(3, null, 0, 0);
		novo.carregar();
		assertEquals("testa inclusao", novo.getId(), fixture.getId());
	}
	

	@Test
	public void test01Criar() {
		System.out.println("Criar" + "\n-------------");
		pais.criar();
		id = pais.getId();
		copia.setId(id);
		assertEquals("testa criacao", pais.getId(), copia.getId());
	}
	
	@Test
	public void test02Atualizar() {
		System.out.println("Atualizar" + "\n-------------");
		pais.setNome("qualquer coisa");
		copia.setNome("qualquer coisa");
		
		pais.atualizar();
		pais.carregar();
		assertEquals("testa atualizacao", pais.getNome(), copia.getNome());
	}
	
	@Test
	public void test03Excluir() {
		System.out.println("Excluir" + "\n-------------");
		
		copia.setId(-1);
		copia.setNome(null);
		copia.setPopulacao(0);
		copia.setArea(0);
		
		pais.excluir();
		pais.carregar();
		
		assertEquals("testa exclusao", pais.getId(), copia.getId());
	}
	
	@Test
	public void test04MaiorPop() {
		System.out.println("Maior populacao");
		pais.maiorPopulacao();
		long populacao = pais.getPopulacao();
		
		copia.setPopulacao(populacao);
		
		assertEquals("Testando maior populacao",pais.getPopulacao(),copia.getPopulacao());
}
	
	@Test
	public void test05MenorArea() {
		System.out.println("Menor Area");
		pais.menorArea();
		double area = pais.getArea();
		
		copia.setArea(area);
		
	
		
	}
	
	public void test06Array() {
		System.out.println("Vetor de 3 paises");
		String[] vet = pais.vetorTresPaises();
		assertEquals("Testando Vetor de paises",vet.length,3);
	}

	
	




}
