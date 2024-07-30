package br.edu.ifsuldeminas.mch.tarefas.model;

import java.io.Serializable;

public class Task implements Serializable {

    private int id;
    private String description;
    private Boolean active;

    public Task() {
        this.active = true;
    }

    public Task(int id, String desc, Boolean act) {
        this.id = id;
        this.description = desc;
        this.active = act;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
