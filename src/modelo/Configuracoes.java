package modelo;

public class Configuracoes {
    private Usuario nome;
    private Usuario email;

    public Configuracoes(Usuario nome, Usuario email) {
        this.nome = nome;
        this.email = email;
    }

    public Usuario getNome() {
        return nome;
    }

    public void setNome(Usuario nome) {
        this.nome = nome;
    }

    public Usuario getEmail() {
        return email;
    }

    public void setEmail(Usuario email) {
        this.email = email;
    }    
    
}
