package exfiguras;

public abstract class Figura3D {
	
	private String nome;
	private double raio,base,altura,largura;
	
	
	
	//public abstract double area();
	
	//public abstract double perimetro();
	
	
		public Figura3D (String nome, double base, double altura,double largura, double raio) {
			this.setNome(nome);
			this.setBase(base);
			this.setAltura(altura);
			this.setRaio(raio);
			this.setLargura(largura);
		
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

			public double getAltura() {
				return altura;
			}

			public void setAltura(double altura) {
				this.altura = altura;
			}

			public double getBase() {
				return base;
			}

			public void setBase(double base) {
				this.base = base;
			}

			public double getLargura() {
				return largura;
			}

			public void setLargura(double largura) {
				this.largura = largura;
			}

}


