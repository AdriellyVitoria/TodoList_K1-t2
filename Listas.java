import java.util.ArrayList;
import java.util.Scanner;

public class Listas {
    private static ArrayList<Tarefa> tarefas = new ArrayList<>();
    public static ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }
    public static void addTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    public static void listarDetalherDaTarefa(){
        for (Tarefa tarefa : tarefas) {
            exibirDetalhesDaTarefa(tarefa);
        }
    }

    public static boolean verificaListaVazia(){
        if (tarefas.isEmpty()) {
            System.out.println("A lista está vazia");
            return false;
        }
        return true;
    }
    public static void exibirDetalhesDaTarefa(Tarefa tarefa){
        System.out.println("ID: " + tarefa.getId());
        System.out.println("Nome da tarefa: " + tarefa.getNome());
        System.out.println("Descrição: " + tarefa.getDescricao());
        System.out.println("Data de Término: " + tarefa.getData());
        System.out.println("Prioridade: " + tarefa.getPrioridade());
        System.out.println("Categoria: " + tarefa.getCategoria());
        System.out.println("Status: " + tarefa.getStatus());
        System.out.println("---------------");
    }

    public static void listarTarefaPorNomeParaApagar(){
        Scanner scanner = new Scanner(System.in);
        for (Tarefa tarefa : tarefas) {
            System.out.println("ID: " + tarefa.getId() + " Nome da tarefa: " + tarefa.getNome());
        }
        System.out.println("Qual tarefa deseja apagar? ");
        String nomeTarefaParaExcluir =  scanner.nextLine();
        for (int i = 0; i < tarefas.size(); i++){
            if (tarefas.get(i).equals(nomeTarefaParaExcluir)){
                tarefas.remove(i);
                System.out.println("Tarefa Apagada com sucesso");
            } else {
                System.out.println("Tarefa não encontrada... Tente novamente");
                InteracaoComMenu.deletarTarefa();
            }
        }
    }
    public static void atualizarTarefa(){

    }
    public static void listarPorCategoria(){
        int opcao = EntradaEValidacao.recebeEvalidacaoCategoria();
        StatusUtilitarios.convertendoCategoriParaString(opcao);
        if (verificaListaVazia()){
            for (Tarefa tarefa : tarefas){
                if (tarefa.getCategoria().equals("Casa")){
                    exibirDetalhesDaTarefa(tarefa);
                }
            }

            for (Tarefa tarefa : tarefas){
                if (tarefa.getCategoria().equals("Trabalho")){
                    exibirDetalhesDaTarefa(tarefa);
                }
            }

            for (Tarefa tarefa : tarefas){
                if (tarefa.getCategoria().equals("Estudos")){
                    exibirDetalhesDaTarefa(tarefa);
                }
            }
        }
    }

    public static void listarPorPrioridade(){
        if (verificaListaVazia()){
            for (int i = 1; i <= 5; i++) {
                for (Tarefa tarefa : tarefas) {
                    if (tarefa.getPrioridade() == i) {
                        exibirDetalhesDaTarefa(tarefa);
                    }
                }
            }
        }
    }

    public static void listarPorStatus(){
        int opcao = EntradaEValidacao.recebeEvalidacaoStatus();
        StatusUtilitarios.convertendoStatusParaString(opcao);

        if(verificaListaVazia()){
            for (Tarefa tarefa : tarefas) {
                if (tarefa.getStatus().equals("Em andamento")) {
                    exibirDetalhesDaTarefa(tarefa);
                }
            }

            for (Tarefa tarefa : tarefas) {
                if (tarefa.getStatus().equals("A fazer")) {
                    exibirDetalhesDaTarefa(tarefa);
                }
            }

            for (Tarefa tarefa : tarefas) {
                if (tarefa.getStatus().equals("Concluido")) {
                    exibirDetalhesDaTarefa(tarefa);
                }
            }
        }
    }

}
