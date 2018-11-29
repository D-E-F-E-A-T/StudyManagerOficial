package modelo;

public class Menu {
    private Disciplina menuDisciplina;
    private Tarefa menuTarefa;
    private Exames menuExame;

    public Menu(Disciplina menuDisciplina, Tarefa menuTarefa, Exames menuExame) {
        this.menuDisciplina = menuDisciplina;
        this.menuTarefa = menuTarefa;
        this.menuExame = menuExame;
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
}