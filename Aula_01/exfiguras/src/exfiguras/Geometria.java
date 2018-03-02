package exfiguras;

import java.util.ArrayList;

public class Geometria {
	public static void main(String[] args) {
		
		Figura circulo = new Circulo ("   Circulo", 4.0);
		Figura losango = new Losango ("   Losango", 3.0, 2.0);
		Figura retangulo = new Retangulo ("   Retangulo", 5.0, 3.0);
		Figura quadrado = new Quadrado ("   Quadrado", 4.0, 4.0);
		Figura triangulo = new Triangulo("   Triangulo", 3.0, 3.0);
		Figura trapezio = new Trapezio("   Trapezio", 3.0, 4.0,5.0,3.0);
		
		ArrayList<Figura> figuras = new ArrayList<Figura>();
		figuras.add(circulo);
		figuras.add(losango);
		figuras.add(retangulo);
		figuras.add(quadrado);
		figuras.add(triangulo);
		figuras.add(trapezio);
		
		Figura3D cubo = new Cubo("   Cubo",5.0,5.0,5.0,0);
		Figura3D esfera = new Esfera("   Esfera",0,0,0,2.5);
		Figura3D cilindro = new Cilindro("   Cilindro",5.0,0,0,2.0);
		Figura3D piramide = new Piramide("   Pir‚mide",5.0,5.0,3.0,0);
		
		ArrayList<Figura3D> solidos = new ArrayList<Figura3D>();
		solidos.add(cubo);
		solidos.add(esfera);
		solidos.add(cilindro);
		solidos.add(piramide);
	
		
		for(Figura emp:figuras){
			System.out.println(emp.getNome());
			System.out.println( "\n¡rea: " + emp.area());
			System.out.println( "\nPerimetro: " + emp.perimetro());
			if(emp instanceof Diagonal){
				System.out.println("\nDiagonal: " + ((Diagonal)emp).calcDiagonal() + "\n");
			}
			System.out.println("\n----------------------");
				
				
			}
		
		for(Figura3D emp:solidos){
			System.out.println(emp.getNome());
			if(emp instanceof Volume){
				System.out.println("\nVolume: " + ((Volume)emp).volume() + "\n");
			}
			System.out.println("\n----------------------");
				
				
			}
	}

}



