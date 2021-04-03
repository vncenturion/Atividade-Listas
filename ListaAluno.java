import java.util.*;

public class ListaAluno
{
	Aluno[] alunos = new Aluno[60];
	int tamanho = 0;

	public boolean estaVazia()
	{
		return (tamanho==0);
	}

	public boolean estaCheia()
	{
		return (tamanho==alunos.length);
	}

	public int tamanhoLista()
	{
		return tamanho;
	}

	public Aluno buscar(int pos)
	{
		//verifica se a variavel posicao procurada é valida
		if ((pos>= tamanho) || (pos < 0))
		{
			return null;
		}
		return alunos[pos];
	}

	public int buscaBinaria(int bbRGM)
	{
		//busca RGM informado por busca 'binaria'
		if (tamanho<=0)
		{
			System.out.println("Lista vazia!");
			return -1;
		}
		else
		{
			int limSup, limInf, mediana;
			limSup=(tamanho-1);
			limInf=0;
			mediana=(limInf+limSup)/2;
			while(limInf!=limSup)
			{
				if (bbRGM==alunos[mediana].RGM)
				{
					return mediana;
				}
				else
				{
					if(bbRGM<alunos[mediana].RGM)
					{
						limSup=mediana;
						limInf=limInf;
						mediana=(limInf+limSup)/2;
					}
					else
					{
						limSup=limSup;
						limInf=mediana+1;
						mediana=(limInf+limSup)/2;
					}
				}
			}
			
			if(bbRGM==alunos[mediana].RGM)
			{
				return mediana;
			}

		}
		
		return -1;
	}

	public boolean compara(String c1, String c2)
	{
		return (c1.equals(c2));
	}

	//busca comparando o registro inteiro pelo nome
	public int retornarPosicao(String nomeDoAluno)
	{
		for (int i=0; i < tamanho; i++)
			{
				if (compara(alunos[i].nome, nomeDoAluno))
				{
					return i;
				}
			}
		return -1;
	}

	//busca por determinado elemento *(linear)
	public int retornarPosicaoRGM(int RGMdoAluno)
	{
		for (int i=0; i < tamanho; i++)
			{
				if (alunos[i].RGM == RGMdoAluno)
				{
					return i;
				}
			}
		return -1;
	}

	public void deslocarParaDireita(int pos)
	{
		for (int i = tamanho; i> pos; i--)
		{
			alunos[i]= alunos[i-1];
		}
	}

	public boolean inserirAluno(int pos, Aluno c1)
	{
		if ( estaCheia() || (pos > tamanho) || (pos < 0) )
		{
			return false;
		}
		
		deslocarParaDireita(pos);
		alunos[pos] = c1;
		tamanho++;
		return true;
	}

	public int inserirAlunoOrdenado(Aluno c1)
	{
		int controleInserirPosicao=0;
		
		if (estaCheia())
		{
			return -1;
		}
		
		if (tamanho==0)
		{
			alunos[0] = c1;
			tamanho++;
			
		} else
		{
			for (int i=0; i<tamanho; i++)
			{ //procura tamanho do RGM
				if(alunos[i].RGM<c1.RGM)
				{ //se menor que o atual, passa para o proximo
					controleInserirPosicao+=1;
				} else
				{ //se maior, insere na posicao encontrada
					deslocarParaDireita(controleInserirPosicao);
					alunos[controleInserirPosicao] = c1;
					tamanho++;
					return controleInserirPosicao;
				}
			}
			//se maior que todos, insere no fim			
			controleInserirPosicao=tamanho;
			deslocarParaDireita(controleInserirPosicao);
			alunos[controleInserirPosicao] = c1;
			tamanho++;
		}
		
		return controleInserirPosicao;
	}
	
	public void deslocarParaEsquerda(int pos)
	{
		for (int i = pos; i < (tamanho - 1); i++)
		{
			alunos[i]=alunos[i+1];
		}
		alunos[tamanho-1]=null;//zera ultima posicao para evitar exibiçao errada
	}

	public boolean remover(int pos)
	{
		if ( (pos >= tamanho) || (pos < 0) )
		{
			return false;
		}
		deslocarParaEsquerda(pos);
		tamanho--;
		return true;
	}

	public void exibirLista()
	{
		System.out.println("\nLISTA DOS ALUNOS\n");
		for (int i=0; i<tamanho; i++)
		{
			System.out.println("\nAluno "+(i+1)+"\nNome: "+alunos[i].nome+"\nRGM: "+alunos[i].RGM);			
		}
	}
}