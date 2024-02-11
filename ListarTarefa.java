import java.util.ArrayList;
public class ListarTarefa {
    private static ArrayList<Tarefa> tarefas = new ArrayList<>();
    public static ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }
    public static void addTarefaEOrdenacao(Tarefa tarefa) {
        for(int i = 1; i <= tarefas.size(); i++){
            if (tarefas.get(i).getPrioridade() > tarefa.getPrioridade()) {
                tarefas.add(i, tarefa);
            }
        }
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
        imprimirFiltradoPorStatus(opcaoEmString);
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
