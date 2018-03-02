package exfiguras;

public class Cubo extends Figura3D implements Volume{
	
	public Cubo(String nome,double altura, double base,double largura, double raio) {
		super(nome, base, altura,largura, raio);
	}
	
	@Override
	public double volume(){
		return getLargura() * getBase() * getAltura();
	}

}
