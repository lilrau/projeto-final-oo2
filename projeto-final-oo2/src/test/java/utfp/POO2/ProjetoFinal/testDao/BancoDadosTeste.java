package utfp.POO2.ProjetoFinal.testDao;



import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import utfp.POO2.ProjetoFinal.dao.BancoDados;


public class BancoDadosTeste {

	public static void conectarTeste() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();

		if (conn != null) {

			System.out.println("Conexão realizada com sucesso.");

		} else {

			System.out.println("Erro ao realizar a conexão.");
		}
	}

	public static void desconectarTeste() throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		conn = BancoDados.desconectar();

		if (conn == null) {

			System.out.println("Desconexão realizada com sucesso.");

		} else {

			System.out.println("Erro ao realizar a desconexão.");
		}
	}

	public static void main(String[] args) {

		try {

			BancoDadosTeste.conectarTeste();
			BancoDadosTeste.desconectarTeste();

		} catch (SQLException | IOException e) {

			System.out.println(e.getMessage());
		}
	}
}
