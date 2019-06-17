package controller;

import java.util.Scanner;
import dao.LivroDAO;
import model.Livro;

public class LivroController {

	public void create(Livro livro) {
		try {
			
			LivroDAO dao = new LivroDAO();
			
			dao.create(livro);


		} finally {
			// TODO: handle finally clause
			System.out.println("Fim inserção!");
		}
	}
}

		


