package main;

// Importa as classes Supermarket e SupermarketArray do pacote implementation
import implementation.Supermarket;
import implementation.SupermarketArray;

import java.util.InputMismatchException;
import java.util.Scanner;

// Define a classe principal chamada Main
public class Main {

    // Declara uma constante SIZE com valor 3, que será usada para definir o tamanho do supermercado
    private final static int SIZE = 3;

    // Método principal que será executado quando o programa iniciar
    public static void main(String[] args) {

        // Cria um objeto Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Cria uma instância de SupermarketArray com o tamanho especificado por SIZE
        Supermarket supermarket = new SupermarketArray(SIZE);

        // Declara uma variável para armazenar a opção escolhida pelo usuário
        int opcao = -1;

        // Inicia um loop do-while que continuará até que a opção de sair (4) seja selecionada
        do {
            // Imprime o menu de opções
            System.out.println("\nLista de Compras");
            System.out.println("1 - Inserir");
            System.out.println("2 - Listar");
            System.out.println("3 - Remover");
            System.out.println("4 - Sair");
            System.out.println("Escolha uma opção: ");

            try {
                // Lê a opção escolhida pelo usuário
                opcao = scanner.nextInt();

                // Executa uma ação com base na opção escolhida pelo usuário
                switch (opcao) {
                    case 1:
                        // Caso a opção seja 1, solicita ao usuário que insira um item
                        System.out.println("Digite o item a ser inserido: ");
                        String item = scanner.next();
                        // Adiciona o item ao supermercado
                        supermarket.add(item);
                        break;
                    case 2:
                        // Caso a opção seja 2, lista todos os itens no supermercado
                        supermarket.print();
                        break;
                    case 3:
                        // Caso a opção seja 3, solicita ao usuário que insira a posição do item a ser removido
                        System.out.println("Digite a posição a ser removida: ");
                        int index = scanner.nextInt();
                        // Remove o item na posição especificada
                        supermarket.delete(index);
                        break;
                    case 4:
                        // Caso a opção seja 4, informa ao usuário que o programa está encerrando
                        System.out.println("Saindo do programa");
                        break;
                    default:
                        // Se a opção for inválida, exibe uma mensagem de erro
                        System.out.println("Opção inválida, tente novamente!");
                }


            } catch (InputMismatchException e) {
                // Aqui estamos usando a variável 'e' para acessar informações da exceção
                System.out.println("Entrada inválida, por favor insira um número.");
                //imprimir a mensagem da exceção (não é necessário, mas pode ser útil para depuração)
                System.out.println("Detalhes do erro: " + e.getMessage());
                // Limpar o buffer do Scanner para descartar a entrada inválida
                scanner.next();
            }
            // O loop continua até que a opção 4 seja selecionada
        } while (opcao != 4);

        // Fecha o scanner para liberar os recursos
        scanner.close();
    }
}
