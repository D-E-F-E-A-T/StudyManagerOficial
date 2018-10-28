package modelo;

public class Usuario {
    private int idUsuario;
    private String nomeUsuario;
    private String universidadeUsuario;
    private String emailUsuario;
    private String senhaUsuario;
    
    public Usuario(String nomeUsuario, String universidadeUsuario, String emailUsuario,String senhaUsuario) {
        this.nomeUsuario = nomeUsuario;
        this.universidadeUsuario = universidadeUsuario;
        this.emailUsuario = emailUsuario;
        this.senhaUsuario= senhaUsuario;
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
    
    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + this.idUsuario;
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
        final Usuario other = (Usuario) obj;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        return true;
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

    public int compareTo(Usuario u) {
        return this.getNomeUsuario().compareTo(u.getNomeUsuario());
    }
    
    
}
