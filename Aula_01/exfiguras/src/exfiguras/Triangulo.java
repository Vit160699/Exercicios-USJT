package exfiguras;

public class Triangulo extends Poligono{
	
	public Triangulo(String nome, double base, double altura) {
		super(nome, base, altura);
	
	}
	
	@Override 
	public double area(){
		return getBase() * getAltura() / 2;
	}
	
	@Override
	public double perimetro(){
		return 3 * getBase();
	}

}
