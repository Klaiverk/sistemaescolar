import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
    private String[] columnNames = {"Carga Horária", "Código UC", "Descrição", "Nome UC"};

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
        frame.setBounds(100, 100, 800, 446);
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
        table = new JTable(new DefaultTableModel(
            new Object[][] {},
            new String[] {"Carga Horária", "Código UC", "Descrição", "Nome UC"}
        ));
        table.setRowHeight(25);
        table.setFont(new Font("Arial", Font.PLAIN, 11));

        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);

        
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.DARK_GRAY);
        header.setForeground(Color.BLACK);
        header.setFont(new Font("Arial", Font.BOLD, 14));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 0, 784, 407);
        contentPane.add(scrollPane);
    }

    private void preencherTabela() {
        String url = "jdbc:mysql://localhost:3306/bancosdedados?useSSL=false";
        String username = "root";
        String password = "1204";

        try {
            // Carrega o driver do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Estabelece a conexão com o banco de dados
            Connection connection = DriverManager.getConnection(url, username, password);

            // Cria uma declaração SQL
            Statement statement = connection.createStatement();

            // Verifica se o banco de dados "bancosdedados" já existe e, se não existir, cria-o
            String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS bancosdedados;";
            statement.executeUpdate(createDatabaseQuery);

            // Seleciona o banco de dados "bancosdedados"
            statement.execute("USE bancosdedados;");

            // Executa a consulta para obter os dados
            String query = "SELECT cargaHoraria, codigouc, descricao, nomeuc FROM uc";
            ResultSet resultSet = statement.executeQuery(query);

            // Cria uma lista para armazenar os dados do resultado
            List<Object[]> dataList = new ArrayList<>();

            // Preenche a lista com os dados do resultado
            while (resultSet.next()) {
                String cargaHoraria = resultSet.getString("cargaHoraria");
                String codigoUC = resultSet.getString("codigouc");
                String descricao = resultSet.getString("descricao");
                String nomeUC = resultSet.getString("nomeuc");

                Object[] row = {cargaHoraria, codigoUC, descricao, nomeUC};
                dataList.add(row);
            }

            // Converte a lista em uma matriz de dados
            Object[][] data = new Object[dataList.size()][4];
            for (int i = 0; i < dataList.size(); i++) {
                data[i] = dataList.get(i);
            }

            // Atualiza o modelo da tabela com os dados
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setDataVector(data, columnNames);

            // Fecha a conexão com o banco de dados
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
