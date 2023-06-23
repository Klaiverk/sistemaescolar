import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.AbstractButton;
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
    private JTextField textCelular;
    private JLabel lblEmail;
    private JTextField textEmail;
    private JTextField textEndereco;
    private JButton btnCadastrar;
    private JCheckBox checkBoxAluno;
    private JCheckBox checkBoxProfessor;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/bancosdedados";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "1204";

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaCadastro window = new TelaCadastro();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TelaCadastro() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(245, 245, 245));
        frame.setBounds(100, 100, 450, 388);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        textEmail.setBounds(22, 163, 96, 19);
        frame.getContentPane().add(textEmail);

        JLabel lblCelular = new JLabel("Celular");
        lblCelular.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
        lblCelular.setBounds(22, 236, 96, 13);
        frame.getContentPane().add(lblCelular);

        textEndereco = new JTextField();
        textEndereco.setColumns(10);
        textEndereco.setBounds(22, 207, 96, 19);
        frame.getContentPane().add(textEndereco);

        checkBoxAluno = new JCheckBox("Aluno");
        checkBoxAluno.setBounds(22, 285, 97, 23);
        frame.getContentPane().add(checkBoxAluno);

        checkBoxProfessor = new JCheckBox("Professor");
        checkBoxProfessor.setBounds(22, 311, 97, 23);
        frame.getContentPane().add(checkBoxProfessor);

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(177, 317, 96, 23);
        frame.getContentPane().add(btnCadastrar);
        btnCadastrar.addActionListener(e -> cadastrar());

        frame.setVisible(true);
    }

    private void cadastrar() {
        String nome = textNome.getText();
        String cpf = textCPF.getText();
        String celular = textCelular.getText();
        String email = textEmail.getText();
        String endereco = textEndereco.getText();

        if (nome.isEmpty() || cpf.isEmpty() || celular.isEmpty() || email.isEmpty() || endereco.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Preencha todos os campos obrigatórios");
            return;
        }

        if (!checkBoxAluno.isSelected() && !checkBoxProfessor.isSelected()) {
            JOptionPane.showMessageDialog(frame, "Selecione ao menos um tipo: Aluno ou Professor");
            return;
        }

        if (checkBoxAluno.isSelected() && checkBoxProfessor.isSelected()) {
            JOptionPane.showMessageDialog(frame, "Selecione apenas um tipo: Aluno ou Professor");
            return;
        }

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            if (checkBoxAluno.isSelected()) {
                String insertAlunoQuery = "INSERT INTO alunos (nome, cpf, celular, email, endereco, matricula) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement insertAlunoStmt = connection.prepareStatement(insertAlunoQuery);
                int matricula = generateMatricula(); // Função para gerar uma matrícula única
                insertAlunoStmt.setString(1, nome);
                insertAlunoStmt.setString(2, cpf);
                insertAlunoStmt.setString(3, celular);
                insertAlunoStmt.setString(4, email);
                insertAlunoStmt.setString(5, endereco);
                insertAlunoStmt.setInt(6, matricula);
                insertAlunoStmt.executeUpdate();
                JOptionPane.showMessageDialog(frame, "Cadastro de Aluno realizado com sucesso! Matrícula: " + matricula);
            } else if (checkBoxProfessor.isSelected()) {
                String insertProfessorQuery = "INSERT INTO professores (nome, cpf, celular, email, endereco, codigo_funcionario) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement insertProfessorStmt = connection.prepareStatement(insertProfessorQuery);
                String codigoFuncionario = generateCodigoFuncionario(); // Função para gerar um código único para o professor
                insertProfessorStmt.setString(1, nome);
                insertProfessorStmt.setString(2, cpf);
                insertProfessorStmt.setString(3, celular);
                insertProfessorStmt.setString(4, email);
                insertProfessorStmt.setString(5, endereco);
                insertProfessorStmt.setString(6, codigoFuncionario);
                insertProfessorStmt.executeUpdate();
                JOptionPane.showMessageDialog(frame, "Cadastro de Professor realizado com sucesso! Código do Funcionário: " + codigoFuncionario);
            }

            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Ocorreu um erro ao conectar ou executar a consulta: " + ex.getMessage());
        }
    }

    private int generateMatricula() {
        // Implemente a lógica para gerar uma matrícula única aqui
        // Pode ser um número sequencial, um número aleatório, ou qualquer outra lógica desejada
        // Neste exemplo, estou retornando um número aleatório entre 1000 e 9999
        Random random = new Random();
        return random.nextInt(9000) + 1000;
    }

    private String generateCodigoFuncionario() {
        // Implemente a lógica para gerar um código único para o professor aqui
        // Pode ser um número sequencial, um código baseado no nome, ou qualquer outra lógica desejada
        // Neste exemplo, estou retornando um código baseado no nome e na data atual
        String nome = textNome.getText().replaceAll("\\s", "").toLowerCase();
        String dataAtual = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        return nome + dataAtual;
    }
}
