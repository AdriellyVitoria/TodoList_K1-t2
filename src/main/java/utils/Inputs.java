package utils;

public class Inputs {
    private InputValidation inputValidation;

    public Inputs(){
        inputValidation = new InputValidation();
    }

    public Integer menuPrincipal()throws InterruptedException {
        Thread.sleep(1000);
        return inputValidation.validaEntradaDeInteiro(
                "**** MENU *****\n1 - Criar nova tarefa\n2 - Deletar tarefa\n3 - Atualizar tarefar\n4 - Listar Tarefas\n5 - Sair\nO que deseja escolher (1-5)?",
                1, 5
        );
    }

    public Integer prioridade(){
        return inputValidation.validaEntradaDeInteiro("Prioridade da tarefa (1-5):",1, 5);
    }

    public Integer categoria(){
        return inputValidation.validaEntradaDeInteiro("Categoria da tarefa:\n0 - Casa\n1 - Trabalho\n2 - Estudos", 0, 2);
    }

    public Integer dia(){
        return inputValidation.validaEntradaDeInteiro("Digite o dia de término (DD): ", 1, 31);
    }

    public Integer mes(){
        return inputValidation.validaEntradaDeInteiro("Digite o mês de término (MM): ", 1, 12);
    }

    public Integer opcoesDeStatus(){
        return inputValidation.validaEntradaDeInteiro("Status da tarefa:\n0 - Em andamento(ToDo)\n1 - A fazer (Doing)\n2 - Concluido (Done)",
                0, 2
        );
    }

    public Integer opcoesDeListagem(){
        return inputValidation.validaEntradaDeInteiro("----- Menu de listar tarefas -----\n1 - Por Categoria\n2 - Por Prioridade\n3 - Por Status\n4 - Todas\n5 - Consultar número de tarefas\n6 - Sair",
                1, 6
        );
    }

    public Integer opcaoParaEditarTarefa(){
        return inputValidation.validaEntradaDeInteiro("Qual item deseja atualizar:\n1 - Nome\n2 - Descrição\n3 - prioridade\n4 - Categoria\n5 - Data\n6 - Status",
                1, 6
        );
    }

    public Integer idParaAtualizar(){
        return inputValidation.receberId("Qual id da tarefa que deseja atualizar? ");
    }

    public Integer idParaExcluir(){
        return inputValidation.receberId("Qual o id da tarefa que deseja Apagar? ");
    }

    public Integer confirmaExcluir(){
        return inputValidation.validaEntradaDeInteiro("Certeza que deseja apagar a tarefa?\n1 - Sim | 2 - Não", 1,2);
    }
}
