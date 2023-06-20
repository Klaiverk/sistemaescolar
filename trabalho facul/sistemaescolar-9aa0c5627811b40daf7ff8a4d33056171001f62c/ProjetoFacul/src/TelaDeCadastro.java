import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TelaDeCadastro {

    private JFrame frame;
    private JTextField textNome;
    private JTextField textCPF;
    private JTextField textCelular;
    private JLabel lblEmail;
    private JTextField textEmail;
    private JTextField textEndereco;
    private JButton btnCadastrar;
    private Connection conn;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaDeCadastro window = new TelaDeCadastro();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TelaDeCadastro() {
        initialize();
        conectarBancoDados();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBackground(Color.BLUE);
        frame.setForeground(new Color(0, 0, 0));
        frame.getContentPane().setForeground(new Color(0, 0, 0));
        frame.getContentPane().setBackground(new Color(245, 245, 245));
        frame.setBounds(100, 100, 450, 388);
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

        lblEmail = new JLabel("E-mail");
        lblEmail.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
        lblEmail.setBounds(22, 149, 63, 13);
        frame.getContentPane().add(lblEmail);

        textEmail = new JTextField();
        textEmail.setColumns(10);
        textEmail.setBounds
    }
}
