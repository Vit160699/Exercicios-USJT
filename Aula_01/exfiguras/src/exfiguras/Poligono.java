package exfiguras;

public abstract class Poligono extends Figura {
	private double base,altura;

	
	public Poligono(String nome, double base, double altura){
	super(nome);
	this.setBase(base);
	this.setAltura(altura);
	}


		public double getBase() {
			return base;
		}
	
	
		public void setBase(double base) {
			this.base = base;
		}
	
	
		public double getAltura() {
			return altura;
		}
	
	
		public void setAltura(double altura) {
			this.altura = altura;
		}

}
