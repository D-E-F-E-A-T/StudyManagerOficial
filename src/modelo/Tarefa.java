package modelo;



import java.util.Date;
import java.util.Objects;


public class Tarefa {
   private int id_tarefa;
   private String nome;
   private String assunto;
   private int disciplina;
   private Date data;

    public Tarefa(String nome, String assunto, int disciplina, Date  data) {
        this.nome = nome;
        this.assunto = assunto;
        this.disciplina = disciplina;
        this.data = data;
    }

    public Tarefa(int id_tarefa, String nome, String assunto, int disciplina, Date  data) {
        this.id_tarefa = id_tarefa;
        this.nome = nome;
        this.assunto = assunto;
        this.disciplina = disciplina;
        this.data = data;
    }

    public int getId_tarefa() {
        return id_tarefa;
    }
    
    public String getNome() {
        return nome;
    }

    public String getAssunto() {
        return assunto;
    }

    public int getDisciplina() {
        return disciplina;
    }

    /**
     *
     * @return
     */
    public Date  getData() {
        return data;
    }

    public void setId_tarefa(int id_tarefa) {
        this.id_tarefa = id_tarefa;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public void setDisciplina(int disciplina) {
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
        return "Tarefa{" + "id_tarefa=" + id_tarefa + ", nome=" + nome + ", assunto=" + assunto + ", disciplina=" + disciplina + ", data=" + data + '}';
    }

    
    
}
