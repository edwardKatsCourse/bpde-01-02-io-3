package com.company.todo;

import java.util.Objects;

public class ToDo /*extends Object*/ {

    private Integer id;
    private String description;
    private boolean isDone/* = false*/;

    public ToDo(String description) {
        this.description = description;
    }

    public ToDo(Integer id, String description, boolean isDone) {
        this.id = id;
        this.description = description;
        this.isDone = isDone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDo toDo = (ToDo) o;
        return Objects.equals(id, toDo.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        String status = isDone ? "DONE" : "TO-DO";
//        String status;
//        if (isDone) {
//            status = "DONE";
//        } else {
//            status = "TO-DO";
//        }
        return String.format("Task #%s (%s): %s",
                this.id,
                status,
                this.description);
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

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
