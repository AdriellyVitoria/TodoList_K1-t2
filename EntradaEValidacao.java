import java.util.Scanner;

public class EntradaEValidacao {
    private static Scanner scanner = new Scanner(System.in);
    public static int recebeEValidaOpcaoDoMenu() throws InterruptedException {
        Thread.sleep(1000);
        return validaEntradaDeInteiro("""
            **** MENU *****
            1 - Criar nova tarefa
            2 - Deletar tarefa
            3 - Atualizar tarefar
            4 - Listar Tarefas
            5 - Sair
            O que deseja escolher (1-5)?""", 1, 5);
    }
    public static int recebeEValidacaoPrioridade(){
        return validaEntradaDeInteiro("Prioridade da tarefa (1-5):",1, 5);
    }
    public static int recebeEvalidacaoCategoria(){
        return validaEntradaDeInteiro("""
            Categoria da tarefa: 
            0 - Casa
            1 - Trabalho
            2 - Estudos""", 0, 2);

    }
    public static int recebeEValidacaoDia() {
        return validaEntradaDeInteiro("Digite o dia de término (DD): ", 1, 31);
    }

    public static int recebeEValidacaoMes() {
        return validaEntradaDeInteiro("Digite o mês de término (MM): ", 1, 12);
    }

    public static int recebeEvalidacaoStatus(){
        return validaEntradaDeInteiro("""
                Status da tarefa:
                0 - Em andamento(ToDo)
                1 - A fazer (Doing)
                2 - Concluido (Done)""", 0, 2);
    }

    public static int recebeEValidacaoListarTarefas(){
        return validaEntradaDeInteiro("""
                ----- Menu de listar tarefas -----
                1 - Por Categoria
                2 - Por Prioridade
                3 - Por Status
                4 - Todas
                5 - Consultar número de tarefas
                6 - Sair""", 1, 6);
    }

    public static int validaEntradaDeInteiro(String pergunta, int opcaoInicial, int opcaoFinal){
        try {
            System.out.println(pergunta);
            int opcao = Integer.parseInt(scanner.next());
            if (opcao >= opcaoInicial && opcao <= opcaoFinal){
                return opcao;
            }
            throw new Exception();
        } catch (Exception e) {
            System.out.println("Opção inválida... Tente Novamente\n");
            return validaEntradaDeInteiro(pergunta, opcaoInicial, opcaoFinal);
        }
    }

    public static int recebeId(String pergunta){
        try {
            System.out.println(pergunta);
            return Integer.parseInt(scanner.next());
        } catch (Exception e){
            System.out.println("Por favor digite um ID válido!!\n");
            return recebeId(pergunta);
        }
    }
}