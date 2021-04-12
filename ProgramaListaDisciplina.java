import java.util.Scanner;
import java.util.*;

public class ProgramaListaDisciplina
{
	public ListaDisciplinas programaListaDisciplina()
	{
		ListaDisciplinas lista = new ListaDisciplinas();

		MenuDisciplina menuDisciplina = new MenuDisciplina();
		
		int posicao, opc = 0, RGM, valor;
		float nota;
		String nomeDisciplina, nomeAluno;
		
		Scanner entrada = new Scanner(System.in);
		LimpaConsole limpaConsole = new LimpaConsole();
		
		while (opc != 7)
		{
			limpaConsole.clearScreen();
			menuDisciplina.mostrarMenuDisciplina();
			System.out.print("\nEscolha a opção desejada: ");
			opc = entrada.nextInt();
			entrada.nextLine();
			switch(opc)
			{
				case 1:
					//solicita nome da disciplina
					System.out.println("\nDigite o nome da disciplina cursada");
					nomeDisciplina = entrada.nextLine();
					//solicita nota da disciplina
					System.out.println("Digite a nota da disciplina");
					nota = entrada.nextFloat();
					entrada.nextLine();
					
					lista.inserirInicio(new Disciplina(nomeDisciplina,nota));
					break;
				case 2:
					//solicita nome da disciplina
					System.out.println("\nDigite o nome da disciplina cursada");
					nomeDisciplina = entrada.nextLine();
					//solicita nota da disciplina
					System.out.println("Digite a nota da disciplina");
					nota = entrada.nextFloat();
					entrada.nextLine();
					
					lista.inserirFinal(new Disciplina(nomeDisciplina,nota));
					break;
				case 3:
					//solicita nome da disciplina
					System.out.println("\nDigite o nome da disciplina cursada");
					nomeDisciplina = entrada.nextLine();
					//solicita nota da disciplina
					System.out.println("Digite a nota da disciplina");
					nota = entrada.nextFloat();
					entrada.nextLine();

					System.out.println("Informe a posição para inserção");
					posicao = entrada.nextInt();
					entrada.nextLine();
					
					lista.inserirPosicao(new Disciplina(nomeDisciplina,nota), posicao);
					break;
				case 4:
					System.out.println("Quantidade de disciplinas cursadas pelo aluno: " + lista.contarNos());
					valor = lista.contarNos();
					entrada.nextLine();
					break;
				case 5:
					if(lista.contarNos()==0)
					{
						System.out.println("Lista vazia");
					}
					else
					{
						System.out.println("Digite a posição para remover: ");
						posicao = entrada.nextInt();
						entrada.nextLine();
						System.out.println(lista.excluirNo(posicao));
					}
					break;
				case 6:
					if(lista.contarNos()==0)
					{
						System.out.println("Lista vazia");
					}
					else 
					{
						System.out.println(lista.mostrarLista());
						entrada.nextLine();
					}
					break;
				case 7:
					System.out.println("\nSair do cadastro de disciplinas\n");
			}
		}
		return lista;
	}
	
}