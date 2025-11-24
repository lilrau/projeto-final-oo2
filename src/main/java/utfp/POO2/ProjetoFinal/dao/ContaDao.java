package utfp.POO2.ProjetoFinal.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utfp.POO2.ProjetoFinal.Entity.Conta;

public class ContaDao {

    private Connection conn;

    public ContaDao(Connection conn) {
        this.conn = conn;
    }
   
    
    
    public boolean contaExiste(int agencia, int numeroConta) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                "SELECT codConta FROM conta WHERE agencia = ? AND numeroConta = ?"
            );

            st.setInt(1, agencia);
            st.setInt(2, numeroConta);

            rs = st.executeQuery();

            return rs.next(); 
        } finally {
            BancoDados.finalizarStatement(st);
            BancoDados.finalizarResultSet(rs);
        }
    }


    public int cadastrar(Conta conta) throws SQLException, IOException {

        if (contaExiste(conta.getAgencia(), conta.getNumeroConta())) {
            return -1;
        }

        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                "INSERT INTO conta (nomeBanco, agencia, numeroConta, saldoInicial, tipoConta) " +
                "VALUES (?, ?, ?, ?, ?)"
            );

            st.setString(1, conta.getNomeBanco());
            st.setInt(2, conta.getAgencia());
            st.setInt(3, conta.getNumeroConta());
            st.setDouble(4, conta.getSaldoInicial());
            st.setString(5, conta.getTipoConta());

            return st.executeUpdate(); 
        } finally {
            BancoDados.finalizarStatement(st);
        }
    }
}
