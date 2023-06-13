import java.awt.EventQueue;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;

public class TelaCurso {

    private JFrame frame;
    private JTextField boxAluno;
    private JTextField boxSala;
    private JTextField boxTurma;
    private JTextField boxProfessor;
    private JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaCurso window = new TelaCurso();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TelaCurso() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 834, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        boxAluno = new JTextField();
        boxAluno.setBounds(10, 35, 86, 20);
        frame.getContentPane().add(boxAluno);
        boxAluno.setColumns(10);

        boxSala = new JTextField();
        boxSala.setColumns(10);
        boxSala.setBounds(218, 35, 86, 20);
        frame.getContentPane().add(boxSala);

        boxTurma = new JTextField();
        boxTurma.setColumns(10);
        boxTurma.setBounds(445, 35, 86, 20);
        frame.getContentPane().add(boxTurma);

        boxProfessor = new JTextField();
        boxProfessor.setColumns(10);
        boxProfessor.setBounds(673, 35, 86, 20);
        frame.getContentPane().add(boxProfessor);

        Object[] columnNames = {"Nome", "Curso", "RA", "Professor"};
        DefaultTableModel model = new DefaultTableModel(null, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JLabel rodape_Professor = new JLabel("Professor");
        rodape_Professor.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 11));
        rodape_Professor.setBounds(673, 4, 86, 20);
        frame.getContentPane().add(rodape_Professor);

        JButton botaoRegistro = new JButton("Registrar");
        botaoRegistro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object[] row = {boxAluno.getText(), boxSala.getText(), boxTurma.getText(), boxProfessor.getText()};
                model.addRow(row);
                JOptionPane.showMessageDialog(null, "Dados registrados com sucesso!");
            }
        });
        botaoRegistro.setBounds(366, 238, 89, 23);
        frame.getContentPane().add(botaoRegistro);
        
        JLabel rodape_Aluno = new JLabel("Aluno");
        rodape_Aluno.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 11));
        rodape_Aluno.setBounds(10, 11, 86, 20);
        frame.getContentPane().add(rodape_Aluno);
        
        JLabel rodape_sala = new JLabel("Sala");
        rodape_sala.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 11));
        rodape_sala.setBounds(218, 4, 86, 20);
        frame.getContentPane().add(rodape_sala);
        
        JLabel rodape_Turma = new JLabel("Turma");
        rodape_Turma.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 11));
        rodape_Turma.setBounds(445, 4, 86, 20);
        frame.getContentPane().add(rodape_Turma);
        
                table = new JTable(model);
                table.setBounds(10, 81, 798, 150);
                frame.getContentPane().add(table);
    }
}
