package utfp.POO2.ProjetoFinal.dao;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utfp.POO2.ProjetoFinal.Entity.Usuario;

public class UsuarioDao {
	private Connection conn;

	public UsuarioDao(Connection conn) {

		this.conn = conn;
}
	public int cadastrar(Usuario usuario) throws SQLException, IOException {

		PreparedStatement st = null;

		try {
            Connection conn = BancoDados.conectar();
			st = conn.prepareStatement("insert into usuario (nome, login, dataNascimento, sexo , senha) values (?, ?, ?, ? , ?)");

			st.setString(1, usuario.getNome());
			st.setString(2, usuario.getLogin());
			st.setDate(3, usuario.getDataNascimento());
			st.setString(4, usuario.getSexo());
			st.setString(5, usuario.getSenha());


			return st.executeUpdate();

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
		
	}
	public List<Usuario> buscarTodos() throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from usuario");

			rs = st.executeQuery();

			List<Usuario> listaUser = new ArrayList<>();

			while (rs.next()) {

				Usuario user = new Usuario();
                  user.setNome(rs.getNString("nome"));
                  user.setLogin(rs.getNString("Login"));
                  user.setSenha(rs.getNString("senha"));
                  user.setDataNascimento(rs.getDate("dataNascimento"));
                  user.setSexo(rs.getNString("sexo"));
                  user.setCodUsuario(rs.getInt("codUsuario"));


				listaUser.add(user);
			}

			return listaUser;

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}


}
