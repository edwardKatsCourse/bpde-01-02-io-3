package com.company.todo;

import java.util.Set;

public class TodoRepository {

    private Set<ToDo> toDos = null;

    public TodoRepository() {
        toDos = ToDoFileOperationUtils.readResource();
    }

    public void add(ToDo toDo) {
        toDo.setId(toDos.size() + 1);
        toDos.add(toDo);

        ToDoFileOperationUtils.saveResource(toDos);
    }

    public void complete(ToDo toDo) {
        ToDo fromResource = toDos.stream()
                .filter( x-> x.getId().equals(toDo.getId()))
                .findFirst()
                .orElse(null);

        if (fromResource == null) {
            throw new RuntimeException("You are trying to complete the task, that does not exist");
        }

        fromResource.setDone(true);

        toDos.add(fromResource);

        ToDoFileOperationUtils.saveResource(toDos);
    }

    public Set<ToDo> getAll() {
        toDos = ToDoFileOperationUtils.readResource();
        return toDos;
    }
}
