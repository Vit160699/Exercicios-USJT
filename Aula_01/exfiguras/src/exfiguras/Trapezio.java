package exfiguras;

public class Trapezio extends Poligono{
	private double basemaior, lado;
	
	public Trapezio(String nome, double base, double altura, double basemaior, double lado) {
		super(nome, base, altura);
		this.basemaior = basemaior;
		this.lado = lado;
	}
	
	@Override 
	public double area(){
		return getBasemaior() + getBase() * getAltura();
	}
	
	@Override
	public double perimetro(){
		return 2 * getLado() + getBasemaior() + getBase(); 
	}
	
	private double getBasemaior() {
		return basemaior;
	}
	
	public double getLado() {
		return lado;
	}

}
