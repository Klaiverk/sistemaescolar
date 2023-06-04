import java.awt.EventQueue;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;

public class TelaCurso {

    private JFrame frame;
    private JTextField boxNome;
    private JTextField boxCurso;
    private JTextField boxRA;
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

        boxNome = new JTextField();
        boxNome.setText("Nome");
        boxNome.setBounds(10, 50, 86, 20);
        frame.getContentPane().add(boxNome);
        boxNome.setColumns(10);

        boxCurso = new JTextField();
        boxCurso.setText("Curso");
        boxCurso.setColumns(10);
        boxCurso.setBounds(239, 50, 86, 20);
        frame.getContentPane().add(boxCurso);

        boxRA = new JTextField();
        boxRA.setText("RA");
        boxRA.setColumns(10);
        boxRA.setBounds(470, 50, 86, 20);
        frame.getContentPane().add(boxRA);

        boxProfessor = new JTextField();
        boxProfessor.setText("Professor");
        boxProfessor.setColumns(10);
        boxProfessor.setBounds(722, 50, 86, 20);
        frame.getContentPane().add(boxProfessor);

        Object[] columnNames = {"Nome", "Curso", "RA", "Professor"};
        DefaultTableModel model = new DefaultTableModel(null, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(model);
        table.setBounds(10, 80, 798, 150);
        frame.getContentPane().add(table);        

        JButton botaoRegistro = new JButton("Registrar");
        botaoRegistro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object[] row = {boxNome.getText(), boxCurso.getText(), boxRA.getText(), boxProfessor.getText()};
                model.addRow(row);
                JOptionPane.showMessageDialog(null, "Dados registrados com sucesso!");
            }
        });
        botaoRegistro.setBounds(366, 238, 89, 23);
        frame.getContentPane().add(botaoRegistro);
    }
}
