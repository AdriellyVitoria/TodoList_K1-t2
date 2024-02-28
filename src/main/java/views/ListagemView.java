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
        String opcaoEmString = inputTransform.categoriToString(opcao);
        for (Tarefa tarefa : service.buscarTarefas()) {
            if (tarefa.getCategoria().equals(opcaoEmString)) {
                System.out.println(tarefa);
            }
        }
    }

    public void emDetalhes(){
        for (Tarefa tarefa : service.buscarTarefas()) {
            System.out.println(tarefa);
        }
    }

    public void porStatus(){
        Integer opcao = inputs.opcoesDeStatus();
        String opcaoEmString = inputTransform.statusToString(opcao);
        Integer NumeroDeAtividade = 0;
        for (Tarefa tarefa : service.buscarTarefas()) {
            if (tarefa.getStatus().equals(opcaoEmString)) {
                NumeroDeAtividade++;
                System.out.println(tarefa);
            }
        }
        System.out.println(opcaoEmString + ": " + NumeroDeAtividade + " Atividade(s)");
    }

    public void porNumeroDeAtividade(){
        imprimirNumeroDeAtividades("Em andamento");
        imprimirNumeroDeAtividades("A fazer");
        imprimirNumeroDeAtividades("Concluido");
    }

    private void imprimirNumeroDeAtividades(String filtro){
        int NumeroDeAtividade = 0;
        for (Tarefa tarefa : service.buscarTarefas()) {
            if (tarefa.getStatus().equals(filtro)) {
                NumeroDeAtividade++;
            }
        }
        System.out.println(filtro+ ": " + NumeroDeAtividade + " Atividade(s)");
    }
}
