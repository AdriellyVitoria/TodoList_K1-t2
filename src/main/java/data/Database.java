package data;

import models.Tarefa;

import java.util.ArrayList;

public class Database {
    private static ArrayList<Tarefa> tarefas = new ArrayList<>();
    public static ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }
}
