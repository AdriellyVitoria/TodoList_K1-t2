import java.util.ArrayList;
import java.util.Scanner;

public class ExluirTarefa {
    public static void listarTarefaPorNomeParaApagar(ArrayList<Tarefa> tarefas){
        Scanner scanner = new Scanner(System.in);
        for (Tarefa tarefa : tarefas) {
            System.out.println("ID: " + tarefa.getId() + ", Nome da tarefa: " + tarefa.getNome());
        }
        System.out.println("Digite o ID da tarefa que deseja apagar: ");
        int opcao = Integer.parseInt(scanner.nextLine());

    }
}
