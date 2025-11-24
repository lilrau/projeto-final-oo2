package utfp.POO2.ProjetoFinal.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

import utfp.POO2.ProjetoFinal.Entity.Conta;
import utfp.POO2.ProjetoFinal.service.ContaService;

public class ContaGui extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    private JTextField txtNomebanco;
    private JTextField txtAgencia;
    private JTextField txtNumeroconta;
    private JTextField txtSaldoInicial;

    private ContaService service = new ContaService();

    public ContaGui(MenuPrincipalGui menu) {
        menu.setVisible(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("Cadastrar Nova Conta");
        lblTitulo.setFont(new Font("Dialog", Font.BOLD, 18));
        lblTitulo.setBounds(110, 10, 250, 25);
        contentPane.add(lblTitulo);

        JLabel lblNomeBanco = new JLabel("Nome do Banco");
        lblNomeBanco.setBounds(60, 60, 120, 20);
        contentPane.add(lblNomeBanco);

        txtNomebanco = new JTextField();
        txtNomebanco.setBounds(180, 60, 160, 20);
        contentPane.add(txtNomebanco);

        JLabel lblTipoConta = new JLabel("Tipo da Conta");
        lblTipoConta.setBounds(60, 95, 120, 20);
        contentPane.add(lblTipoConta);

        JComboBox<String> cbTipoConta = new JComboBox<>();
        cbTipoConta.addItem("Corrente");
        cbTipoConta.addItem("Poupança");
        cbTipoConta.addItem("Salário");
        cbTipoConta.addItem("Universitária");
        cbTipoConta.setBounds(180, 95, 160, 22);
        contentPane.add(cbTipoConta);

        JLabel lblSaldo = new JLabel("Saldo Inicial");
        lblSaldo.setBounds(60, 130, 120, 20);
        contentPane.add(lblSaldo);

        txtSaldoInicial = new JTextField();
        txtSaldoInicial.setBounds(180, 130, 160, 20);
        contentPane.add(txtSaldoInicial);

        JLabel lblAgencia = new JLabel("Agência");
        lblAgencia.setBounds(60, 165, 120, 20);
        contentPane.add(lblAgencia);

        txtAgencia = new JTextField();
        txtAgencia.setBounds(180, 165, 80, 20);
        contentPane.add(txtAgencia);

        JLabel lblNumeroConta = new JLabel("Número da Conta");
        lblNumeroConta.setBounds(60, 200, 120, 20);
        contentPane.add(lblNumeroConta);

        txtNumeroconta = new JTextField();
        txtNumeroconta.setBounds(180, 200, 160, 20);
        contentPane.add(txtNumeroconta);

        JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setBounds(240, 250, 100, 25);
        contentPane.add(btnConfirmar);

        btnConfirmar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                try {
                   
                    String nomeBanco = txtNomebanco.getText().trim();
                    String tipoConta = cbTipoConta.getSelectedItem().toString();
                    double saldo = Double.parseDouble(txtSaldoInicial.getText().trim());
                    int agencia = Integer.parseInt(txtAgencia.getText().trim());
                    int numero = Integer.parseInt(txtNumeroconta.getText().trim());

                    if (nomeBanco.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Informe o nome do banco!");
                        return;
                    }

                    Conta conta = new Conta(nomeBanco, agencia, numero, saldo, tipoConta);

                    int resultado = service.cadastrarConta(conta);

                    if (resultado == 0) {
                        JOptionPane.showMessageDialog(null, "Conta cadastrada com sucesso!");

                        txtNomebanco.setText("");
                        txtSaldoInicial.setText("");
                        txtAgencia.setText("");
                        txtNumeroconta.setText("");
                        cbTipoConta.setSelectedIndex(0);

                    } else if (resultado == -1) {
                        JOptionPane.showMessageDialog(null, "Já existe uma conta com essa agência e número!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao cadastrar conta!");
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Preencha os números corretamente!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
                }
            }
        });

 
        
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(80, 250, 100, 25);
        contentPane.add(btnVoltar);

        btnVoltar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ContaGui.this.dispose();
                menu.setVisible(true);
            }
        });
    }
}
