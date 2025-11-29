package utfp.POO2.ProjetoFinal.gui;

import java.awt.Font;
import java.awt.Color;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import utfp.POO2.ProjetoFinal.Entity.Usuario;
import utfp.POO2.ProjetoFinal.service.UsuarioService;

public class UsuarioGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JFormattedTextField txtDataNasc;
	private final ButtonGroup grupoSexo = new ButtonGroup();
	private JTextField txtLogin;
	private JTextField txtSenha;
	private UsuarioService userServ = new UsuarioService();

	// Referência para o menu, para poder voltar
	private MenuPrincipalGui menu;

	public UsuarioGui(MenuPrincipalGui menu) {

		this.menu = menu;
		menu.setVisible(false); // esconde menu

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 386, 350);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastro = new JLabel("Cadastro");
		lblCadastro.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCadastro.setBounds(140, 0, 140, 25);
		contentPane.add(lblCadastro);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(83, 31, 60, 17);
		contentPane.add(lblLogin);

		txtLogin = new JTextField();
		txtLogin.setBounds(124, 29, 230, 21);
		contentPane.add(txtLogin);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(83, 62, 60, 17);
		contentPane.add(lblSenha);

		txtSenha = new JTextField();
		txtSenha.setBounds(124, 60, 230, 21);
		contentPane.add(txtSenha);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(83, 94, 60, 17);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(124, 92, 230, 21);
		contentPane.add(txtNome);

		JLabel lblDataNascimento = new JLabel("Data Nascimento");
		lblDataNascimento.setBounds(12, 127, 112, 17);
		contentPane.add(lblDataNascimento);

		MaskFormatter maskData = null;
		try {
			maskData = new MaskFormatter("##/##/####");
			maskData.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txtDataNasc = new JFormattedTextField(maskData);
		txtDataNasc.setBounds(124, 125, 230, 21);
		contentPane.add(txtDataNasc);

		JLabel lblSexoBox = new JLabel("");
		lblSexoBox.setBounds(124, 158, 184, 76);
		lblSexoBox.setBorder(new LineBorder(Color.BLACK, 1, true));
		contentPane.add(lblSexoBox);

		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(83, 187, 60, 17);
		contentPane.add(lblSexo);

		JRadioButton rbMasculino = new JRadioButton("Masculino");
		rbMasculino.setBounds(133, 164, 130, 25);
		rbMasculino.setFont(new Font("Dialog", Font.BOLD, 12));
		grupoSexo.add(rbMasculino);
		contentPane.add(rbMasculino);

		JRadioButton rbFeminino = new JRadioButton("Feminino");
		rbFeminino.setBounds(133, 183, 130, 25);
		grupoSexo.add(rbFeminino);
		contentPane.add(rbFeminino);

		JRadioButton rbOutro = new JRadioButton("Prefiro não informar");
		rbOutro.setBounds(133, 202, 169, 25);
		grupoSexo.add(rbOutro);
		contentPane.add(rbOutro);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(224, 256, 105, 27);
		contentPane.add(btnConfirmar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(83, 256, 105, 27);
		contentPane.add(btnVoltar);

		/* No botão confirmar ele pega todos o Txt e cria um objeto para ser manipulado 
		 * pelo service onde faz a verificação de login que retorna um int para ser exibido o jPane 
		 * se foi cadastrado com sucesso e esta usando a lambda e tem a erificação se os campos estão vazios
		*/
		btnConfirmar.addActionListener(e -> {

			String nome = txtNome.getText().trim();
			String login = txtLogin.getText().trim();
			String senha = txtSenha.getText().trim();
			String dataTexto = txtDataNasc.getText().trim();

			if (nome.isEmpty() || login.isEmpty() || senha.isEmpty() || dataTexto.isEmpty() || dataTexto.contains("_")) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente.");
				return;
			}

			String sexo = "";
			if (rbMasculino.isSelected())
				sexo = "Masculino";
			else if (rbFeminino.isSelected())
				sexo = "Feminino";
			else if (rbOutro.isSelected())
				sexo = "Prefiro não informar";
			else {
				JOptionPane.showMessageDialog(null, "Selecione o sexo.");
				return;
			}

			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				sdf.setLenient(false);
				java.util.Date dataUtil = sdf.parse(dataTexto);
				Date dataSql = new Date(dataUtil.getTime());

				Usuario user = new Usuario(nome, login, dataSql, sexo, senha);

				int opt = userServ.CadastrarUsuario(user);
				if (opt == 0) {
					JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");

					txtNome.setText("");
					txtLogin.setText("");
					txtSenha.setText("");
					txtDataNasc.setValue(null);
					grupoSexo.clearSelection();

				} else {
					JOptionPane.showMessageDialog(null, "O login informado já existe!");
				}

			} catch (ParseException ex) {
				JOptionPane.showMessageDialog(null, "Data inválida. Use o formato dd/MM/yyyy.");
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
				ex.printStackTrace();
			}
		});

		/*  Aqui ele altera para o botão voltar, aprecer o menu novamente e fechar a tela de cadastro*/
		btnVoltar.addActionListener(e -> {
			this.dispose();     
			menu.setVisible(true);
		});
	}
}
