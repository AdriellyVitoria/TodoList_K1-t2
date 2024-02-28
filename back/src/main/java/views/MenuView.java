package views;

import utils.Inputs;

public class MenuView {
    private Inputs inputs;
    private TarefaView tarefaView;

    public MenuView(){
        tarefaView = new TarefaView();
        inputs = new Inputs();
    }

    public void menuInicial() throws InterruptedException {
        Integer opcao = inputs.menuPrincipal();
        switch (opcao) {
            case 1:
                tarefaView.criarTarefa();
                break;
            case 2:
                tarefaView.excluirTarefa();
                break;
            case 3:
                tarefaView.atualizarTarefa();
                break;
            case 4:
                tarefaView.listarTarefas();
                break;
            default:
                break;
        }
        if (opcao != 5) {
            menuInicial();
        } else {
            System.out.println("Saindo do programa... Até mais");
        }
    }
}
