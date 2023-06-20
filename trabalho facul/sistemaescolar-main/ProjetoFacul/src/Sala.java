import java.util.*;

public class Sala {
    private String nome;
    private String local;
    private int capacidadeTotal;
    private boolean disponivel;

    public Sala(String nome, String local, int capacidadeTotal) {
        this.nome = nome;
        this.local = local;
        this.capacidadeTotal = capacidadeTotal;
        this.disponivel = true;
    }

    // Getters e setters
    // ...

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getCapacidadeTotal() {
        return capacidadeTotal;
    }

    public void setCapacidadeTotal(int capacidadeTotal) {
        this.capacidadeTotal = capacidadeTotal;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
