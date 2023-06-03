import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.DropMode;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import java.awt.Component;
import javax.swing.Box;

public class Janela {

	private JFrame frame;
	private JTextField textNome;
	private JTextField textCPF;
	private JTextField textCelular;
	private JLabel lblEmail_1;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
        } catch (InstantiationException ex) {
        	System.err.println(ex);
        } catch (IllegalAccessException ex) {
        	System.err.println(ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        	System.err.println(ex);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela window = new Janela();
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
	public Janela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.BLUE);
		frame.setForeground(new Color(0, 0, 0));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(new Color(245, 245, 245));
		frame.setBounds(100, 100, 450, 344);
		frame.getContentPane().setLayout(null);
		
		textNome = new JTextField();
		textNome.setBounds(22, 75, 96, 19);
		frame.getContentPane().add(textNome);
		textNome.setColumns(10);
		
		textCPF = new JTextField();
		textCPF.setBounds(22, 119, 96, 19);
		frame.getContentPane().add(textCPF);
		textCPF.setColumns(10);
		
		textCelular = new JTextField();
		textCelular.setBounds(22, 249, 96, 19);
		frame.getContentPane().add(textCelular);
		textCelular.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblNome.setBounds(22, 61, 45, 13);
		frame.getContentPane().add(lblNome);
		
		JLabel lblEndereco = new JLabel("Endereco");
		lblEndereco.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblEndereco.setBounds(22, 193, 96, 13);
		frame.getContentPane().add(lblEndereco);
		
		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblCPF.setBounds(22, 105, 45, 13);
		frame.getContentPane().add(lblCPF);
		
		JLabel lblCadastro = new JLabel("Cadastro");
		lblCadastro.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		lblCadastro.setBounds(177, 11, 128, 32);
		frame.getContentPane().add(lblCadastro);
		
		lblEmail_1 = new JLabel("E-mail");
		lblEmail_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblEmail_1.setBounds(22, 149, 63, 13);
		frame.getContentPane().add(lblEmail_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(22, 163, 96, 19);
		frame.getContentPane().add(textField);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblCelular.setBounds(22, 236, 96, 13);
		frame.getContentPane().add(lblCelular);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(22, 206, 96, 19);
		frame.getContentPane().add(textField_1);
	}
}
