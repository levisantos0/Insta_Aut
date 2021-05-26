package Insta_Aut.Insta_Aut;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AdicionarFotos {

	JFrame frame;
	private JTextField Tf_User;
	private JPasswordField passwordField;
	private JTextField Pasta_Tfield;

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
					AdicionarFotos window = new AdicionarFotos();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdicionarFotos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(600, 350, 334, 254);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Add Fotos");

		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton1ActionPerformed(e);
			}
		});
		btnIniciar.setBounds(70, 164, 89, 23);
		frame.getContentPane().add(btnIniciar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrimeiraTela p = new PrimeiraTela();
				p.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnVoltar.setBounds(169, 164, 89, 23);
		frame.getContentPane().add(btnVoltar);

		JLabel lblUsurio = new JLabel("Usuário:");
		lblUsurio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsurio.setBounds(12, 18, 56, 23);
		frame.getContentPane().add(lblUsurio);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSenha.setBounds(20, 53, 56, 23);
		frame.getContentPane().add(lblSenha);

		Tf_User = new JTextField();
		Tf_User.setBounds(70, 14, 205, 29);
		frame.getContentPane().add(Tf_User);
		Tf_User.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(70, 51, 205, 29);
		frame.getContentPane().add(passwordField);

		JLabel lblPasta = new JLabel("Pasta:");
		lblPasta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPasta.setBounds(24, 102, 56, 23);
		frame.getContentPane().add(lblPasta);

		Pasta_Tfield = new JTextField();
		Pasta_Tfield.setColumns(10);
		Pasta_Tfield.setBounds(70, 100, 205, 29);
		frame.getContentPane().add(Pasta_Tfield);
	}

	private void jButton1ActionPerformed(ActionEvent evt) {
		AddFotos a = new AddFotos();
		dados d = new dados();
		d.setUsuario(Tf_User.getText());
		d.setSenha(String.copyValueOf(passwordField.getPassword()));
		d.setPasta(Pasta_Tfield.getText());
		a.test(d);
	}

}
