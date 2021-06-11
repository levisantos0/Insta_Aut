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
import javax.swing.JRadioButton;

public class AdicionarFotos {

	JFrame frame;
	private JTextField Tf_User;
	private JPasswordField passwordField;
	private JTextField Pasta_Tfield;
	private final JRadioButton radioButton = new JRadioButton("Feminino");
	private JRadioButton radioButton_1 = new JRadioButton("Masculino");

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
		frame.setBounds(600, 350, 334, 235);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Add Fotos");

		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton1ActionPerformed(e);
			}
		});
		btnIniciar.setBounds(80, 156, 89, 23);
		frame.getContentPane().add(btnIniciar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrimeiraTela p = new PrimeiraTela();
				p.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnVoltar.setBounds(179, 156, 89, 23);
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
		lblPasta.setBounds(24, 118, 56, 23);
		frame.getContentPane().add(lblPasta);

		Pasta_Tfield = new JTextField();
		Pasta_Tfield.setColumns(10);
		Pasta_Tfield.setBounds(70, 116, 205, 29);
		frame.getContentPane().add(Pasta_Tfield);
		

		radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radioButton.isSelected()) {
					radioButton_1.setSelected(false);
				}
			}
		});
		radioButton.setBounds(162, 83, 76, 31);
		frame.getContentPane().add(radioButton);
		

		radioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (radioButton_1.isSelected()) {
					radioButton.setSelected(false);
				}
			}
		});
		radioButton_1.setBounds(70, 83, 90, 31);
		frame.getContentPane().add(radioButton_1);
		
		JLabel label = new JLabel("Sexo:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(30, 86, 46, 25);
		frame.getContentPane().add(label);
	}

	private void jButton1ActionPerformed(ActionEvent evt) {
		AddFotos a = new AddFotos();
		dados d = new dados();
		String userdir = System.getProperty("user.dir");
		if (radioButton_1.isSelected()) {
			d.setPasta(userdir+"\\Masculino");

		} else if (radioButton.isSelected()) {
			d.setPasta(userdir+"\\Feminino");
		}
		d.setUsuario(Tf_User.getText());
		d.setSenha(String.copyValueOf(passwordField.getPassword()));
		d.setPasta_fotos(Pasta_Tfield.getText());
		a.test(d);
	}
}
