package exfiguras;

public class Piramide extends Figura3D implements Volume{
	
	public Piramide(String nome,double altura, double base,double largura, double raio) {
		super(nome, base, altura, largura, raio);
		
	}

		
		@Override
		public double volume(){
			return getLargura() * getBase() * getAltura() * 1/3;
		}
}
