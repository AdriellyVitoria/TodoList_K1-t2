package services;

import data.Database;
import models.Tarefa;

import java.util.ArrayList;
import java.util.Collections;

public class TarefaService {
    private ArrayList<Tarefa> tarefas;

    public TarefaService(){
        tarefas = Database.getTarefas();
    }

    public ArrayList<Tarefa> buscarTarefas(){
        return tarefas;
    }

    public Tarefa addTarefa(Tarefa tarefa){
        tarefas.add(tarefa);
        Collections.sort(tarefas);
        return tarefa;
    }

    public Tarefa buscarPorId(Integer id){
        for(Tarefa tarefa : tarefas){
            if (tarefa.getId() == id){
                return tarefa;
            }
        }
        return null;
    }

    public void excluirTarefa(Integer id){
        Tarefa tarefa = buscarPorId(id);
        tarefas.remove(tarefa);
    }
}
