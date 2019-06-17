package view;
import java.util.Scanner;

import dao.LivroDAO;
import model.Livro;

public class CRUDLivro {

	private void create()
	{
		try {
			
			Livro livro = new Livro();
			LivroDAO dao = new LivroDAO();
			
			System.out.println("Entre com o titulo do livro:");
			Scanner sc = new Scanner(System.in);
			livro.setTitulo(sc.nextLine());
			
			System.out.println("Entre com a matricula do aluno:");
			livro.setMatricula(sc.nextInt());;
			
			System.out.println("Entre com o nome do aluno:");
			livro.setAluno(sc.nextLine());
			
			dao.create(livro);

		} finally {
			// TODO: handle finally clause
			System.out.println("Fim inserção!");
		}
		

	}
	
	private void read()
	{
		LivroDAO dao = new LivroDAO();
		
		for (Livro livro : dao.read()) {
			
			System.out.println("***********************************");
			System.out.println("Titulo: "+ livro.getTitulo());
			System.out.println("Matricula: "+ livro.getMatricula());
			System.out.println("Aluno: "+ livro.getAluno());	
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CRUDLivro crud = new CRUDLivro();
		
		crud.create();
		crud.read();
		
		
	}

}
