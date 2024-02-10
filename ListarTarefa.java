import java.util.ArrayList;
import java.util.Scanner;

public class ListarTarefa {
    private static ArrayList<Tarefa> tarefas = new ArrayList<>();
    public static void addTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    public static void listarDetalherDaTarefa(){
        for (Tarefa tarefa : tarefas) {
            System.out.println(tarefa);
        }
    }

    public static boolean verificaListaVazia(){
        if (tarefas.isEmpty()) {
            System.out.println("A lista está vazia");
            return false;
        }
        return true;
    }

    public static void listarPorCategoria(){
        int opcao = EntradaEValidacao.recebeEvalidacaoCategoria();
        String opcaoEmString = StatusUtilitarios.convertendoCategoriParaString(opcao);
        if (verificaListaVazia()){
            imprimirFiltradoPorCategoria(opcaoEmString);
        }
    }

    public static void listarPorPrioridade(){
        if (verificaListaVazia()){
            for (int i = 1; i <= 5; i++) {
                for (Tarefa tarefa : tarefas) {
                    if (tarefa.getPrioridade() == i) {
                        System.out.println(tarefa);
                    }
                }
            }
        }
    }

    public static void listarPorStatus(){
        int opcao = EntradaEValidacao.recebeEvalidacaoStatus();
        String opcaoEmString = StatusUtilitarios.convertendoStatusParaString(opcao);

        if(verificaListaVazia()){
            imprimirFiltradoPorStatus(opcaoEmString);
        }
    }

    public static void imprimirFiltradoPorStatus(String filtro){
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getStatus().equals(filtro)) {
                System.out.println(tarefa);
            }
        }
    }

    public static void imprimirFiltradoPorCategoria(String filtro){
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getCategoria().equals(filtro)) {
                System.out.println(tarefa);
            }
        }
    }
}
