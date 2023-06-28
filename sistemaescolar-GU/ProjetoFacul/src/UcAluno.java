import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UcAluno {

    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    private TelaInicial telaInicial;

    // Informações de conexão com o banco de dados
    private String url = "jdbc:mysql://localhost:3306/bancosdedados";
    private String user = "root";
    private String password = "5239";

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                UcAluno window = new UcAluno();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * @wbp.parser.entryPoint
     */
    public UcAluno() {
        initialize();
    }

    public UcAluno(TelaInicial telaInicial) {
        this.telaInicial = telaInicial;
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 575, 380);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 559, 306);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblTitle = new JLabel("Lista de Alunos");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitle.setBounds(220, 19, 150, 20);
        panel.add(lblTitle);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 50, 539, 245);
        panel.add(scrollPane);

        table = new JTable();
        tableModel = new DefaultTableModel(
                new Object[][] {},
                new String[] { "Nome", "CPF", "Endereço", "Matrícula", "Turma", "Curso" }
        );
        table.setModel(tableModel);
        scrollPane.setViewportView(table);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(246, 307, 89, 23);
        frame.getContentPane().add(btnVoltar);
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (telaInicial != null) {
                    telaInicial.getFrame().setVisible(true);
                }
                frame.dispose();
            }
        });

        loadDataFromDatabase();
    }

    private void loadDataFromDatabase() {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM aluno");

            while (resultSet.next()) {
                String nome_Aluno = resultSet.getString("nome_Aluno");
                String CPF = resultSet.getString("cpf");
                String endereco = resultSet.getString("endereco");
                String matricula = resultSet.getString("matricula");
                String turma = resultSet.getString("turma");
                String curso = resultSet.getString("curso");

                String[] aluno = { nome_Aluno, CPF, endereco, matricula, turma, curso };
                tableModel.addRow(aluno);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public void show() {
		// TODO Auto-generated method stub
		
	}
}
