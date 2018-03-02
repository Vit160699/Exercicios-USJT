package exfiguras;

public class Esfera extends Figura3D implements Volume{
	
	public Esfera(String nome,double altura, double base,double largura, double raio) {
		super(nome, base, altura, largura, raio);
		
	}
	
	@Override
	public double volume(){
		return 4/3 * Math.PI * Math.pow(getRaio(), 3);
	}
	

}
