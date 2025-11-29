package utfp.POO2.ProjetoFinal.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import utfp.POO2.ProjetoFinal.Entity.Usuario;
import utfp.POO2.ProjetoFinal.service.UsuarioService;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginGui extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtLogin;
    private JTextField txtSenha;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginGui frame = new LoginGui();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public LoginGui() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnArquivo = new JMenu("Arquivo");
        menuBar.add(mnArquivo);

        JMenuItem miFechar = new JMenuItem("Fechar");
        miFechar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mnArquivo.add(miFechar);

        JMenu mnAjuda = new JMenu("Ajuda");
        menuBar.add(mnAjuda);

        JMenuItem miSobre = new JMenuItem("Sobre");
        miSobre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Sistema de Login\nDesenvolvido para o Projeto Final de POO2.");
            }
        });
        mnAjuda.add(miSobre);

        JMenuItem miPrimeiroAcesso = new JMenuItem("Primeiro Acesso");
        miPrimeiroAcesso.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Primeiro acesso padrão:\nLogin: login\nSenha: 123\nUse este acesso apenas para cadastrar o primeiro usuário.",
                        "Primeiro Acesso",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        mnAjuda.add(miPrimeiroAcesso);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String login = txtLogin.getText();
                String senha = txtSenha.getText();

                if (login.equals("login") && senha.equals("123")) {
                    JOptionPane.showMessageDialog(null,
                            "Primeiro acesso detectado!\nUse este login inicial para cadastrar o administrador.");
                    Usuario user = new Usuario();
                    user.setLogin("");
                    user.setDataNascimento(null);
                    user.setSenha("");
                    user.setCodUsuario(-1);
                    user.setSexo("");
                    limparCampo();
                    MenuPrincipalGui menu = new MenuPrincipalGui(user, LoginGui.this);
                    menu.setVisible(true);
                    dispose();
                    return;
                }

                Usuario user = new Usuario();
                UsuarioService userSer = new UsuarioService();
                user.setLogin(login);
                user.setSenha(senha);

                try {
                    int opc = userSer.VerificarLogin(user);

                    if (opc == 1) {
                        MenuPrincipalGui menu = new MenuPrincipalGui(user, LoginGui.this);
                        limparCampo();
                        menu.setVisible(true);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Login errado\nTente novamente.");
                    }
                } catch (SQLException | IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        btnEntrar.setBounds(280, 199, 105, 27);
        contentPane.add(btnEntrar);

        txtLogin = new JTextField();
        txtLogin.setFont(new Font("Dialog", Font.PLAIN, 17));
        txtLogin.setBounds(157, 74, 171, 32);
        contentPane.add(txtLogin);

        JLabel lblLogin_1 = new JLabel("Login");
        lblLogin_1.setFont(new Font("Dialog", Font.BOLD, 17));
        lblLogin_1.setBounds(79, 74, 60, 32);
        contentPane.add(lblLogin_1);

        JLabel lblSenha = new JLabel("Senha");
        lblSenha.setFont(new Font("Dialog", Font.BOLD, 17));
        lblSenha.setBounds(79, 126, 60, 17);
        contentPane.add(lblSenha);

        txtSenha = new JTextField();
        txtSenha.setFont(new Font("Dialog", Font.PLAIN, 17));
        txtSenha.setBounds(157, 118, 171, 32);
        contentPane.add(txtSenha);

        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnFechar.setBounds(80, 199, 105, 27);
        contentPane.add(btnFechar);
    }
    public void limparCampo() {
    	txtLogin.setText("");
        txtSenha.setText("");
    }
}
