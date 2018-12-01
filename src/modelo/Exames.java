package modelo;

import java.util.Date;
import java.util.Objects;

public class Exames {
    private int id_exame;
    private String nome;
    private String conteudo;
    private double nota;
    private String sala;
    private Date data;
    private String anotacoes;

    public Exames(int id_exame, String nome, String conteudo, double nota, String sala, Date data, String anotacoes) {
        this.id_exame = id_exame;
        this.nome = nome;
        this.conteudo = conteudo;
        this.nota = nota;
        this.sala = sala;
        this.data = data;
        this.anotacoes = anotacoes;
    }

    public Exames(String nome, String conteudo, double nota, String sala, Date data, String anotacoes) {
        this.nome = nome;
        this.conteudo = conteudo;
        this.nota = nota;
        this.sala = sala;
        this.data = data;
        this.anotacoes = anotacoes;
    }

    public int getId_exame() {
        return id_exame;
    }

    public void setId_exame(int id_exame) {
        this.id_exame = id_exame;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.id_exame;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Exames other = (Exames) obj;
        if (this.id_exame != other.id_exame) {
            return false;
        }
        return true;
    }

   
    @Override
    public String toString() {
        return "Exames{" + "id_exame=" + id_exame + ", nome=" + nome + ", conteudo=" + conteudo + ", nota=" + nota + ", sala=" + sala + ", data=" + data + ", anotacoes=" + anotacoes + '}';
    }

   

   

    
}
