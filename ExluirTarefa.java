import java.util.ArrayList;
import java.util.Scanner;

public class ExluirTarefa {
    private static Scanner scanner = new Scanner(System.in);
    public static void listarTarefaPorNomeParaApagar(ArrayList<Tarefa> tarefas){
        Integer posicao = EntradaEValidacao.buscaPosicaoDaTarefa(tarefas);
        if (posicao == null) {
            System.out.println("Ops! a tarefa não existe, tente novamente");
        } else {
            System.out.println(tarefas.get(posicao));
            int opcao = EntradaEValidacao.validaEntradaDeInteiro("""
                Certeza que deseja apagar a tarefa? 
                1 - Sim | 2 - Não
                """, 1,2);
            if (opcao == 1){
                tarefas.remove(posicao);
                System.out.println("Tarefa Apagada com sucesso");
            } else {
                System.out.println("A tarefa não foi apagada");
            }
        }
    }
}
