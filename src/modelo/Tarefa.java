package modelo;

import java.util.Date;
import java.util.Objects;


public class Tarefa {
   private String nome;
   private String assunto;
   private Disciplina disciplina;
   private Date data;

    public Tarefa(String nome, String assunto, Disciplina disciplina, Date data) {
        this.nome = nome;
        this.assunto = assunto;
        this.disciplina = disciplina;
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public String getAssunto() {
        return assunto;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public Date getData() {
        return data;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.nome);
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
        final Tarefa other = (Tarefa) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tarefa{" + "nome=" + nome + '}';
    }
   
    
    
}
