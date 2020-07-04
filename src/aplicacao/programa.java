package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidades.Funcionario;
import entidades.FuncionarioTerceirizado;

/*Uma empresa possui funcionários próprios e terceirizados.
Para cada funcionário, deseja-se registrar nome, horas
trabalhadas e valor por hora. Funcionários terceirizado
possuem ainda uma despesa adicional.
O pagamento dos funcionários corresponde ao valor da hora
multiplicado pelas horas trabalhadas, sendo que os
funcionários terceirizados ainda recebem um bônus
correspondente a 110% de sua despesa adicional.
Fazer um programa para ler os dados de N funcionários (N
fornecido pelo usuário) e armazená-los em uma lista. Depois
de ler todos os dados, mostrar nome e pagamento de cada
funcionário na mesma ordem em que foram digitados.
Construa o programa conforme projeto ao lado. Veja
exemplo na próxima página.
 * */

public class programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner ent = new Scanner(System.in);

		List<Funcionario> funcionarios = new ArrayList<>();

		System.out.print("Informe o número de funcionários: ");
		int n = ent.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Funcionário #" + i + " Dados:");
			System.out.print("Terceirizado? (s/n)? ");
			char resp = ent.next().charAt(0);
			System.out.print("Nome: ");
			ent.nextLine();
			String nome = ent.nextLine();
			System.out.print("Horas: ");
			int horas = ent.nextInt();
			System.out.print("Valor por hora: ");
			double valorPorHora = ent.nextDouble();

			if (resp == 's') {//Estrutura de decisão para o caso de ser um funcionário terceirizado, acrescentar uma despesa adicional.
				System.out.print("Despesa Adicional: ");
				double despesaAdicional = ent.nextDouble();
				funcionarios.add(new FuncionarioTerceirizado(nome, horas, valorPorHora, despesaAdicional));
			} else {
				funcionarios.add(new Funcionario(nome, horas, valorPorHora));
			}

		}

		System.out.println("\nPagamentos: ");
		for (Funcionario funcionario : funcionarios) {// imprimindo o nome de cada funcionário com seu respectivo pagamento.
			System.out.println(funcionario.getNome() + " - R$ " + String.format("%.2f", funcionario.pagamento()));
		}

		ent.close();
	}

}
