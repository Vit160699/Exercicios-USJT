package service;

import model.Pais;
import dao.PaisDAO;

public class PaisService {
	
		PaisDAO dao = new PaisDAO();
		
		public int criar(Pais pais) {
			return dao.criar(pais);
		}
		
		public void atualizar(Pais pais){
			dao.atualizar(pais);
		}
		
		public void excluir(int id){
			dao.excluir(id);
		}
		
		public Pais carregar(Pais pais){
			return dao.carregar(pais);
		}
		
		public void maiorPopulacao(Pais pais){
			dao.maiorPopulacao(pais);
		}
		
		public void menorArea(Pais pais){
			dao.menorArea(pais);
		}
		

	}



