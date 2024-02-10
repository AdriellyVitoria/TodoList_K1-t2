public class Menu {
    public void menuInicial() throws InterruptedException {
        int opcao = EntradaEValidacao.recebeEValidaOpcaoDoMenu();
        switch (opcao) {
            case 1:
                InteracaoComMenu.criarTarefa();
                break;
            case 2:
                InteracaoComMenu.deletarTarefa();
                break;
            case 3:
                InteracaoComMenu.atualizarTarefa();
                break;
            case 4:
                InteracaoComMenu.menuListarTarefas();
                break;
            default:
                break;
        }
        if (opcao != 5) {
            menuInicial();
        } else {
            System.out.println("Até mais");
        }
    }
}