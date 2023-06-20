import java.util.*;

public class Turma {
    private String codigoTurma;
    private Curso curso;
    private Professor professor;
    private Sala sala;
    private Aluno[] alunos;
    private int numAlunos;

    public Turma(String codigoTurma, Curso curso, Professor professor, Sala sala, int capacidadeMaxima) {
        this.codigoTurma = codigoTurma;
        this.curso = curso;
        this.professor = professor;
        this.sala = sala;
        this.alunos = new Aluno[capacidadeMaxima];
        this.numAlunos = 0;
    }

   
    public String getCodigoTurma() {
        return codigoTurma;
    }

    public void setCodigoTurma(String codigoTurma) {
        this.codigoTurma = codigoTurma;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public int getNumAlunos() {
        return numAlunos;
    }

    public void adicionarAluno(Aluno aluno) {
        if (numAlunos < alunos.length) {
            alunos[numAlunos] = aluno;
            numAlunos++;
        } else {
            System.out.println("Capacidade máxima da turma atingida!");
        }
    }

    public void removerAluno(Aluno aluno) {
        for (int i = 0; i < numAlunos; i++) {
            if (alunos[i].equals(aluno)) {
                for (int j = i; j < numAlunos - 1; j++) {
                    alunos[j] = alunos[j + 1];
                }
                alunos[numAlunos - 1] = null;
                numAlunos--;
                return;
            }
        }
        System.out.println("Aluno não encontrado na turma!");
    }
}
