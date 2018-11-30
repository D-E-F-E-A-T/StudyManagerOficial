package modelo;

import java.util.Objects;

public class Disciplina {
    private String nome;
    private String conteudo;
    private String anotacoes;
    private String horario;
    private int id_disciplina;

    public Disciplina(String nome, String conteudo, String anotacoes) {
        this.nome = nome;
        this.conteudo = conteudo;
        this.anotacoes = anotacoes;    
    }

    public Disciplina(String nome, String conteudo, String anotacoes, String horario, int id_disciplina) {
        this.nome = nome;
        this.conteudo = conteudo;
        this.anotacoes = anotacoes;
        this.horario = horario;
        this.id_disciplina = id_disciplina;
    }

    public int getId_disciplina() {
        return id_disciplina;
    }
    
    

    public String getNome() {
        return nome;
    }

    public String getConteudo() {
        return conteudo;
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public String getHorario() {
        return horario;
    }

    public void setId_disciplina(int id_disciplina) {
        this.id_disciplina = id_disciplina;
    }
    
  
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Disciplina{" + "nome=" + nome + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.nome);
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
        final Disciplina other = (Disciplina) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    
}
