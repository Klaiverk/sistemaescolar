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
        String url = "jdbc:mysql://localhost:3306/SistemaFaculdade";
        String username = "root";
        String password = "1204";

        try {
            // Estabelece a conexão com o banco de dados
            Connection connection = DriverManager.getConnection(url, username, password);

            // Cria uma declaração SQL
            Statement statement = connection.createStatement();

            // Executa a consulta para obter os dados
            String query = "SELECT cargaHoraria, codigouc, descricao, nomeuc FROM UC";
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

        } catch (SQLException e) {
            // Trate a exceção aqui, por exemplo, imprima a pilha de exceções
            e.printStackTrace();
        }
    }
}
