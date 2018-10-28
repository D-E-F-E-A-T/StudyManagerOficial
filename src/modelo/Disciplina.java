package modelo;

public class Disciplina {
    private String nomeDisciplina;
    private String assuntoDisciplina;
    private String descricaoDisciplina;
    private String anotacoesDisciplina;

    public Disciplina(String nomeDisciplina, String assuntoDisciplina, String descricaoDisciplina, String anotacoesDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.assuntoDisciplina = assuntoDisciplina;
        this.descricaoDisciplina = descricaoDisciplina;
        this.anotacoesDisciplina = anotacoesDisciplina;
    }

    public Disciplina(String nomeDisciplina, String assuntoDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.assuntoDisciplina = assuntoDisciplina;
    }

    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public String getAssuntoDisciplina() {
        return assuntoDisciplina;
    }

    public void setAssuntoDisciplina(String assuntoDisciplina) {
        this.assuntoDisciplina = assuntoDisciplina;
    }

    public String getDescricaoDisciplina() {
        return descricaoDisciplina;
    }

    public void setDescricaoDisciplina(String descricaoDisciplina) {
        this.descricaoDisciplina = descricaoDisciplina;
    }

    public String getAnotacoesDisciplina() {
        return anotacoesDisciplina;
    }

    public void setAnotacoesDisciplina(String anotacoesDisciplina) {
        this.anotacoesDisciplina = anotacoesDisciplina;
    }
    
}
