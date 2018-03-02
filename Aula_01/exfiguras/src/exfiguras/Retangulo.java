package exfiguras;

//GENERALIZAÇÃO = BASE X ALTURA
public class Retangulo extends Poligono implements Diagonal {
	
	public Retangulo(String nome, double base, double altura) {
		super(nome, base, altura);
	}
	
		@Override 
		public double area(){
			return getBase() * getAltura();
		}
		
		@Override
		public double calcDiagonal(){
			return Math.sqrt(Math.pow(getAltura(), 2)+ Math.pow(getBase(), 2));
		}
		
		@Override
		public double perimetro(){
			return 2 * getBase() + 2 * getAltura();
		}	
}
