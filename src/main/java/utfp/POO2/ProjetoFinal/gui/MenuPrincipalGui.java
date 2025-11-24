package utfp.POO2.ProjetoFinal.gui;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuPrincipalGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				MenuPrincipalGui frame = new MenuPrincipalGui();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public MenuPrincipalGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setFont(new Font("Dialog", Font.BOLD, 18));
		lblMenu.setBounds(191, 0, 57, 37);
		contentPane.add(lblMenu);

		JButton btnCadastarNovoUsuario = new JButton("Cadastrar novo usuário");
		btnCadastarNovoUsuario.setBounds(130, 198, 180, 27);
		contentPane.add(btnCadastarNovoUsuario);
		
		JButton btnCadastrarNovaConta = new JButton("Cadastrar nova conta");
		btnCadastrarNovaConta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ContaGui contaGui = new ContaGui(MenuPrincipalGui.this);
				contaGui.setVisible(true);
			}
		});
		btnCadastrarNovaConta.setBounds(130, 159, 180, 27);
		contentPane.add(btnCadastrarNovaConta);


		btnCadastarNovoUsuario.addActionListener(e -> {
			UsuarioGui userGui = new UsuarioGui(MenuPrincipalGui.this);
			userGui.setVisible(true);
		});
	}
}
