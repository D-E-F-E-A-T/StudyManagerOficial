package modelo;

public class Usuario {
    private int idUsuario;
    private String nomeUsuario;
    private String universidadeUsuario;
    private String emailUsuario;

    public Usuario(String nomeUsuario, String universidadeUsuario, String emailUsuario) {
        this.nomeUsuario = nomeUsuario;
        this.universidadeUsuario = universidadeUsuario;
        this.emailUsuario = emailUsuario;
    }

    public Usuario(int idUsuario, String nomeUsuario, String universidadeUsuario, String emailUsuario) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.universidadeUsuario = universidadeUsuario;
        this.emailUsuario = emailUsuario;
    }

    public Usuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public Usuario() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getUniversidadeUsuario() {
        return universidadeUsuario;
    }

    public void setUniversidadeUsuario(String universidadeUsuario) {
        this.universidadeUsuario = universidadeUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nomeUsuario=" + nomeUsuario + '}';
    }
    
    
}
