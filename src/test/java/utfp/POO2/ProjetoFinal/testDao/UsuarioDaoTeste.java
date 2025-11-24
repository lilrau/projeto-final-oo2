package utfp.POO2.ProjetoFinal.testDao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utfp.POO2.ProjetoFinal.Entity.Usuario;
import utfp.POO2.ProjetoFinal.dao.BancoDados;
import utfp.POO2.ProjetoFinal.dao.UsuarioDao;

public class UsuarioDaoTeste {
    public static void main(String[] args) throws IOException, SQLException {
        Date dataNascimento = Date.valueOf("2000-05-15");
        Usuario user = new Usuario("Joao", "joao123", dataNascimento, "Masculino", "a123");
          MostrarUsuarios();
       /* try {
            Connection conn = BancoDados.conectar(); 
            //UsuarioDao userDao = new UsuarioDao(conn);
       
            //int linhasAfetadas = userDao.cadastrar(user);
            //System.out.println("Usuário cadastrado com sucesso! Linhas afetadas: " + linhasAfetadas);

            BancoDados.desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }
    public static  void MostrarUsuarios() throws SQLException, IOException {
    	Connection conn = BancoDados.conectar();
    	UsuarioDao userDao = new UsuarioDao(conn);
    	List<Usuario>  userList = new ArrayList<Usuario>();
    	userList = userDao.buscarTodos();
        for (Usuario user : userList) {
 
            System.out.println("Nome: " + user.getNome());
            System.out.println("Login: " + user.getLogin());
            System.out.println("Data de nascimento: " + user.getDataNascimento());
            System.out.println("Gênero: " + user.getSexo());
            System.out.println("-------------------------");
        }
    }
    
}
