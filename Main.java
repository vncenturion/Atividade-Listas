import java.util.Scanner;
import java.util.*;
import java.io.IOException;


class Main 
{
	public static void main(String[] args) 
	{
		//instancia classe scanner
		Scanner entrada = new Scanner(System.in);
		//instancia classe menu
		MenuPrincipal menuPrincipal = new MenuPrincipal();
		//instancia classe programa2		
		ProgramaListaDisciplina programa2 = new ProgramaListaDisciplina();
		
		//instancia classe limpaTela
		LimpaConsole limpaConsole = new LimpaConsole();

		int RGMdoAluno, controle=0, controleAddLista=0, posicaoLista=0;
		String nomeDoAluno;

		ListaAluno listasequencial = new ListaAluno();
		ListaDisciplinas listaencadeada = new ListaDisciplinas();

		while (controle !=6)
		{
			limpaConsole.clearScreen();

			menuPrincipal.mostrarMenuPrincipal();
			controle = entrada.nextInt();
			entrada.nextLine();//limpa buffer pos int

			switch(controle)
			{
				case 1:
					//controleAddLista = listasequencial.tamanhoLista();
					
					//solicita Nome do aluno
					System.out.println("\nDigite o nome do Aluno");
					nomeDoAluno = entrada.nextLine();
					
					//solicita RGM do aluno
					System.out.println("Digite o RGM do aluno");
					RGMdoAluno = entrada.nextInt();
					entrada.nextLine();
					
					//listasequencial.inserirAluno(controleAddLista, new Aluno(nomeDoAluno,RGMdoAluno));
					controleAddLista=listasequencial.inserirAlunoOrdenado(new Aluno(nomeDoAluno,RGMdoAluno));

					System.out.println(controleAddLista);

					listasequencial.alunos[controleAddLista].listaDiscDoAluno=	(programa2.programaListaDisciplina());

					System.out.println("<pressione ENTER>");
					entrada.nextLine();
					break;
				case 2:
					//remover aluno cadastro da lista sequencial

					int rgmBuscaExclui=0;
					System.out.println("Digite o RGM do aluno que deseja remover: ");
					System.out.print("\nRGM: ");
					rgmBuscaExclui = entrada.nextInt();
					entrada.nextLine();
					
					int posicaoBuscaExclui = listasequencial.retornarPosicaoRGM(rgmBuscaExclui);

					if (posicaoBuscaExclui!=-1)
					{
						listasequencial.remover(posicaoBuscaExclui);
						System.out.println("\nRGM "+ rgmBuscaExclui + " excluído com sucesso da posição " + posicaoBuscaExclui);
					} 
					else
					{
						System.out.println("RGM inexistente!");
					}
				
					System.out.println("<pressione ENTER>");
					entrada.nextLine();

					break;
				case 3:
					//exibe lista dos alunos (lista sequencial)
					listasequencial.exibirLista();
					System.out.println("\n<pressione ENTER>");
					entrada.nextLine();
					break;
				case 4:
					//bucas por indice
					int tipoBusca=0;
					System.out.println("\nSelecione o tipo de busca:\n1 - por posição\n2 - por nome do aluno\n3 - por RGM");
					System.out.print("\nOpção: ");
					tipoBusca = entrada.nextInt();
					entrada.nextLine();

					switch(tipoBusca)
					{
						case 1:
							//buscar elemento por indice
							int indice = 0;
							System.out.print("Digite a posição buscada: ");
							indice = entrada.nextInt();
							entrada.nextLine();
							
							if (indice<listasequencial.tamanho)
							{
								System.out.println("\nNome do(a) aluno(a) na posicao #"+ indice +" é: "+listasequencial.buscar(indice).nome + " de RGM n: " + listasequencial.buscar(indice).RGM);
							} else 
							{
								System.out.println("Posição inválida!");
							}
							break;
						case 2:
							//busca por nome
							//buscar elemento por nome
							String nomeBusca;
							int posicaoBusca=0;
							System.out.print("Digite no do aluno buscado: ");
							nomeBusca = entrada.nextLine();
							posicaoBusca = listasequencial.retornarPosicao(nomeBusca);
							if (posicaoBusca !=-1)
							{
								System.out.println("\nPosicao do(a) aluno(a) "+nomeBusca+" é: "+ posicaoBusca);
							} else
							{
								System.out.println("Aluno(a) inexistente!");
							}
							break;
						case 3:
							//buscar elemento por rgm
							int rgmBusca = 0;
							int posicaoRGM=0;
							System.out.print("Digite o RGM do aluno(a) buscado(a): ");
							rgmBusca = entrada.nextInt();
							entrada.nextLine();
							
							//posicaoRGM = listasequencial.retornarPosicaoRGM(rgmBusca);

							posicaoRGM = listasequencial.buscaBinaria(rgmBusca);

							if (posicaoRGM!=-1)
							{
								System.out.println("\nPosicao do RGM "+ rgmBusca + " é: " + posicaoRGM);
							} else
							{
								System.out.println("RGM inexistente!");
							}
							break;
						default:
							System.out.println("Opção inválida!");
							break;
					}
					System.out.println("<pressione ENTER>");
					entrada.nextLine();
					break;

				case 5:
					//exibir lista completa
					int k=0;
					while (listasequencial.alunos[k]!=null)
					{
						listaencadeada=listasequencial.alunos[k].listaDiscDoAluno;
						int tamanhoLEncadeada=listaencadeada.contarNos();
						System.out.println("\nAluno: "+ listasequencial.alunos[k].nome + "\nRGM: "+listasequencial.alunos[k].RGM);
						System.out.println("\n     Lista de Discipinas do Aluno");
						System.out.println(listaencadeada.mostrarLista());
						k++;
					}
					System.out.println("\n<pressione ENTER>");
					entrada.nextLine();		
					break;
				case 6:
					System.out.println("\nPrograma finalizado!");
					break;
				default:
					System.out.println("opção invalida");
					break;
			}
		}
		
 	}
}