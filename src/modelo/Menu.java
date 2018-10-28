package modelo;

public class Menu {
    private MeuDia menuMeuDia;
    private Disciplina menuDisciplina;
    private Tarefa menuTarefa;
    private Exames menuExame;
    private Pesquisa menuPesquisa;

    public Menu(MeuDia menuMeuDia, Disciplina menuDisciplina, Tarefa menuTarefa, Exames menuExame, Pesquisa menuPesquisa) {
        this.menuMeuDia = menuMeuDia;
        this.menuDisciplina = menuDisciplina;
        this.menuTarefa = menuTarefa;
        this.menuExame = menuExame;
        this.menuPesquisa = menuPesquisa;
    }

    public MeuDia getMenuMeuDia() {
        return menuMeuDia;
    }

    public void setMenuMeuDia(MeuDia menuMeuDia) {
        this.menuMeuDia = menuMeuDia;
    }

    public Disciplina getMenuDisciplina() {
        return menuDisciplina;
    }

    public void setMenuDisciplina(Disciplina menuDisciplina) {
        this.menuDisciplina = menuDisciplina;
    }

    public Tarefa getMenuTarefa() {
        return menuTarefa;
    }

    public void setMenuTarefa(Tarefa menuTarefa) {
        this.menuTarefa = menuTarefa;
    }

    public Exames getMenuExame() {
        return menuExame;
    }

    public void setMenuExame(Exames menuExame) {
        this.menuExame = menuExame;
    }

    public Pesquisa getMenuPesquisa() {
        return menuPesquisa;
    }

    public void setMenuPesquisa(Pesquisa menuPesquisa) {
        this.menuPesquisa = menuPesquisa;
    }
    
    
}
