package aplicacao;

import javax.swing.JOptionPane;

public class NumbersBetweenWithFOR {

	public static void main(String[] args) {
		int val1 =0, val2=0, dif=0, cont=0;
		String valores = ""; 
		JOptionPane.showMessageDialog(null,"Bem vindo ao programa que te informar� todos os valores inteiros presentes entre dois n�meros! ");
		JOptionPane.showMessageDialog(null,"- Voc� s� pode inputar n�meros inteiros!\n- Voc� s� receber� o resultado se os valores inputados\n tiverem no m�ximo 100 n�meros inteiros de dist�ncia!");
		val1 = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o limite inferior: "));
		val2 = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o limite superior: "));
		dif = val2 - val1;
		if(dif>100) {
			JOptionPane.showMessageDialog(null,"A diferen�a entre os limites � maior do que 100!");
			System.exit(0);
		}else if(dif<0) {
			JOptionPane.showMessageDialog(null,"Input negativo de dados!");
			System.exit(0);
		}else if(dif==0) {
			JOptionPane.showMessageDialog(null,"Os limites informados s�o iguais!");
			System.exit(0);
		}
		else {
			for(int i=val1; i<=val2; i++) {
			 cont += 1;
			 if(valores == "") {
				 valores = String.valueOf(i);
			 }else if(cont == 41){
				 valores = valores+",\n"+String.valueOf(i);
			 }else if(cont == 81){
				 valores = valores+",\n"+String.valueOf(i);
			 }else {
				 valores = valores+", "+String.valueOf(i);
			 }
		 }
			}
			JOptionPane.showMessageDialog(null,"Os n�meros presentes entre "+val1+" e "+val2+" s�o:\n"+valores);
		}
	}


