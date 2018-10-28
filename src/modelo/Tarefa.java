package modelo;

import java.util.Objects;
import java.util.logging.Logger;

public class Tarefa {
    private String nomeTarefa;
    private String assuntoTarefa;
    private String descricaoTarefa;
    private int dataEntregaTarefa;
    private int notaTarefa;
    private String anotacoesTarefa;
    private String tipoTarefa;
    private int idTarefa;

    public Tarefa(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(int idTarefa) {
        this.idTarefa = idTarefa;
    }
   

    public Tarefa(String nomeTarefa, String assuntoTarefa, String descricaoTarefa, int dataEntregaTarefa, int notaTarefa, String anotacoesTarefa, String tipoTarefa) {
        this.nomeTarefa = nomeTarefa;
        this.assuntoTarefa = assuntoTarefa;
        this.descricaoTarefa = descricaoTarefa;
        this.dataEntregaTarefa = dataEntregaTarefa;
        this.notaTarefa = notaTarefa;
        this.anotacoesTarefa = anotacoesTarefa;
        this.tipoTarefa = tipoTarefa;
    }

    public Tarefa(String nomeTarefa, String assuntoTarefa, String anotacoesTarefa, String tipoTarefa) {
        this.nomeTarefa = nomeTarefa;
        this.assuntoTarefa = assuntoTarefa;
        this.anotacoesTarefa = anotacoesTarefa;
        this.tipoTarefa = tipoTarefa;
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    public String getAssuntoTarefa() {
        return assuntoTarefa;
    }

    public void setAssuntoTarefa(String assuntoTarefa) {
        this.assuntoTarefa = assuntoTarefa;
    }

    public String getDescricaoTarefa() {
        return descricaoTarefa;
    }

    public void setDescricaoTarefa(String descricaoTarefa) {
        this.descricaoTarefa = descricaoTarefa;
    }

    public int getDataEntregaTarefa() {
        return dataEntregaTarefa;
    }

    public void setDataEntregaTarefa(int dataEntregaTarefa) {
        this.dataEntregaTarefa = dataEntregaTarefa;
    }

    public int getNotaTarefa() {
        return notaTarefa;
    }

    public void setNotaTarefa(int notaTarefa) {
        this.notaTarefa = notaTarefa;
    }

    public String getAnotacoesTarefa() {
        return anotacoesTarefa;
    }

    public void setAnotacoesTarefa(String anotacoesTarefa) {
        this.anotacoesTarefa = anotacoesTarefa;
    }

    public String getTipoTarefa() {
        return tipoTarefa;
    }

    public void setTipoTarefa(String tipoTarefa) {
        this.tipoTarefa = tipoTarefa;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.nomeTarefa);
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
        if (!Objects.equals(this.nomeTarefa, other.nomeTarefa)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tarefa{" + "nomeTarefa=" + nomeTarefa + '}';
    }

    public int compareTo(String anotherString) {
        return nomeTarefa.compareTo(anotherString);
    }
    
    
    
}
