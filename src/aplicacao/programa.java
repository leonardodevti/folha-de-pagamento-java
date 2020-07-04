package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidades.Funcionario;
import entidades.FuncionarioTerceirizado;

/*Uma empresa possui funcion�rios pr�prios e terceirizados.
Para cada funcion�rio, deseja-se registrar nome, horas
trabalhadas e valor por hora. Funcion�rios terceirizado
possuem ainda uma despesa adicional.
O pagamento dos funcion�rios corresponde ao valor da hora
multiplicado pelas horas trabalhadas, sendo que os
funcion�rios terceirizados ainda recebem um b�nus
correspondente a 110% de sua despesa adicional.
Fazer um programa para ler os dados de N funcion�rios (N
fornecido pelo usu�rio) e armazen�-los em uma lista. Depois
de ler todos os dados, mostrar nome e pagamento de cada
funcion�rio na mesma ordem em que foram digitados.
Construa o programa conforme projeto ao lado. Veja
exemplo na pr�xima p�gina.
 * */

public class programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner ent = new Scanner(System.in);

		List<Funcionario> funcionarios = new ArrayList<>();

		System.out.print("Informe o n�mero de funcion�rios: ");
		int n = ent.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Funcion�rio #" + i + " Dados:");
			System.out.print("Terceirizado? (s/n)? ");
			char resp = ent.next().charAt(0);
			System.out.print("Nome: ");
			ent.nextLine();
			String nome = ent.nextLine();
			System.out.print("Horas: ");
			int horas = ent.nextInt();
			System.out.print("Valor por hora: ");
			double valorPorHora = ent.nextDouble();

			if (resp == 's') {//Estrutura de decis�o para o caso de ser um funcion�rio terceirizado, acrescentar uma despesa adicional.
				System.out.print("Despesa Adicional: ");
				double despesaAdicional = ent.nextDouble();
				funcionarios.add(new FuncionarioTerceirizado(nome, horas, valorPorHora, despesaAdicional));
			} else {
				funcionarios.add(new Funcionario(nome, horas, valorPorHora));
			}

		}

		System.out.println("\nPagamentos: ");
		for (Funcionario funcionario : funcionarios) {// imprimindo o nome de cada funcion�rio com seu respectivo pagamento.
			System.out.println(funcionario.getNome() + " - R$ " + String.format("%.2f", funcionario.pagamento()));
		}

		ent.close();
	}

}
