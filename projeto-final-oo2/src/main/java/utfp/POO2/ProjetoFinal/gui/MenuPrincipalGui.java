package utfp.POO2.ProjetoFinal.gui;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import utfp.POO2.ProjetoFinal.Entity.Usuario;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuPrincipalGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;



	public MenuPrincipalGui(Usuario user, LoginGui login) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setBounds(191, 0, 57, 37);
		lblMenu.setFont(new Font("Dialog", Font.BOLD, 18));
		contentPane.add(lblMenu);

		JButton btnCadastarNovoUsuario = new JButton("Cadastrar novo usuário");
		btnCadastarNovoUsuario.setBounds(130, 190, 180, 27);
		contentPane.add(btnCadastarNovoUsuario);
		
		JButton btnCadastrarNovaConta = new JButton("Cadastrar nova conta");
		btnCadastrarNovaConta.setBounds(130, 148, 180, 27);
		btnCadastrarNovaConta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ContaGui contaGui = new ContaGui(MenuPrincipalGui.this);
				contaGui.setVisible(true);
			}
		});
		contentPane.add(btnCadastrarNovaConta);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login.setVisible(true);
				dispose();
				
			}
		});
		btnVoltar.setBounds(77, 229, 105, 27);
		contentPane.add(btnVoltar);


		btnCadastarNovoUsuario.addActionListener(e -> {
			UsuarioGui userGui = new UsuarioGui(MenuPrincipalGui.this);
			userGui.setVisible(true);
		});
	}
}
