import java.util.*;


public class Aluno extends Pessoa {
    private int matricula;

    public Aluno(String nome, String cpf, String endereco, String email, String celular, int matricula) {
        super(nome, cpf, endereco, email, celular);
        this.matricula = matricula;
    }

   

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
}