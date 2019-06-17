package dao;

import model.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConnectionFactory;
import model.Livro;

public class LivroDAO {

	public void create(Livro l) {
		// TODO Auto-generated method stub
		{
			Connection con = ConnectionFactory.getConnection();

			PreparedStatement stmt = null;
			
			String sql = "insert into livro (aluno, matricula, titulo) values (?,?,?)";
		
			try {
				stmt = con.prepareStatement(sql);
				stmt.setString(1, l.getAluno());
				stmt.setInt(2, l.getMatricula());
				stmt.setString(3, l.getTitulo());
				stmt.executeUpdate();
				
				System.out.println("Emprestimo salvo com sucesso.");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("Erro ao salvar o emprestimo.");
			} finally {
				ConnectionFactory.closeConnection(con, stmt);
			}	
		}
	}

	public List<Livro> read()
	{
		
		Connection con = ConnectionFactory.getConnection ();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from livro";
		
		List<Livro> livros = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while (rs.next())
			{
				Livro livro = new Livro();
				livro.setTitulo(rs.getString("Titulo"));
				livro.setMatricula(rs.getInt("Matricula"));
				livro.setAluno(rs.getString("Aluno"));
				
				livros.add(livro);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return livros;
	}
	
}


