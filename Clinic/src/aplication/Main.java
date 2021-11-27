package aplication;

import javax.swing.JOptionPane;

import appointment.Appointment;
import entitys.Doctor;
import entitys.Secretary;
import entitys.Pacient;

public class Main {

	public static void main(String[] args) {
		int log=0, ntype=0, ltype=0, logVerificador=0, men=0, op=0, numAtribuicao=0, numPac=0, opSair=0;
		double valor=0;
		String login="", senha="", type="", nome="", admissao="", nasc="", crm="", espc="", dataNasc="", cpfPac="", dataCons="";
		boolean pacCadas=false, logDisp=false;
		MainMethods meth = new MainMethods();
		Doctor[] doctors = new Doctor[10];
		Secretary[] secretary = new Secretary[2];
		Pacient[] pacients = new Pacient[30];
		Appointment[] consultas = new Appointment[30];
		
		JOptionPane.showMessageDialog(null, "Seja bem vindo ao sitema de consult�rio m�dico!\n\n"
				+ " � Limites do sistema:\n"
				+ " - Inscri��o de 10 m�dicos\n"
				+ " - Inscri��o de 2 secret�rios\n"
				+ " - Inscri��o de 30 pacientes\n"
				+ " - Realiza��o de 30 consultas", "Tela de boas vindas", JOptionPane.PLAIN_MESSAGE);
		
		do {
			logVerificador = 0;
			log = Integer.parseInt(JOptionPane.showInputDialog(null, "Realize o seu login! \n"
					+ "1. Login\n"
					+ "2. Inscrever", "Tela de login", JOptionPane.PLAIN_MESSAGE));
			switch (log) {
			case 1:
				ltype = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o tipo de usu�rio: (1-M�dico / 2-Secret�rio) ", "Tipo de login", JOptionPane.PLAIN_MESSAGE));
				if(ltype == 1 ) {
					if(meth.contagemArrayDoc(doctors) == 0) {
						JOptionPane.showMessageDialog(null, "Ainda n�o existem m�dicos cadastrados no sistema!", "Erro", JOptionPane.ERROR_MESSAGE);
						break;
					} else {
						logVerificador = 0;
						while(logVerificador != -1) {
							login = JOptionPane.showInputDialog(null, "Login: ", "Login", JOptionPane.PLAIN_MESSAGE);
							senha = JOptionPane.showInputDialog(null, "Senha: ", "Login", JOptionPane.PLAIN_MESSAGE);
							if(meth.existLogDoc(doctors, login, senha)) {
								logVerificador = -1;
								JOptionPane.showMessageDialog(null, "Login executado com sucesso!", "Login bem sucedido", JOptionPane.INFORMATION_MESSAGE);
							}else {
								int prosseguir = Integer.parseInt(JOptionPane.showInputDialog(null, "Login ou senha erradas!\n"
										+ "- Deseja voltar para o in�cio? digite 1\n"
										+ "- Deseja tentar novamente o login? digite qualquer n�mero com excess�o do n�mero 1","Login mal sucedido", JOptionPane.ERROR_MESSAGE));
								if(prosseguir == 1) {
									break;
								}
							}	
						}
						break;
					}
				} else if(ltype == 2) {
					if(meth.contagemArraySec(secretary) == 0) {
						JOptionPane.showMessageDialog(null, "Ainda n�o existem secret�rios cadastrados no sistema!", "Erro", JOptionPane.ERROR_MESSAGE);
						break;
					}else {
						logVerificador = 0;
						while(logVerificador != -1) {
							login = JOptionPane.showInputDialog(null, "Login: ", "Login", JOptionPane.PLAIN_MESSAGE);
							senha = JOptionPane.showInputDialog(null, "Senha: ", "senha", JOptionPane.PLAIN_MESSAGE);
							if(meth.existLogSec(secretary, login, senha)) {
								logVerificador = -1;
								JOptionPane.showMessageDialog(null, "Login executado com sucesso!", "Login bem sucedido", JOptionPane.INFORMATION_MESSAGE);
							}else {
								int prosseguir = Integer.parseInt(JOptionPane.showInputDialog(null, "Login ou senha erradas!\n"
										+ "- Deseja voltar para o in�cio? digite 1\n"
										+ "- Deseja tentar novamente o login? digite qualquer n�mero com excess�o do n�mero 1","Login mal sucedido", JOptionPane.ERROR_MESSAGE));
								if(prosseguir == 1) {
									break;
								}
							}	
						}
						break;
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "Voc� n�o inseriu um valor v�lido!", "Erro", JOptionPane.ERROR_MESSAGE);
					break;
				}
			case 2:
				ntype = Integer.parseInt(JOptionPane.showInputDialog(null, "Tipo de usu�rio: (1-M�dico / 2-Secret�rio) ", "Cadastro", JOptionPane.PLAIN_MESSAGE));
				nome = JOptionPane.showInputDialog(null, "Nome: ", "Cadastro", JOptionPane.PLAIN_MESSAGE);
				nasc = JOptionPane.showInputDialog(null, "Data de Nascimento: (dd/mm/aa)", "Cadastro", JOptionPane.PLAIN_MESSAGE);
				admissao = JOptionPane.showInputDialog(null, "Data de Admiss�o: (dd/mm/aa)", "Cadastro", JOptionPane.PLAIN_MESSAGE);
				if(ntype == 1) {
					crm = JOptionPane.showInputDialog(null, "CRM: ", "Cadastro", JOptionPane.PLAIN_MESSAGE);
					espc = JOptionPane.showInputDialog(null, "Especialidade: ", "Cadastro", JOptionPane.PLAIN_MESSAGE);
					logDisp = false;
					while(logDisp == false) {
						login = JOptionPane.showInputDialog(null, "Login: ", "Cadastro", JOptionPane.PLAIN_MESSAGE);
						logDisp = !meth.existJustLogDoc(doctors, login);
						System.out.println(logDisp);
						if(!logDisp) {
							JOptionPane.showMessageDialog(null, "Este login n�o est� dispon�vel para cadastro, tente novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
						}
					}					
					senha = JOptionPane.showInputDialog(null, "Senha: ", "Cadastro", JOptionPane.PLAIN_MESSAGE);
					Doctor d = new Doctor(login, senha, nome, admissao, nasc, crm, espc);
					doctors[meth.contagemArrayDoc(doctors)] = d;
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Sucesso", JOptionPane.PLAIN_MESSAGE);
				}else {
					logDisp = false;
					while(logDisp == false){
						login = JOptionPane.showInputDialog(null, "Login: ", "Cadastro", JOptionPane.PLAIN_MESSAGE);
						logDisp = !meth.existJustLogSec(secretary, login);
						if(!logDisp) {
							JOptionPane.showMessageDialog(null, "Este login n�o est� dispon�vel para cadastro, tente novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
						}
					}
					senha = JOptionPane.showInputDialog(null, "Senha: ", "Cadastro", JOptionPane.PLAIN_MESSAGE);
					Secretary s = new Secretary(login, senha, nome, admissao, nasc);
					secretary[meth.contagemArraySec(secretary)] = s;
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Sucesso", JOptionPane.PLAIN_MESSAGE);
				}
				break;
			default:
				break;
			} //Fim do switch do login
			
			
			if(logVerificador == -1) {
				//Inicio da execu��o dos processos de fato
				do {
					if(ltype == 1) {
						op = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha sua op��o:\n"
								+ "1- Realizar atendimento\n"
								+ "2- Verificar sua agenda\n"
								+ "3- Sair", "Menu de op��es", JOptionPane.PLAIN_MESSAGE));
						switch(op) {
						case 1:
							numAtribuicao = Integer.parseInt(JOptionPane.showInputDialog(null, "Indique o n�mero da consulta que ir� realizar:\n"
									+ meth.returnAgendaDoc(consultas, login), "Realizar atendimento!", JOptionPane.PLAIN_MESSAGE));
							meth.removerCons(consultas, numAtribuicao, login);
							meth.realocarCons(consultas);
							JOptionPane.showMessageDialog(null, "Consulta removida do sistema!", "Sucesso!", JOptionPane.PLAIN_MESSAGE);
							break;
						case 2:
							meth.realocarCons(consultas);
							JOptionPane.showMessageDialog(null, meth.returnAgendaDoc(consultas, login), "Verifica��o de agenda", JOptionPane.PLAIN_MESSAGE);
							break;
						case 3:
							opSair = Integer.parseInt(JOptionPane.showInputDialog(null, "Como voc� deseja sair?\n"
									+ "1 - Voltar para o login/cadastro\n"
									+ "2 - Sair do sistema", "Agendamento de consulta", JOptionPane.PLAIN_MESSAGE));
							if(opSair == 1) {
								men = -1;
							}else if(opSair == 2) {
								men = -1;
								log = -1;
							}else {
								JOptionPane.showMessageDialog(null, "Valor inv�lido!", "Erro", JOptionPane.ERROR_MESSAGE);
							}
							break;
						default:
							break;
						
						}
					}else if(ltype==2){
						op = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha sua op��o:\n"
								+ "1- Agendar consulta\n"
								+ "2- Verificar agenda\n"
								+ "3- Verificar m�dicos cadastrados\n"
								+ "4- Sair", "Menu de op��es", JOptionPane.PLAIN_MESSAGE));
						switch(op) {
						case 1:
							if(meth.contagemArrayDoc(doctors) > 0) {
								cpfPac = JOptionPane.showInputDialog(null, "Informe o cpf do clinte para a consulta: ", "Agendamento de consulta", JOptionPane.PLAIN_MESSAGE);
								if(!(meth.existPacCpf(pacients, cpfPac)) || pacients.length == 0) {
									JOptionPane.showMessageDialog(null, "N�o existe nenhum paciente cadastrado no sistema com esse cpf, "
											+ "portanto voc� o cadastrar� agora!", "Agendamento de consulta", JOptionPane.PLAIN_MESSAGE);
									nome = JOptionPane.showInputDialog(null, "Indique o nome do paciente para a consulta:", "Agendamento de consulta", JOptionPane.PLAIN_MESSAGE);
									dataNasc = JOptionPane.showInputDialog(null, "Indique a data de nascimento do paciente para a consulta:", "Agendamento de consulta", JOptionPane.PLAIN_MESSAGE);
									Pacient p = new Pacient(nome, cpfPac, dataNasc);
									pacients[meth.contagemArrayPac(pacients)] = p;
									pacCadas = true;
									numPac = meth.contagemArrayPac(pacients)-1;
									JOptionPane.showMessageDialog(null, "Paciente cadastrado!", "Agendamento de consulta", JOptionPane.PLAIN_MESSAGE);
								}
								dataCons = JOptionPane.showInputDialog(null, "Indique a data que a consulta ser� realizada:", "Agendamento de consulta", JOptionPane.PLAIN_MESSAGE);
								numAtribuicao = Integer.parseInt(JOptionPane.showInputDialog(null, "Indique o m�dico que ir� realizar a consulta:\n\n"
										+ meth.returnAllDoc(doctors), "Agendamento de consulta", JOptionPane.PLAIN_MESSAGE));
								valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Indique o valor dessa consulta: ", "Agendamento de consulta", JOptionPane.PLAIN_MESSAGE));
								if(!pacCadas) {
									numPac = meth.getNumPac(pacients, cpfPac);
								}
								try {
									Appointment apt = new Appointment(doctors[numAtribuicao-1], secretary[meth.getNumSec(secretary, login)], dataCons, pacients[numPac], valor);
									consultas[meth.contagemArrayCons(consultas)] = apt;
									JOptionPane.showMessageDialog(null, "Consulta Agendada no sistema!", "Sucesso", JOptionPane.PLAIN_MESSAGE);
								} catch(Exception e) {
									JOptionPane.showMessageDialog(null, "Erro ao agendar consulta no sistema!", "Erro", JOptionPane.ERROR_MESSAGE);
								}
								
							}else if(meth.contagemArrayDoc(doctors) == 0){
								JOptionPane.showMessageDialog(null, "N�o existem m�dicos cadastrados no sistema para isso!", "Erro", JOptionPane.ERROR_MESSAGE);
								break;
							}
							break;
						case 2:
							if(meth.contagemArrayCons(consultas)>0) {
								JOptionPane.showMessageDialog(null, meth.returnAgenda(consultas), "Agenda", JOptionPane.PLAIN_MESSAGE);
							}else if(meth.contagemArrayCons(consultas)==0){
								JOptionPane.showMessageDialog(null, "N�o existem consultas agendadas para os pr�ximos dias!", "Agenda", JOptionPane.PLAIN_MESSAGE);
							}
							
							break;
						case 3:
							if(meth.contagemArrayDoc(doctors)>0) {
								JOptionPane.showMessageDialog(null, meth.returnAllDoc(doctors), "M�dicos", JOptionPane.PLAIN_MESSAGE);
							}else if(meth.contagemArrayDoc(doctors)==0){
								JOptionPane.showMessageDialog(null, "Ainda n�o existem m�dicos cadastrados no sistema!", "M�dicos", JOptionPane.ERROR_MESSAGE);
							}
							break;
						case 4:
							opSair = Integer.parseInt(JOptionPane.showInputDialog(null, "Como voc� deseja sair?\n"
									+ "1 - Voltar para o login/cadastro\n"
									+ "2 - Sair do sistema", "Agendamento de consulta", JOptionPane.PLAIN_MESSAGE));
							if(opSair == 1) {
								men = -1;
							}else if(opSair == 2) {
								men = -1;
								log = -1;
							}else {
								JOptionPane.showMessageDialog(null, "Valor inv�lido!", "Erro", JOptionPane.ERROR_MESSAGE);
							}
							break;
						default:
							break;
						}
					}else {
						JOptionPane.showInputDialog(null, "Erro!","ERRO", JOptionPane.ERROR_MESSAGE);
					}
					
				} while(men != -1);
				men = 0;
			}
			
		} while(log != -1);
		
		

	}

}
