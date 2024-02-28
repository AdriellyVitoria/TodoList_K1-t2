package utils;

import java.util.Scanner;

public class InputValidation {
    private Scanner scanner;

    public InputValidation(){
        scanner = new Scanner(System.in);
    }

    public Integer validaEntradaDeInteiro(String pergunta, Integer opcaoInicial, Integer opcaoFinal){
        while (true){
            System.out.println(pergunta);
            try {
                Integer opcao = Integer.parseInt(scanner.next());
                if (opcao >= opcaoInicial && opcao <= opcaoFinal){
                    return opcao;
                }
                throw new Exception();
            } catch (Exception e){
                System.out.println("Opcao Inválida... Tente novamente\n");
            }
        }
    }

    public Integer receberId(String pergunta){
        while (true){
            System.out.println(pergunta);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e){
                System.out.println("Por favor digite um ID válido!!\n");
            }
        }

    }
}
