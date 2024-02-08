public class Menu {
    public void menuInicial() throws InterruptedException {
        int opcao;
        do {
            opcao = EntradaEValidacao.recebeEValidaOpcaoDoMenu();
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
                case 5:
                    System.out.println("Até mais"); //melhor frase
                    break;
                default:
                    System.out.println("Desculpe... Tente novamente. Tente digitar um numero de 1 a 6");
                    menuInicial();
            }
        } while (opcao != 6);
    }
}

