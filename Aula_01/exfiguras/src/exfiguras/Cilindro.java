package exfiguras;

public class Cilindro extends Figura3D implements Volume{
	
	public Cilindro(String nome,double altura, double base,double largura, double raio) {
		super(nome, base, altura, largura, raio);
	}
	
	@Override
	public double volume(){
		return Math.PI * Math.pow(getRaio(), 3) * getAltura();
	}

}
