package exfiguras;

//GENERALIZAÇÃO = BASE X ALTURA
public class Quadrado extends Poligono implements Diagonal{
	
	public Quadrado(String nome, double base, double altura) {
		super(nome, base, altura);
	
	}
	
	@Override
	public double area(){
		return getBase() * getAltura();
	}
	
	@Override
	public double calcDiagonal(){
		return getBase() * Math.sqrt(2);
	}
	
	@Override
	public double perimetro(){
		return 2 * getBase() + 2 * getAltura();
	}

}
