package Calculadora;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class App {

	private static float resultado;

	public static void main(String[] args) {

		try {

			while (true) {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				Float operador1 = 0f;
				Float operador2 = 0f;
				Integer opcao = 0;
				
				try {
					
					operador1 = Float.parseFloat(JOptionPane.showInputDialog("Digite o valor do operador 1: "));
					
					if(operador1 == 0)
						throw new IllegalArgumentException("O operador 1 não pode ser 0");
					
					operador2 = Float.parseFloat(JOptionPane.showInputDialog("Digite o valor do operador 2: "));
					opcao = Integer.parseInt(JOptionPane.showInputDialog("Opções de operação: 1(+) 2(-) 3(/) 4(*)"));
					
					if(opcao <= 0 || opcao > 4)
						throw new IllegalArgumentException("Escolha apenas as operações de 1 a 4");
					
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "ERRO: " + "Somente é permitido números", "Erro", JOptionPane.ERROR_MESSAGE);
					continue;
				} catch (IllegalArgumentException e) {
					JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
					continue;
				}				

				switch (opcao) {
				case 1:
					resultado = new Calculadora().somar(operador1, operador2);
					break;
				case 2:
					resultado = new Calculadora().subtrair(operador1, operador2);
					break;
				case 3:
					resultado = new Calculadora().dividir(operador1, operador2);
					break;
				case 4:
					resultado = new Calculadora().multiplicar(operador1, operador2);
					break;

				default:
					break;
				}

				JOptionPane.showMessageDialog(null, "O resultado da operação é : " + resultado, "Mensagem",
						JOptionPane.INFORMATION_MESSAGE);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

}
