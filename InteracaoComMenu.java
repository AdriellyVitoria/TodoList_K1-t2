import java.util.Scanner;

public class InteracaoComMenu {
    public static void criarTarefa(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nome da tarefa: ");
        String nomeTarefa = scanner.nextLine();

        System.out.println("Descrição da tarefa: ");
        String descricaoTarefa = scanner.nextLine();

        int prioridadeTarefa = EntradaEValidacao.recebeEValidacaoPrioridade();

        int categoria = EntradaEValidacao.recebeEvalidacaoCategoria();
        String categoriaTarefa = StatusUtilitarios.convertendoCategoriParaString(categoria);

        int dia = EntradaEValidacao.recebeEValidacaoDia();
        int mes = EntradaEValidacao.recebeEValidacaoMes();
        String dataDeTermino = dia + "/" + mes;

        int statusTarefa = EntradaEValidacao.recebeEvalidacaoStatus();
        String status = StatusUtilitarios.convertendoStatusParaString(statusTarefa);

        Tarefa criarTarefa = new Tarefa(nomeTarefa, descricaoTarefa, dataDeTermino,
                prioridadeTarefa, categoriaTarefa, status);
        ListarTarefa.addTarefa(criarTarefa);
        System.out.println("Nova tarefa adicionada com sucesso");
    }

    public static void menuListarTarefas(){
        if (ListarTarefa.verificaListaVazia()) {
            int opcao = EntradaEValidacao.recebeEValidacaoListarTarefas();
            switch (opcao) {
                case 1:
                    ListarTarefa.listarPorCategoria();
                    break;
                case 2:
                    ListarTarefa.listarPorPrioridade();
                    break;
                case 3:
                    ListarTarefa.listarPorStatus();
                    break;
                case 4:
                    ListarTarefa.listarDetalherDaTarefa();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void deletarTarefa(){
        if (ListarTarefa.verificaListaVazia()){
            ExluirTarefa.listarTarefaPorNomeParaApagar(ListarTarefa.getTarefas());
        }
    }

    public static void atualizarTarefa(){
        if (ListarTarefa.verificaListaVazia()){
            AtualizarTarefa.atualizarTarefa();
        }
    }

}

