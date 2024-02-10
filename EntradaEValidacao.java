import java.util.Scanner;

public class EntradaEValidacao {
    private static Scanner scanner = new Scanner(System.in);
    // valida ano
    public static int recebeEValidaOpcaoDoMenu() throws InterruptedException {
        Thread.sleep(1000);
        return validaEntradaDeInteiro("""
            **** MENU *****
            1 - Criar nova tarefa
            2 - Deletar tarefa
            3 - Atualizar tarefar
            4 - Listar Tarefas
            5 - Sair
            O que deseja escolher (1-6)?
            """, 1, 5);
    }
    public static int recebeEValidacaoPrioridade(){
        return validaEntradaDeInteiro("Prioridade da tarefa (1-5):",1, 5);
    }
    public static int recebeEvalidacaoCategoria(){
        return validaEntradaDeInteiro("""
            Categoria da tarefa: 
            0 - Casa
            1 - Trabalho
            2 - Estudos               
            """, 2, 0);

    }
    public static int recebeEValidacaoDia() {
        return validaEntradaDeInteiro("Digite o dia de termino (DD): ", 1, 31);
    }

    public static int recebeEValidacaoMes() {
        return validaEntradaDeInteiro("Digite o mês de termino (MM): ", 1, 12);
    }

    public static int recebeEvalidacaoStatus(){
        return validaEntradaDeInteiro("""
                Status da tarefa:
                0 - Em andamento(ToDo)
                1 - A fazer (Doing)
                2 - Concluido (Done)
                """, 0, 2);
    }

    public static int recebeEValidacaoListarTarefas(){
        return validaEntradaDeInteiro("""
                ----- Menu de listar tarefas -----
                1 - Por Categoria
                2 - Por Prioridade
                3 - Por Status
                4 - Todas
                5 - Sair
                """, 1, 5);
    }

    public static int validaEntradaDeInteiro(String pergunta, int opcaoInicial, int opcaoFinal){
        try {
            System.out.println(pergunta);
            int opcao = Integer.parseInt(scanner.nextLine());
            if (opcao >= opcaoInicial && opcao <= opcaoFinal){
                return opcao;
            }
            throw new Exception();
        } catch (Exception e) {
            System.out.println("Opção inválida... Tente Novamente\n");
            return validaEntradaDeInteiro(pergunta, opcaoInicial, opcaoFinal);
        }
    }
}