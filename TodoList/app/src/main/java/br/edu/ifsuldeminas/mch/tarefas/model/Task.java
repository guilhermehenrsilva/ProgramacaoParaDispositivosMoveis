package br.edu.ifsuldeminas.mch.tarefas.model;

import java.io.Serializable;

public class Task implements Serializable {

    private Integer id;
    private String description;
    private Boolean active;

    public Task() {
        this.active = true;
    }

    public Task(int id, String desc) {
        this.id = id;
        setDescription(desc);
        this.setActive(true);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return this.getDescription();
    }
}
