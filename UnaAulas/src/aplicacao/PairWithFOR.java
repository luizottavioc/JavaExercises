package aplicacao;

import javax.swing.JOptionPane;

public class PairWithFOR {

	public static void main(String[] args) {
		int val1 =0, val2=0, dif=0, cont=0;
		String valores = "";
		JOptionPane.showMessageDialog(null,"Bem vindo ao Programa que te informar� todos os n�meros pares presentes entre dois n�meros! ");
		JOptionPane.showMessageDialog(null,"- Voc� s� pode inputar n�meros inteiros!\n- Voc� s� receber� o resultado se os valores inputados\n tiverem no m�ximo 100 n�meros inteiros de dist�ncia!");
		val1 = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o primeiro n�mero: "));
		val2 = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o segundo n�mero: "));
		dif = val2 - val1;
		if(dif>100) {
			JOptionPane.showMessageDialog(null,"A diferen�a entre os n�meros � maior do que 100!");
			System.exit(0);
		}else if(dif<0) {
			JOptionPane.showMessageDialog(null,"Input negativo de dados!");
			System.exit(0);
		}else if(dif==0) {
			JOptionPane.showMessageDialog(null,"Os n�meros informados s�o iguais!");
			System.exit(0);
		}
		else {
			for(int i=val1; i<=val2; i++) {
				 if(i % 2 == 0) {
					 cont += 1;
					 if(valores == "") {
						 valores = String.valueOf(i);
					 }else if(cont == 20){
						 valores = valores+",\n"+String.valueOf(i);
					 }else if(cont == 40){
						 valores = valores+",\n"+String.valueOf(i);
					 }else {
						 valores = valores+", "+String.valueOf(i);
					 }
				 }
			}
			JOptionPane.showMessageDialog(null,"Os n�meros pares presentes entre "+val1+" e "+val2+" s�o:\n"+valores);
		}
	}
}
