/**
 * 
 */
package br.com.projeto.cadastro.cliente;

import javax.swing.JOptionPane;

import br.com.projeto.cadastro.cliente.classes.Cliente;
import br.com.projeto.cadastro.cliente.dao.ClienteMapDAO;
import br.com.projeto.cadastro.cliente.dao.IClienteDAO;

/**
 * @author marce
 *
 */
public class App {

	/**
	 * @param args
	 */
	private static IClienteDAO iClienteDAO;
	
	public static void main(String[] args) {
		iClienteDAO = new ClienteMapDAO();
		
		String opcao = JOptionPane.showInputDialog(null, 
				"Insira um número:\n 1 = cadastro\n 2 = consultar\n 3 = exclusão\n 4 = alteração\n 5 = sair",
				"Programa de Cadastro", JOptionPane.INFORMATION_MESSAGE);
		
		while(!isOpcaoValida(opcao)) {
			if("".equals(opcao)) {
				sair();
			}
			
			opcao = JOptionPane.showInputDialog(null, 
					"Insira um número:\n 1 = cadastro\n 2 = consultar\n 3 = exclusão\n 4 = alteração\n 5 = sair",
					"Programa de Cadastro", JOptionPane.INFORMATION_MESSAGE);
		}
		
		while (isOpcaoValida(opcao)) {
			if(isOpcaoSair(opcao)) {
				sair();
			}else if(isCadastro(opcao)) {
				String dados = JOptionPane.showInputDialog(null,
						"Digite os dados do cliente separados por vírgula: nome, cpf, tel, endereço, numero, cidade, estado",
						"Programa de Cadastro", JOptionPane.INFORMATION_MESSAGE);
				cadastrar(dados);
			}else if(isConsultar(opcao)){
				String dados = JOptionPane.showInputDialog(null,
						"Digite o cpf",
						"Programa de Cadastro", JOptionPane.INFORMATION_MESSAGE);
				
				consultar(dados);
			}
			opcao = JOptionPane.showInputDialog(null, 
					"Insira um número:\n 1 = cadastro\n 2 = consultar\n 3 = exclusão\n 4 = alteração\n 5 = sair",
					"Programa de Cadastro", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private static void consultar(String dados) {
		Cliente cliente = iClienteDAO.consultar(Long.parseLong(dados));
		if(cliente != null) {
			JOptionPane.showMessageDialog(null, "Cliente Encontrado" + cliente.toString().trim() , "Consulta", JOptionPane.INFORMATION_MESSAGE);

		}
		JOptionPane.showMessageDialog(null, "Cliente não Encontrado", "Consulta", JOptionPane.INFORMATION_MESSAGE);

		
	}

	private static boolean isConsultar(String opcao) {
		if("2".equals(opcao)) {
			return true;
		}
		return false;
		
	}

	private static void cadastrar(String dados) {
		String[] dadosSeparados = dados.split(",");
		Cliente cliente = new Cliente(dadosSeparados[0], null, null, dadosSeparados[3], null, dadosSeparados[5], dadosSeparados[6]);
		Boolean isCadastrado = iClienteDAO.cadastrar(cliente);
		if(isCadastrado != null) {
			JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "Cliente ja registrado", "Erro", JOptionPane.INFORMATION_MESSAGE);

		}
	}

	private static boolean isCadastro(String opcao) {
		if("1".equals(opcao)) {
			return true;
		}
		return false;
	}

	private static boolean isOpcaoSair(String opcao) {
		if("5".equals(opcao)) {
			return true;
		}
		return false;
	}

	private static void sair() {
		JOptionPane.showMessageDialog(null, "Goodbye" , "SAIR", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
		
	}

	private static boolean isOpcaoValida(String opcao) {
		if("1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao)  || "4".equals(opcao) || "5".equals(opcao)) {
			return true;
		}
		return false;
	}

	private static boolean isOpcaoCadastro(String opcao) {
		if("1".equals(opcao)) {
			return true;
		}
		return false;
	}

}
