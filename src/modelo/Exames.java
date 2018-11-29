package modelo;

public class Exames {
    private String disciplinaExame;
    private String nomeExame;
    private String anotacoesExame;
    private String salaExame;
    private String descricaoExame;
    private int dateExame;
    private int horaExame;
    private int duracaoExame;
    private int notasExame;

    public Exames(String disciplinaExame, String nomeExame, String anotacoesExame, String salaExame, String descricaoExame, int dateExame, int horaExame, int duracaoExame, int notasExame, int mediaExame) {
        this.disciplinaExame = disciplinaExame;
        this.nomeExame = nomeExame;
        this.anotacoesExame = anotacoesExame;
        this.salaExame = salaExame;
        this.descricaoExame = descricaoExame;
        this.dateExame = dateExame;
        this.horaExame = horaExame;
        this.duracaoExame = duracaoExame;
        this.notasExame = notasExame;
    }

    public Exames(String disciplinaExame, String nomeExame, String anotacoesExame, String salaExame, int dateExame, int horaExame, int notasExame, int mediaExame) {
        this.disciplinaExame = disciplinaExame;
        this.nomeExame = nomeExame;
        this.anotacoesExame = anotacoesExame;
        this.salaExame = salaExame;
        this.dateExame = dateExame;
        this.horaExame = horaExame;
        this.notasExame = notasExame;
    }

    public Exames(String disciplinaExame, String nomeExame, int notasExame, int mediaExame) {
        this.disciplinaExame = disciplinaExame;
        this.nomeExame = nomeExame;
        this.notasExame = notasExame;
    }

    public String getDisciplinaExame() {
        return disciplinaExame;
    }

    public void setDisciplinaExame(String disciplinaExame) {
        this.disciplinaExame = disciplinaExame;
    }

    public String getNomeExame() {
        return nomeExame;
    }

    public void setNomeExame(String nomeExame) {
        this.nomeExame = nomeExame;
    }

    public String getAnotacoesExame() {
        return anotacoesExame;
    }

    public void setAnotacoesExame(String anotacoesExame) {
        this.anotacoesExame = anotacoesExame;
    }

    public String getSalaExame() {
        return salaExame;
    }

    public void setSalaExame(String salaExame) {
        this.salaExame = salaExame;
    }

    public String getDescricaoExame() {
        return descricaoExame;
    }

    public void setDescricaoExame(String descricaoExame) {
        this.descricaoExame = descricaoExame;
    }

    public int getDateExame() {
        return dateExame;
    }

    public void setDateExame(int dateExame) {
        this.dateExame = dateExame;
    }

    public int getHoraExame() {
        return horaExame;
    }

    public void setHoraExame(int horaExame) {
        this.horaExame = horaExame;
    }

    public int getDuracaoExame() {
        return duracaoExame;
    }

    public void setDuracaoExame(int duracaoExame) {
        this.duracaoExame = duracaoExame;
    }

    public int getNotasExame() {
        return notasExame;
    }

    public void setNotasExame(int notasExame) {
        this.notasExame = notasExame;
    }

    
    
}
