package implementation;

public class SupermarketArray implements Supermarket {
    // Array para armazenar os itens do supermercado
    private final String[] items;

    // Índice do último item adicionado na lista
    private int lastIndex;


    public SupermarketArray(final int size) {
        items = new String[size]; // Cria o array com o tamanho dado
        lastIndex = -1; // Inicializa o índice como -1, indicando que a lista está vazia
    }


    // Método para adicionar um item à lista
    @Override
    public void add(String item) {
        if (lastIndex == items.length - 1) { // Verifica se a lista está cheia
            System.err.println("Lista de supermercado cheia"); // Exibe uma mensagem de erro se estiver cheia
        } else {
            lastIndex++; // Incrementa o índice
            items[lastIndex] = item; // Adiciona na frente do ultimo que foi adicionado;
        }
    }


    @Override
    public void print() {
        System.out.println("####################################");
        if (lastIndex < 0) { // Verifica se a lista está vazia
            System.out.println("Lista de supermercado vazia"); // Exibe uma mensagem se estiver vazia
        }
        for (int i = 0; i <= lastIndex; i++) { // Percorre todos os itens na lista
            System.out.println(i + " - " + items[i]); // imprime o ultimo item que foi inserido
        }

        System.out.println("####################################");
    }

    @Override
    public void delete(int index) { // ele não recebe o item, recebe o indice do vetor onde está o item.
        if (index >= 0 && index <= lastIndex) { // Verifica se o índice é válido
            shift(index); // Chama o método shift para remover o item
            lastIndex--; // Decrementa o índice
        } else {
            System.err.println("Índice inválido: " + index); // Exibe uma mensagem se o índice for inválido
        }
    }

    // Método privado para empurrar os itens à esquerda após a remoção
    private void shift(final int index) {
        for (int i = index; i < lastIndex; i++) { // Percorre a lista a partir do índice removido
            items[i] = items[i + 1]; // Move cada item uma posição para a esquerda
        }
    }
}


