import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Curso {

    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	Curso window = new Curso();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Curso() {
        initialize();
        adicionarCursosAtivos();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblListaCursosAtivos = new JLabel("Lista de Cursos Ativos");
        lblListaCursosAtivos.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblListaCursosAtivos.setBounds(10, 11, 414, 30);
        frame.getContentPane().add(lblListaCursosAtivos);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 51, 414, 198);
        frame.getContentPane().add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nome do Curso");
        tableModel.addColumn("Professor");
        tableModel.addColumn("Sala Alocada");
        tableModel.addColumn("Lista de Alunos");
        table.setModel(tableModel);
    }

    private void adicionarCursosAtivos() {
        // Adicione aqui os cursos ativos
        adicionarCurso("Matemática", "Prof. João", "Sala A", "João, Maria");
        adicionarCurso("História", "Prof. Ana", "Sala B", "Pedro, Carla, Lucas");
    }

    private void adicionarCurso(String nome, String professor, String sala, String listaAlunos) {
        String[] rowData = { nome, professor, sala, listaAlunos };
        tableModel.addRow(rowData);
    }
}
