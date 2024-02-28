package views;

import models.Tarefa;
import services.TarefaService;
import utils.InputTransform;
import utils.Inputs;

import java.util.Scanner;

public class TarefaView {
    private TarefaService service;
    private Scanner scanner;
    private Inputs inputs;
    private InputTransform inputTransform;
    private ListagemView listagemView;

    public TarefaView(){
        service = new TarefaService();
        scanner = new Scanner(System.in);
        inputs = new Inputs();
        inputTransform = new InputTransform();
        listagemView = new ListagemView();
    }

    public void listarTarefas(){
        if (service.buscarTarefas().isEmpty()){
            System.out.println("A lista está vazia");
            return;
        }

        Integer opcao = inputs.opcoesDeListagem();
        switch (opcao) {
            case 1:
                listagemView.porCategoria();
                break;
            case 2:
            case 4:
                listagemView.emDetalhes();
                break;
            case 3:
                listagemView.porStatus();
                break;
            case 5:
                listagemView.porNumeroDeAtividade();
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    public void criarTarefa(){
        System.out.println("Nome da tarefa: ");
        String nomeTarefa = scanner.nextLine();

        System.out.println("Descrição da tarefa: ");
        String descricaoTarefa = scanner.nextLine();

        Integer prioridadeTarefa = inputs.prioridade();
        Integer categoria = inputs.categoria();
        String categoriaTarefa = inputTransform.categoriToString(categoria);


        Integer dia = inputs.dia();
        Integer mes = inputs.mes();
        String dataDeTermino = dia + "/" + mes;

        Integer status = inputs.opcoesDeStatus();
        String statusTarefa = inputTransform.statusToString(status);

        Tarefa tarefaInput = new Tarefa(nomeTarefa, descricaoTarefa, dataDeTermino,
                prioridadeTarefa, categoriaTarefa, statusTarefa);

        service.addTarefa(tarefaInput);
    }

    public void atualizarTarefa(){
        listarTarefas();

        if (service.buscarTarefas().isEmpty()){
            return;
        }

        Integer id = inputs.idParaAtualizar();
        Tarefa tarefa = service.buscarPorId(id);

        if (tarefa == null){
            System.out.println("Não existe uma tarefa com esse id");
            return;
        }

        Integer opcao = inputs.opcaoParaEditarTarefa();
        switch (opcao){
            case 1:
                System.out.println("Digite o novo nome para a tarefa: ");
                tarefa.setNome(scanner.nextLine());
                break;
            case 2:
                System.out.println("Digite uma nova descrição:");
                tarefa.setDescricao(scanner.nextLine());
                break;
            case 3:
                tarefa.setPrioridade(inputs.prioridade());
                break;
            case 4:
                Integer categoria = inputs.categoria();
                String categoriaTarefa = inputTransform.categoriToString(categoria);
                tarefa.setCategoria(categoriaTarefa);
                break;
            case 5:
                Integer dia = inputs.dia();
                Integer mes = inputs.mes();
                String dataDeTermino = dia + "/" + mes;
                tarefa.setData(dataDeTermino);
                break;
            case 6:
                Integer status = inputs.opcoesDeStatus();
                String statusTarefa = inputTransform.statusToString(status);
                tarefa.setStatus(statusTarefa);
                break;
            default:
                break;
        }
    }

    public void excluirTarefa(){
        listarTarefas();

        if (service.buscarTarefas().isEmpty()){
            return;
        }

        Integer id = inputs.idParaAtualizar();
        Tarefa tarefa = service.buscarPorId(id);

        if (tarefa == null){
            System.out.println("Não existe uma tarefa com esse id");
            return;
        }

        System.out.println(tarefa);

        Integer opcao = inputs.confirmaExcluir();
        if (opcao == 1){
            service.excluirTarefa(tarefa.getId());
            System.out.println("Tarefa excluida com sucesso");
            return;
        }
        System.out.println("A tarefa não foi apagada");
    }
}
