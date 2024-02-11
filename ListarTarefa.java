import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ListarTarefa {
    private static ArrayList<Tarefa> tarefas = new ArrayList<>();
    public static ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }
    public static void addTarefaEOrdenacao(Tarefa tarefa) {
        tarefas.add(tarefa);
        Collections.sort(tarefas);
        System.out.println("tarefa adicionada com sucesso");
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
        imprimirFiltradoPorCategoria(opcaoEmString);
    }

    public static void listarPorStatus(){
        int opcao = EntradaEValidacao.recebeEvalidacaoStatus();
        String opcaoEmString = StatusUtilitarios.convertendoStatusParaString(opcao);
        imprimirFiltradoPorStatus(opcaoEmString, true);
    }

    public static void imprimirNumeroDeAtividades(String filtro) {
        imprimirFiltradoPorStatus(filtro, false);
    }

    public static void imprimirFiltradoPorStatus(String filtro, boolean imprimirComlista){
        int NumeroDeAtividade = 0;
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getStatus().equals(filtro)) {
                NumeroDeAtividade++;
                if(imprimirComlista){
                    System.out.println(tarefa);
                }
            }
        }
        System.out.println(filtro+ ": " + NumeroDeAtividade + " Atividade(s)");
    }

    public static void imprimirFiltradoPorCategoria(String filtro){
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getCategoria().equals(filtro)) {
                System.out.println(tarefa);
            }
        }
    }

    public static void consultaNumeroDeAtividade(){
        imprimirNumeroDeAtividades("Em andamento");
        imprimirNumeroDeAtividades("A fazer");
        imprimirNumeroDeAtividades("Concluido");
    }
}
