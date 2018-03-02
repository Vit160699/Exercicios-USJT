package exfiguras;

//GENERALIZAÇÃO = BASE X ALTURA
public class Losango extends Poligono {
	
	public Losango(String nome, double base, double altura){
		super(nome, base, altura);
	}
	
	@Override
	public double area(){
		return getBase() * getAltura();
	}
	
	@Override
	public double perimetro(){
		return 4 * getBase();
	}

}
