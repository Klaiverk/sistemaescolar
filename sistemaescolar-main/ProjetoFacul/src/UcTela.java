import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class UcTela {

    private JFrame frame;
    private JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Configura o look and feel do sistema
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

                    UcTela window = new UcTela();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public UcTela() {
        initialize();
        preencherTabela();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);
        frame.setContentPane(contentPane);

        // Cabeçalho da tabela
        String[] columnNames = {"Carga Horária", "Código UC", "Descrição", "Nome UC"};

        // Dados vazios inicialmente
        Object[][] data = {};

        // Cria a tabela
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);
        table.setRowHeight(25);
        table.setFont(new Font("Arial", Font.PLAIN, 14));

        // Alinha o conteúdo das células no centro
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);

        // Cabeçalho da tabela com estilo personalizado
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.DARK_GRAY);
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Arial", Font.BOLD, 14));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 414, 241);
        contentPane.add(scrollPane);
    }

    private void preencherTabela() {
        String url = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
        String username = "seu_usuario";
        String password = "sua_senha";

        try {
            // Estabelece a conexão com o banco de dados
            Connection connection = DriverManager.getConnection(url, username, password);

            // Cria uma declaração SQL
            Statement statement = connection.createStatement();

            // Executa a consulta para obter os dados
            String query = "SELECT cargaHoraria, codigouc, descricao, nomeuc FROM sua_tabela";
            ResultSet resultSet = statement.executeQuery(query);

            // Calcula a quantidade de linhas no resultado
            int rowCount = 0;
            if (resultSet.last()) {
                rowCount = resultSet.getRow();
                resultSet.beforeFirst(); // Volta para a posição inicial
            }

            // Cria a matriz
