import java.util.*;

public class Aluno
{
	String nome;
	int RGM;
	ListaDisciplinas listaDiscDoAluno;
	// ListaDisciplina disciplinasDoAluno ponteiro para lista encadeada

	Aluno (String nomeAluno, int RGMdoAluno)
	{
		nome=nomeAluno;
		RGM=RGMdoAluno;
		listaDiscDoAluno=null;
	}

	public String getNome() 
	{
		return nome;
	}
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	public int getRGM()
	{
		return RGM;
	}
	public void setRGM(int RGM)
	{
		this.RGM = RGM;
	}
}