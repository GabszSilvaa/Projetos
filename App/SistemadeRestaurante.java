package App;

import App.ItemMenu;
import App.pedido;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemadeRestaurante {
    private static List<ItemMenu> cardapio = new ArrayList<>();
    private static final pedido pedidoAtual = new pedido();

    public static void main(String[] args) {
        carregarCardapio();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("\n=== SISTEMA DE RESTAURANTE ===");
            System.out.println("1. Ver Cardápio");
            System.out.println("2. Adicionar Item ao Pedido");
            System.out.println("3. Ver Resumo do Pedido");
            System.out.println("4. Finalizar e Sair");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
            } else {
                scanner.next();
                System.out.println("Por favor, digite um número válido.");
                continue;
            }

            switch (opcao) {
                case 1:
                    exibirCardapio();
                    break;
                case 2:
                    exibirCardapio();
                    System.out.print("Digite o ID do item desejado: ");
                    int idItem = scanner.nextInt();
                    adicionarAoPedido(idItem);
                    break;
                case 3:
                    pedidoAtual.exibirResumo();
                    break;
                case 4:
                    pedidoAtual.exibirResumo();
                    System.out.println("Obrigado pela preferência! Volte sempre.");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);

        scanner.close();
    }

    private static void carregarCardapio() {
        cardapio.add(new ItemMenu(1, "Hambúrguer Artesanal", 28.50));
        cardapio.add(new ItemMenu(2, "Batata Frita Extra", 14.00));
        cardapio.add(new ItemMenu(3, "Refrigerante Lata", 6.00));
        cardapio.add(new ItemMenu(4, "Suco Natural 500ml", 8.50));
        cardapio.add(new ItemMenu(5, "Sobremesa da Casa", 12.00));
    }

    private static void exibirCardapio() {
        System.out.println("\n--- CARDÁPIO ---");
        for (ItemMenu item : cardapio) {
            System.out.println(item);
        }
    }

    private static void adicionarAoPedido(int id) {
        for (ItemMenu item : cardapio) {
            if (item.getId() == id) {
                pedidoAtual.adicionarItem(item);
                return;
            }
        }
        System.out.println("Item não encontrado no cardápio.");
    }
}