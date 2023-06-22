import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class TelaLogin {

    private JFrame frame;
    private JTextField textFieldUsuario;
    private JTextField textFieldSenha;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaLogin window = new TelaLogin();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TelaLogin() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 300, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblUsuario = new JLabel("Usuário");
        lblUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblUsuario.setBounds(30, 40, 60, 20);
        frame.getContentPane().add(lblUsuario);

        textFieldUsuario = new JTextField();
        textFieldUsuario.setBounds(100, 40, 150, 20);
        frame.getContentPane().add(textFieldUsuario);
        textFieldUsuario.setColumns(10);

        JLabel lblSenha = new JLabel("Senha");
        lblSenha.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSenha.setBounds(30, 80, 60, 20);
        frame.getContentPane().add(lblSenha);

        textFieldSenha = new JTextField();
        textFieldSenha.setBounds(100, 80, 150, 20);
        frame.getContentPane().add(textFieldSenha);
        textFieldSenha.setColumns(10);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = textFieldUsuario.getText();
                String senha = textFieldSenha.getText();

                if (usuario.equals("admin") && senha.equals("admin")) {
                    JOptionPane.showMessageDialog(null, "Login bem-sucedido!");
                    // Faça a ação desejada após o login ser bem-sucedido
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos!");
                }
            }
        });
        btnLogin.setBounds(100, 120, 89, 23);
        frame.getContentPane().add(btnLogin);

        JButton btnRegistro = new JButton("Registro");
        btnRegistro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Redirecionar para a tela de registro
            	TelaCadastro TelaCadastro = new TelaCadastro();
            	TelaCadastro.setVisible(true);
                frame.dispose();
            }
        });
        btnRegistro.setBounds(100, 160, 89, 23);
        frame.getContentPane().add(btnRegistro);
    }
}