package utfp.POO2.ProjetoFinal.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import utfp.POO2.ProjetoFinal.Entity.Conta;
import utfp.POO2.ProjetoFinal.dao.BancoDados;
import utfp.POO2.ProjetoFinal.dao.ContaDao;

public class ContaService {


    public int cadastrarConta(Conta conta) {

        try {
            Connection conn = BancoDados.conectar();
            ContaDao dao = new ContaDao(conn);

            int resultado = dao.cadastrar(conta);

            BancoDados.desconectar();
            return resultado;

        } catch (SQLException | IOException e) {
            e.printStackTrace();
            return -2; 
        }
    }
}
