package services;

import data.Database;
import models.Tarefa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TarefaService {
    private ArrayList<Tarefa> tarefas;

    public TarefaService(){
        tarefas = Database.getTarefas();
    }

    public List<Tarefa> buscarTarefas() {
        return tarefas;
    }

    public List<Tarefa> buscarTarefas(String filtroStatus, String filtroCategoria){
        Stream<Tarefa> filterList = tarefas.stream();

        if (filtroStatus != null) {
            filterList = filterList.filter(tarefa -> tarefa.getStatus().equals(filtroStatus));
        }

        if (filtroCategoria != null) {
            filterList = filterList.filter(tarefa -> tarefa.getCategoria().equals(filtroCategoria));
        }

        return filterList.collect(Collectors.toList());
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
