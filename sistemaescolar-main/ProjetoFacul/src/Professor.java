import java.util.*;

public class Professor extends Pessoa {
    private String codigoFuncionario;

    public Professor(String nome, String cpf, String endereco, String email, String celular, String codigoFuncionario) {
        super(nome, cpf, endereco, email, celular);
        this.codigoFuncionario = codigoFuncionario;
    }

   
    public String getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(String codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }
}