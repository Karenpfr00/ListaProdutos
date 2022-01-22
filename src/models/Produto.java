package models;
import java.util.Date;


public class Produto {
    private int id;
    private String descricao;
    private double preço;
    private Date dataValidade;

    public Produto(int id, String descricao, double preço, Date dataValidade){
        this.id = id;
        this.descricao = descricao;
        this.preço = preço;
        this.dataValidade = dataValidade;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreço() {
        return preço;
    }

    public Date getDataValidade() {
        return dataValidade;
    }
}