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

public class CriarConta {

	JFrame frame;
	private JLabel labelNome;
	private JLabel lblOUsurioSer;
	private JLabel lblSenha;
	private JTextField textField_Telefone;
	private JPasswordField passwordField_senha;
	private final JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
	private JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
	private JTextField textFieldPasta;
	private JButton btnVoltar;

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
					CriarConta window = new CriarConta();
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
	public CriarConta() {
		frame = new JFrame();
		frame.setBounds(600, 350, 334, 334);
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
		btnIniciar.setBounds(58, 248, 96, 29);
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
		
		JLabel lblPastaParaSalvar = new JLabel("Pasta para salvar senhas:");
		lblPastaParaSalvar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPastaParaSalvar.setBounds(10, 180, 253, 25);
		frame.getContentPane().add(lblPastaParaSalvar);
		
		textFieldPasta = new JTextField();
		textFieldPasta.setColumns(10);
		textFieldPasta.setBounds(58, 208, 205, 29);
		frame.getContentPane().add(textFieldPasta);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrimeiraTela p = new PrimeiraTela();
				p.frame.setVisible(true);
				frame.dispose();
			}
			
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(167, 248, 96, 29);
		frame.getContentPane().add(btnVoltar);
	}
	private void jButton1ActionPerformed(ActionEvent evt) throws IOException, InterruptedException, InstantiationException, IllegalAccessException{
		teste t = new teste();
		PegandoDad p = new PegandoDad();
		dados d = new dados();
		if (rdbtnMasculino.isSelected()) {
			d.setNome(p.masculino());

		} else if(rdbtnFeminino.isSelected()){
			d.setNome(p.feminino());
		}	

		d.setTel_Email(textField_Telefone.getText());
		d.setSenha(String.copyValueOf(passwordField_senha.getPassword()));
		d.setPasta(textFieldPasta.getText());

		t.test(d);
	}
}
