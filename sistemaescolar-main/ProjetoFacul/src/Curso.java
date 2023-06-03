import java.util.*;


public class Curso {
    private Aluno[] alunos;
    private Professor[] professores;
    private Curso[]cursos;
    private Turma[] turmas;
    private Sala[] salas;
    private int numAlunos;
    private int numProfessores;
    private int numCursos;
    private int numTurmas;
    private int numSalas;

    public Curso(int maxAlunos, int maxProfessores, int maxCursos, int maxTurmas, int maxSalas) {
        alunos = new Aluno[maxAlunos];
        professores = new Professor[maxProfessores];
        cursos = new Curso[maxCursos];
        turmas = new Turma[maxTurmas];
        salas = new Sala[maxSalas];
        numAlunos = 0;
        numProfessores = 0;
        numCursos = 0;
        numTurmas = 0;
        numSalas = 0;
    }

    // Métodos para adicionar e obter informações dos alunos, professores, cursos, turmas e salas
    // ...

    public void adicionarAluno(Aluno aluno) {
        if (numAlunos < alunos.length) {
            alunos[numAlunos] = aluno;
            numAlunos++;
        } else {
            System.out.println("Limite de alunos atingido.");
        }
    }

    public void adicionarProfessor(Professor professor) {
        if (numProfessores < professores.length) {
            professores[numProfessores] = professor;
            numProfessores++;
        } else {
            System.out.println("Limite de professores atingido.");
        }
    }

    public void adicionarCurso(Curso curso) {
        if (numCursos < cursos.length) {
            cursos[numCursos] = curso;
            numCursos++;
        } else {
            System.out.println("Limite de cursos atingido.");
        }
    }

    public void adicionarTurma(Turma turma) {
        if (numTurmas < turmas.length) {
            turmas[numTurmas] = turma;
            numTurmas++;
        } else {
            System.out.println("Limite de turmas atingido.");
        }
    }

    public void adicionarSala(Sala sala) {
        if (numSalas < salas.length) {
            salas[numSalas] = sala;
            numSalas++;
        } else {
            System.out.println("Limite de salas atingido.");
        }
    }

    public Aluno[] getAlunos() {
        return alunos;
    }

    public Professor[] getProfessores() {
        return professores;
    }

    public Curso[] getCursos() {
        return cursos;
    }

    public Turma[] getTurmas() {
        return turmas;
    }

    public Sala[] getSalas() {
        return salas;
    }

    // Restante da implementação da classe
    // ...
}