package utfp.POO2.ProjetoFinal.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utfp.POO2.ProjetoFinal.Entity.Usuario;
import utfp.POO2.ProjetoFinal.dao.BancoDados;
import utfp.POO2.ProjetoFinal.dao.UsuarioDao;

public class UsuarioService {

	    public int CadastrarUsuario(Usuario user) throws SQLException, IOException {
	        Connection conn = BancoDados.conectar();
	        UsuarioDao userDao = new UsuarioDao(conn);

	    
	        List<Usuario> listaUser = userDao.buscarTodos();


	        for (Usuario user1 : listaUser) {
	            if (user1.getLogin().equals(user.getLogin())) {
	                BancoDados.desconectar();
	                return 1; 
	            }
	        }

	      
	        userDao.cadastrar(user);
	        BancoDados.desconectar();
	        return 0; 
	    }
	    public int VerificarLogin(Usuario userL) throws SQLException, IOException {
	        Connection conn = BancoDados.conectar();
	        UsuarioDao userDao = new UsuarioDao(conn);

	        for (Usuario user : userDao.buscarTodos()) {
	            if (user.getLogin().equals(userL.getLogin())
	                && user.getSenha().equals(userL.getSenha())) {

	                BancoDados.desconectar();
	                return 1; 
	            }
	        }

	        BancoDados.desconectar();
	        return 0; 
	    }
	}


