package exfiguras;

public class Circulo extends Figura{
		
	
	public Circulo(String nome, double raio) {
		super(nome);
		this.setRaio(raio);
		
	}

	
	@Override
	public double area(){
		return Math.PI + Math.pow(getRaio(), 2);
	}
	
	@Override
	public double perimetro(){
		return 2 * Math.PI * getRaio();
	}
	


		

	

}
