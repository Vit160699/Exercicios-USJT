package exfiguras;

public abstract class Figura {
	private String nome;
	private double raio;
	
	
	public abstract double area();
	
	public abstract double perimetro();
	
		public Figura(String nome) {
			this.setNome(nome);
		
		}

			public String getNome() {
				return nome;
			}
		
			public void setNome(String nome) {
				this.nome = nome;
			}

			public double getRaio() {
				return raio;
			}

			public void setRaio(double raio) {
				this.raio = raio;
			}

}
