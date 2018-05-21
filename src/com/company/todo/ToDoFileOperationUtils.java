package com.company.todo;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//id^^description^^isDone\n
//id^^description^^isDone
public class ToDoFileOperationUtils {

    private static final String filename = "C:\\Users\\Edward\\Desktop\\BPDE-01-02. Writer and Reader\\todo.resource";

    public static Set<ToDo> readResource() {

        try (Reader reader = new FileReader(filename);
             BufferedReader bufferedReader = new BufferedReader(reader);) {

            Set<ToDo> toDos = new HashSet<>();
            String allLinesToString = bufferedReader
                    .lines()
                    .collect(Collectors.joining("\n"));
            List<String> objects = Arrays.asList(allLinesToString.split("\n"));
            for (String object : objects) {
                if (object.trim().length() == 0) {
                    continue;
                }
                String [] variables = object.split("\\^\\^");
                //                  12 (int) <- Integer.parseInt("12")
                Integer id = Integer.parseInt(variables[0].trim());
                String description = variables[1].trim();

                Boolean isDone = Boolean.valueOf(variables[2].trim());

                toDos.add(new ToDo(id, description, isDone));
            }

            return toDos;

        } catch (IOException e) {
            throw new RuntimeException("IOException occurred", e);
        }

    }

    public static void saveResource(Set<ToDo> toDos) {
        try (Writer writer = new FileWriter(filename);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

            for (ToDo toDo : toDos) {
                String object = String.format("%s^^%s^^%s",
                        toDo.getId(),
                        toDo.getDescription(),
                        toDo.isDone());
                bufferedWriter.write(object);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();

        } catch (IOException e) {
            throw new RuntimeException("IOException occurred", e);
        }

    }
}
