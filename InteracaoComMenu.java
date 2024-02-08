import java.util.Scanner;

public class InteracaoComMenu {
    public static void criarTarefa(){
        Scanner scanner = new Scanner(System.in);
        //Colocar um print de boas vi
        System.out.println("Nome da tarefa: ");
        String nomeTarefa = scanner.nextLine();

        System.out.println("Descrição da tarefa: ");
        String descricaoTarefa = scanner.nextLine();

        int prioridadeTarefa = EntradaEValidacao.recebeEValidacaoPrioridade();

        int categoria = EntradaEValidacao.recebeEvalidacaoCategoria();
        String categoriaTarefa = StatusUtilitarios.convertendoCategoriParaString(categoria);

        int dia = EntradaEValidacao.recebeEValidacaoDia();
        int mes = EntradaEValidacao.recebeEValidacaoMes();

        System.out.println("Digete o ano de termino (AAAA): "); //pega o ano atual ou menor
        int ano = Integer.parseInt(scanner.nextLine());
        String dataDeTermino = dia + "/" + mes + "/" + ano;

        int statusTarefa = EntradaEValidacao.recebeEvalidacaoStatus();
        String status = StatusUtilitarios.convertendoStatusParaString(statusTarefa);

        Tarefa criarTarefa = new Tarefa(nomeTarefa, descricaoTarefa, dataDeTermino,
                prioridadeTarefa, categoriaTarefa, status);
        Listas.addTarefa(criarTarefa);
    }

    public static void menuListarTarefas(){
        int opcao = EntradaEValidacao.recebeEValidacaoListarTarefas();
        switch (opcao) {
            case 1:
                Listas.listarPorCategoria();
                break;
            case 2:
                Listas.listarPorPrioridade();
                break;
            case 3:
                Listas.listarPorStatus();
                break;
            case 4:
                Listas.listarDetalherDaTarefa();
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }

    }
    public static void deletarTarefa(){
        Listas.listarTarefaPorNomeParaApagar();
    }

    public static void atualizarTarefa(){
        Listas.atualizarTarefa();

    }

}

