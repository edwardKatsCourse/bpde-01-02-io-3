package com.company.todo;

public class Main {

    public static void main(String[] args) {
        ToDo toDo_1 = new ToDo("Task 7");
        ToDo toDo_2 = new ToDo("Task 8");
        ToDo toDo_3 = new ToDo("Task 9");

        TodoRepository repository = new TodoRepository();
        repository.add(toDo_1);
        repository.add(toDo_2);
        repository.add(toDo_3);

        repository.complete(toDo_1);
        repository.complete(toDo_3);

//        System.out.println(repository.getAll());

        repository.getAll().forEach(System.out::println);
    }
}
