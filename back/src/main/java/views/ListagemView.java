package views;

import models.Tarefa;
import services.TarefaService;
import utils.InputTransform;
import utils.Inputs;

public class ListagemView {
    private Inputs inputs;
    private InputTransform inputTransform;
    private TarefaService service;

    public ListagemView(){
        inputs = new Inputs();
        inputTransform = new InputTransform();
        service = new TarefaService();
    }

    public void porCategoria(){
        Integer opcao = inputs.categoria();
        String filtroCategoria = inputTransform.categoriToString(opcao);
        for (Tarefa tarefa : service.buscarTarefas(null, filtroCategoria)) {
            System.out.println(tarefa);
        }
    }

    public void emDetalhes(){
        for (Tarefa tarefa : service.buscarTarefas()) {
            System.out.println(tarefa);
        }
    }

    public void porStatus(){
        Integer opcao = inputs.opcoesDeStatus();
        String filtroStatus = inputTransform.statusToString(opcao);
        for (Tarefa tarefa : service.buscarTarefas(filtroStatus, null)) {
            System.out.println(tarefa);
        }
        imprimirNumeroDeAtividades(filtroStatus);
    }

    public void porNumeroDeAtividade(){
        imprimirNumeroDeAtividades("Em andamento");
        imprimirNumeroDeAtividades("A fazer");
        imprimirNumeroDeAtividades("Concluido");
    }

    private void imprimirNumeroDeAtividades(String filtroStatus){
        int NumeroDeAtividade = service.buscarTarefas(filtroStatus, null).size();
        System.out.println(filtroStatus + ": " + NumeroDeAtividade + " Atividade(s)");
    }
}
