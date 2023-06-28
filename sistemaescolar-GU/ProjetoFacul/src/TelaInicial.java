import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class TelaInicial {

    private JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaInicial window = new TelaInicial();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TelaInicial() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnCadastro = new JButton("Cadastro");
        btnCadastro.setBounds(162, 45, 117, 29);
        frame.getContentPane().add(btnCadastro);
        btnCadastro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Ação a ser executada quando o botão "Cadastro" for clicado
                TelaCadastro telaCadastro = new TelaCadastro();
                // telaCadastro.setTelaUC(UcTela); // Substitua UcTela pelo objeto da tela UC desejada
            }
        });

        JButton btnTelaProfessor = new JButton("Tela Professor");
        btnTelaProfessor.setBounds(162, 101, 117, 29);
        frame.getContentPane().add(btnTelaProfessor);
        btnTelaProfessor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Ação a ser executada quando o botão "Tela Professor" for clicado
                UcProfessor ucProfessor = new UcProfessor(TelaInicial.this); // Passa a referência da TelaInicial
                ucProfessor.main(null);
            }
        });

        JButton btnTelaAluno = new JButton("Tela Aluno");
        btnTelaAluno.setBounds(162, 157, 117, 29);
        frame.getContentPane().add(btnTelaAluno);
        btnTelaAluno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Ação a ser executada quando o botão "Tela Aluno" for clicado
                UcAluno ucAluno = new UcAluno();
                ucAluno.main(null);
            }
        });
    }

    public JFrame getFrame() {
        return frame;
    }
}