package oracleExercises;

import java.util.Scanner;

public class convertLitro {

	public static void main(String[] args) {
		int qtdGal=0;
		double qtdLit=0.0;
		Scanner s = new Scanner(System.in);
		
		System.out.println("Bem vindo ao sistema que converter� a quantidade de agu� em gal�es para litros!");
		System.out.print("Digite a sua quantidade de gal�es: ");
		qtdGal = s.nextInt();
		
		qtdLit = qtdGal*3.785;
		
		System.out.println(qtdGal+" gal�es s�o equivalentes a "+qtdLit+" litros!");
		
		s.close();

	}

}
