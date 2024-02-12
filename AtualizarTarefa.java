import java.util.ArrayList;
import java.util.Scanner;

public class AtualizarTarefa {
    public static Scanner scanner = new Scanner(System.in);
    public static void buscarAtualizarTarefa(ArrayList<Tarefa> tarefas){
        Integer posicao = EntradaEValidacao.buscaPosicaoDaTarefa(tarefas);
        if (posicao == null) {
            System.out.println("Ops! a tarefa não existe, tente novamente");
        } else {
            atualizarTarefa(tarefas.get(posicao));
            System.out.println("Tarefa atualizada com sucesso");
            System.out.println(tarefas.get(posicao));
        }
    }

    public static void atualizarTarefa(Tarefa tarefa){
        int opcao = EntradaEValidacao.recebeEValidacaoEditarTarefas();
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
                tarefa.setPrioridade(EntradaEValidacao.recebeEValidacaoPrioridade());
                break;
            case 4:
                int categoria = EntradaEValidacao.recebeEvalidacaoCategoria();
                String categoriaTarefa = StatusUtilitarios.convertendoCategoriParaString(categoria);
                tarefa.setCategoria(categoriaTarefa);
                break;
            case 5:
                int dia = EntradaEValidacao.recebeEValidacaoDia();
                int mes = EntradaEValidacao.recebeEValidacaoMes();
                String dataDeTermino = dia + "/" + mes;
                tarefa.setData(dataDeTermino);
                break;
            case 6:
                int statusTarefa = EntradaEValidacao.recebeEvalidacaoStatus();
                String status = StatusUtilitarios.convertendoStatusParaString(statusTarefa);
                tarefa.setStatus(status);
            default:
                break;
        }

    }
}
