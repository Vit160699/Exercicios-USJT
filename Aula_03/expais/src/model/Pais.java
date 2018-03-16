package model;

import java.io.Serializable;


public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;
	
		private int id;
		private String nome;
		private long populacao;
		private double area;
		
		public Pais() {
		}
	
		public int getId() {
			return id;
		}
		
		public String getNome() {
			return nome;
		}
		
		public long getPopulacao() {
			return populacao;
		}
		
		public double getArea() {
			return area;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public void setPopulacao(long populacao) {
			this.populacao = populacao;
		}
		
		public void setArea(double area) {
			this.area = area;
		}
		
		@Override
		public String toString() {
			return "Id= " + id + ", \nNome= " + nome + "\nPopulacao= " + populacao
					+ "\nArea= " + area + "\n-------------";
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pais other = (Pais) obj;
			if (nome == null) {
				if (other.nome != null)
					return false;
			} else if (!nome.equals(other.nome))
				return false;
			return true;
		}

		
			


		
		
		
		


		
		





		
}		