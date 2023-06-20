import java.util.*;
public class UC {
    private String codigoUC;
    private String nomeUC;
    private int cargaHoraria;
    private String descricao;

    public UC(String codigoUC, String nomeUC, int cargaHoraria, String descricao) {
        this.codigoUC = codigoUC;
        this.nomeUC = nomeUC;
        this.cargaHoraria = cargaHoraria;
        this.descricao = descricao;
    }

    public String getCodigoUC() {
        return codigoUC;
    }

    public void setCodigoUC(String codigoUC) {
        this.codigoUC = codigoUC;
    }

    public String getNomeUC() {
        return nomeUC;
    }

    public void setNomeUC(String nomeUC) {
        this.nomeUC = nomeUC;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
