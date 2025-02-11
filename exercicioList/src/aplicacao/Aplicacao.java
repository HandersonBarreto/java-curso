package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidade.Empregado;

public class Aplicacao {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Empregado> list = new ArrayList<>();

		System.out.print("Quantos funcionários serão cadastrados? ");
		int qtdeEmpregados = sc.nextInt();

		for (int i = 0; i < qtdeEmpregados; i++) {
			System.out.println("Empregado #" + (i + 1) + ":");
			System.out.print("ID: ");
			Integer id = sc.nextInt();
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Salario: ");
			Double salario = sc.nextDouble();

			Empregado empregado = new Empregado(id, nome, salario);
			list.add(empregado);
		}

		System.out.print("Informe o ID do funcionário que terá aumento salarial :");
		int buscaId = sc.nextInt();
		System.out.print("Insira a porcentagem: ");
		double percentual = sc.nextDouble();

		for (Empregado empregado : list) {
			if (empregado.getId() == buscaId) {
				double novosalario = empregado.calcularSalario(percentual);
				empregado.setSalario(novosalario);
			}
		}

		for (Empregado empregado : list) {
			System.out.println(empregado.toString());
		}
		sc.close();
	}

}
