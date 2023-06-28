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

public class UcProfessor {

    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    private TelaInicial telaInicial; // Referência para a TelaInicial

    // Informações de conexão com o banco de dados
    private String url = "jdbc:mysql://localhost:3306/bancosdedados";
    private String user = "root";
    private String password = "5239";

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                TelaInicial telaInicial = new TelaInicial();
                UcProfessor window = new UcProfessor(telaInicial);
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * @wbp.parser.entryPoint
     */
    public UcProfessor(TelaInicial telaInicial) {
        this.telaInicial = telaInicial; // Atribui a referência da TelaInicial
        initialize();
        exibirProfessoresNaTabela(); // Exibe os professores na tabela
    }

    private void exibirProfessoresNaTabela() {
		// TODO Auto-generated method stub
		
	}

	private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(245, 245, 245));
        frame.setBounds(100, 100, 575, 380);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 559, 306);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblTitle = new JLabel("Lista de Professores");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitle.setBounds(190, 19, 180, 20);
        panel.add(lblTitle);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 50, 539, 245);
        panel.add(scrollPane);

        table = new JTable();
        tableModel = new DefaultTableModel(
                new Object[][] {},
                new String[] { "Nome", "CPF", "Matrícula", "Curso", "Turma" }
        );
        table.setModel(tableModel);
        scrollPane.setViewportView(table);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(246, 307, 89, 23);
        frame.getContentPane().add(btnVoltar);
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Ação a ser executada quando o botão "Voltar" for clicado
                frame.dispose(); // Fecha a janela atual
                telaInicial.getFrame().setVisible(true); // Exibe a TelaInicial novamente
            }
        });

        loadDataFromDatabase();
    }

    private void loadDataFromDatabase() {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM professor");

            while (resultSet.next()) {
                String nome_Professor = resultSet.getString("nome_Professor");
                String CPF = resultSet.getString("CPF");
                String matricula = resultSet.getString("matricula");
                String curso = resultSet.getString("Curso");
                String turma = resultSet.getString("turma");

                String[] professor = { nome_Professor, CPF, matricula, curso, turma };
                tableModel.addRow(professor);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void show() {
        frame.setVisible(true);
    }
}
