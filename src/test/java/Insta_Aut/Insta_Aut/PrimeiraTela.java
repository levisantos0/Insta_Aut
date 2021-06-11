package Insta_Aut.Insta_Aut;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PrimeiraTela {

	JFrame frame;

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
					PrimeiraTela window = new PrimeiraTela();
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
	public PrimeiraTela() {
		frame = new JFrame();
		frame.setBounds(600, 350, 263, 235);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Home");
		
		JButton btnNewButton = new JButton("Criar Conta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CriarConta frame1 = new CriarConta();
				frame1.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(66, 20, 114, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Adicionar fotos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdicionarFotos ft = new AdicionarFotos();
				ft.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(66, 54, 114, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnCriarContaSem = new JButton("Criar conta sem o 'Mensagens'");
		btnCriarContaSem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CC_SemMensagens_Tela cc = new CC_SemMensagens_Tela();
				cc.frame.setVisible(true);
				frame.dispose();				
			}
		});
		btnCriarContaSem.setBounds(20, 123, 209, 23);
		frame.getContentPane().add(btnCriarContaSem);
		
		JButton btnCriarContaadd = new JButton("Criar conta + Add fotos");
		btnCriarContaadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CC_addFotosTela cc = new CC_addFotosTela();
				cc.frame.setVisible(true);
				frame.dispose();	
			}
		});
		btnCriarContaadd.setBounds(20, 89, 209, 23);
		frame.getContentPane().add(btnCriarContaadd);
		
		JButton btnCriarContaSem_1 = new JButton("CC sem o 'Mensagens' + add fotos");
		btnCriarContaSem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CC_addFotos_Sem_Mensagens_Tela cc = new CC_addFotos_Sem_Mensagens_Tela();
				cc.frame.setVisible(true);
				frame.dispose();	
			}
		});
		btnCriarContaSem_1.setBounds(10, 157, 226, 23);
		frame.getContentPane().add(btnCriarContaSem_1);
	}
}
