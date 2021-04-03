import java.util.*;

public class ListaDisciplinas
{
	Disciplina primeiro, ultimo;
	
	ListaDisciplinas()
	{
		primeiro = null;
		ultimo = null;
	}


	public void inserirFinal(Disciplina novoNo)
	{
		novoNo.prox = null;
		if(primeiro == null)
			primeiro = novoNo;
		else
			ultimo.prox = novoNo;
		ultimo = novoNo;
	}

	public void inserirInicio(Disciplina novoNo)
	{
		if(primeiro == null)
		{
			primeiro = novoNo;
			ultimo = novoNo;
		} 
		else
		{
			novoNo.prox = primeiro;
			primeiro = novoNo;
		}
	}

	public int contarNos()
	{
		int quantidade = 0;
		Disciplina noTemp = primeiro;
		while (noTemp != null)
		{
			quantidade++;
			noTemp = noTemp.prox;
		}
		return quantidade;
	}

	public void inserirPosicao(Disciplina novoNo, int posicao)
	{
		Disciplina noTemp = primeiro;
		int posAux, numNos = contarNos();
		if(posicao == 0)
			inserirInicio(novoNo);
		else
		{	
			if (posicao > numNos)
				inserirFinal(novoNo);
			else
			{
				posAux = 1;
				while (posicao>posAux)
				{
					noTemp = noTemp.prox;
					posAux++;
				}
				novoNo.prox = noTemp.prox;
				noTemp.prox = novoNo;
			}
		}
	}

	public String excluirNo(int posicao)
	{
		Disciplina noTemp = new Disciplina("",0.0F);
		noTemp.prox = primeiro;
		int posAux = 0;
		String msg = "";
		while(noTemp.prox != null && posicao != posAux)
		{
			noTemp = noTemp.prox;
			posAux++;
		}
		if(noTemp.prox == null)
		{
			msg = "Disciplina não encontrada.";
		} 
		else
		{
			if (ultimo == noTemp.prox)
				ultimo = noTemp;
			if (primeiro == noTemp.prox)
				primeiro = noTemp.prox.prox;
			msg = "Disciplina> " + noTemp.prox.nomeDisciplina + " excluida.";
			noTemp.prox = noTemp.prox.prox;
		}
		return msg;
	}

	public String mostrarLista()
	{
		int i = 0;
		Disciplina noTemp = primeiro;
		String msg = "";
		while(noTemp != null)
		{
			msg = msg + /*"\nPosição: " + i + */" \n     Nome da disciplina: " + noTemp.nomeDisciplina + "\n     Nota na disciplina: " + noTemp.notaDisciplina + "\n";
			noTemp = noTemp.prox;
			i++;
		}
		return msg;
	}


}