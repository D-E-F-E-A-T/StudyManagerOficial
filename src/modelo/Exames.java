package modelo;

import java.util.Date;
import java.util.Objects;

public class Exames {
    private String nome;
    private String conteudo;
    private double nota;
    private String sala;
    private Date data;

    public Exames(String nome, String conteudo, double nota, String sala, Date data) {
        this.nome = nome;
        this.conteudo = conteudo;
        this.nota = nota;
        this.sala = sala;
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public String getConteudo() {
        return conteudo;
    }

    public double getNota() {
        return nota;
    }

    public String getSala() {
        return sala;
    }

    public Date getData() {
        return data;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Exames{" + "nome=" + nome + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.nome);
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
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
    
    
}
