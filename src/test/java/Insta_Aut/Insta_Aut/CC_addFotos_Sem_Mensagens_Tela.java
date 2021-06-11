package Insta_Aut.Insta_Aut;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CC_addFotos_Sem_Mensagens_Tela {

	JFrame frame;
	private JLabel labelNome;
	private JLabel lblOUsurioSer;
	private JLabel lblSenha;
	private JTextField textField_Telefone;
	private JPasswordField passwordField_senha;
	private final JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
	private JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
	private JButton btnVoltar;
	private JTextField textField_Fotos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| javax.swing.UnsupportedLookAndFeelException ex) {
			System.err.println(ex);
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CC_addFotos_Sem_Mensagens_Tela window = new CC_addFotos_Sem_Mensagens_Tela();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public CC_addFotos_Sem_Mensagens_Tela() {
		frame = new JFrame();
		frame.setBounds(600, 350, 334, 340);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setTitle("Criar contas");

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTelefone.setBounds(10, 11, 68, 25);
		frame.getContentPane().add(lblTelefone);

		labelNome = new JLabel("O nome será gerado automaticamente");
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelNome.setBounds(10, 55, 269, 25);
		frame.getContentPane().add(labelNome);

		lblOUsurioSer = new JLabel("O usuário será gerado automaticamente");
		lblOUsurioSer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOUsurioSer.setBounds(10, 108, 269, 25);
		frame.getContentPane().add(lblOUsurioSer);

		lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSenha.setBounds(10, 144, 51, 25);
		frame.getContentPane().add(lblSenha);

		textField_Telefone = new JTextField();
		textField_Telefone.setBounds(75, 11, 205, 29);
		frame.getContentPane().add(textField_Telefone);
		textField_Telefone.setColumns(10);

		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					jButton1ActionPerformed(evt);
				} catch (IOException | InterruptedException | InstantiationException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnIniciar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnIniciar.setBounds(57, 256, 96, 29);
		frame.getContentPane().add(btnIniciar);

		passwordField_senha = new JPasswordField();
		passwordField_senha.setBounds(58, 145, 205, 26);
		frame.getContentPane().add(passwordField_senha);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSexo.setBounds(10, 83, 46, 25);
		frame.getContentPane().add(lblSexo);
		rdbtnMasculino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnMasculino.isSelected()) {
					rdbtnFeminino.setSelected(false);
				}
			}
		});

		rdbtnMasculino.setBounds(50, 80, 90, 31);
		frame.getContentPane().add(rdbtnMasculino);
		rdbtnFeminino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnFeminino.isSelected()) {
					rdbtnMasculino.setSelected(false);
				}
			}
		});

		rdbtnFeminino.setBounds(142, 80, 76, 31);
		frame.getContentPane().add(rdbtnFeminino);

		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrimeiraTela p = new PrimeiraTela();
				p.frame.setVisible(true);
				frame.dispose();
			}

		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(167, 256, 96, 29);
		frame.getContentPane().add(btnVoltar);
		
		JLabel lblPastaDasFotos = new JLabel("Pasta das Fotos:");
		lblPastaDasFotos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPastaDasFotos.setBounds(10, 180, 120, 25);
		frame.getContentPane().add(lblPastaDasFotos);
		
		textField_Fotos = new JTextField();
		textField_Fotos.setColumns(10);
		textField_Fotos.setBounds(58, 216, 205, 29);
		frame.getContentPane().add(textField_Fotos);
	}

	private void jButton1ActionPerformed(ActionEvent evt)
			throws IOException, InterruptedException, InstantiationException, IllegalAccessException {
		CC_addFotos_Sem_Mensagens t = new CC_addFotos_Sem_Mensagens();
		PegandoDad p = new PegandoDad();
		dados d = new dados();
		String userdir = System.getProperty("user.dir");
		if (rdbtnMasculino.isSelected()) {
			d.setNome(p.masculino());
			d.setPasta(userdir+"\\Masculino");

		} else if (rdbtnFeminino.isSelected()) {
			d.setNome(p.feminino());
			d.setPasta(userdir+"\\Feminino");
		}

		d.setTel_Email(textField_Telefone.getText());
		d.setSenha(String.copyValueOf(passwordField_senha.getPassword()));
		d.setPasta_fotos(textField_Fotos.getText());		
		t.test(d);
	}
}
