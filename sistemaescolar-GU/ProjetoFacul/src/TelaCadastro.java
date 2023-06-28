import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaCadastro {

    private JFrame frame;
    private JTextField textNome;
    private JTextField textCPF;
    private JTextField textCurso;
    private JLabel lblEmail;
    private JTextField textEmail;
    private JTextField textEndereco;
    private JButton btnCadastrar;
    private JCheckBox checkBoxAluno;
    private JCheckBox checkBoxProfessor;
    private JTextField textField;

    private TelaInicial telaInicial; // Referência à tela TelaInicial

    private static final String DB_URL = "jdbc:mysql://localhost:3306/bancosdedados";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "5239";

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                TelaCadastro window = new TelaCadastro();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public TelaCadastro() {
        initialize();
    }

    public void setTelaInicial(TelaInicial telaInicial) {
        this.telaInicial = telaInicial;
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(245, 245, 245));
        frame.setBounds(100, 100, 496, 441);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        textNome = new JTextField();
        textNome.setBounds(26, 65, 96, 19);
        frame.getContentPane().add(textNome);
        textNome.setColumns(10);

        textCPF = new JTextField();
        textCPF.setBounds(26, 109, 96, 19);
        frame.getContentPane().add(textCPF);
        textCPF.setColumns(10);

        textCurso = new JTextField();
        textCurso.setBounds(26, 277, 96, 19);
        frame.getContentPane().add(textCurso);
        textCurso.setColumns(10);

        JLabel lblNome = new JLabel("Nome");
        lblNome.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
        lblNome.setBounds(26, 51, 45, 13);
        frame.getContentPane().add(lblNome);

        JLabel lblEndereco = new JLabel("Endereco");
        lblEndereco.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
        lblEndereco.setBounds(26, 183, 96, 13);
        frame.getContentPane().add(lblEndereco);

        JLabel lblCPF = new JLabel("CPF");
        lblCPF.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
        lblCPF.setBounds(26, 95, 45, 13);
        frame.getContentPane().add(lblCPF);

        JLabel lblCadastro = new JLabel("Cadastro");
        lblCadastro.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
        lblCadastro.setBounds(177, 11, 128, 32);
        frame.getContentPane().add(lblCadastro);

        lblEmail = new JLabel("E-mail");
        lblEmail.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
        lblEmail.setBounds(26, 139, 63, 13);
        frame.getContentPane().add(lblEmail);

        textEmail = new JTextField();
        textEmail.setColumns(10);
        textEmail.setBounds(26, 153, 96, 19);
        frame.getContentPane().add(textEmail);

        JLabel lblCelular = new JLabel("Curso");
        lblCelular.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
        lblCelular.setBounds(26, 262, 96, 13);
        frame.getContentPane().add(lblCelular);

        textEndereco = new JTextField();
        textEndereco.setColumns(10);
        textEndereco.setBounds(26, 197, 96, 19);
        frame.getContentPane().add(textEndereco);

        checkBoxAluno = new JCheckBox("Aluno");
        checkBoxAluno.setBounds(26, 315, 97, 23);
        frame.getContentPane().add(checkBoxAluno);

        checkBoxProfessor = new JCheckBox("Professor");
        checkBoxProfessor.setBounds(26, 341, 97, 23);
        frame.getContentPane().add(checkBoxProfessor);

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(194, 368, 96, 23);
        frame.getContentPane().add(btnCadastrar);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(26, 11, 96, 23);
        frame.getContentPane().add(btnVoltar);
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Ação a ser executada quando o botão "Voltar" for clicado
                if (telaInicial != null) {
                    telaInicial.getFrame().setVisible(true);
                }
                frame.dispose();
            }
        });

        JLabel lblCelular_1 = new JLabel("Celular");
        lblCelular_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
        lblCelular_1.setBounds(26, 227, 96, 13);
        frame.getContentPane().add(lblCelular_1);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(26, 241, 96, 19);
        frame.getContentPane().add(textField);

        btnCadastrar.addActionListener(e -> cadastrar());

        frame.setVisible(true);
    }

    private void cadastrar() {
        String nome = textNome.getText();
        String cpf = textCPF.getText();
        String email = textEmail.getText();
        String endereco = textEndereco.getText();
        String curso = textCurso.getText();
        String celular = textField.getText();
        boolean isAluno = checkBoxAluno.isSelected();
        boolean isProfessor = checkBoxProfessor.isSelected();

        // Validar os campos necessários antes de prosseguir com o cadastro
        if (nome.isEmpty() || cpf.isEmpty() || email.isEmpty() || endereco.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Preencha todos os campos obrigatórios!");
            return;
        }

        // Realizar o cadastro no banco de dados ou executar outras ações relacionadas ao cadastro
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            String query = "INSERT INTO tabela_usuarios (nome, cpf, email, endereco, curso, celular, aluno, professor) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, nome);
            statement.setString(2, cpf);
            statement.setString(3, email);
            statement.setString(4, endereco);
            statement.setString(5, curso);
            statement.setString(6, celular);
            statement.setBoolean(7, isAluno);
            statement.setBoolean(8, isProfessor);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(frame, "Cadastro realizado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame, "Erro ao cadastrar: " + e.getMessage());
        }
    }
}
