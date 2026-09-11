package App;
import App.pedido;
import App.ItemMenu;
import App.cancelamento;
import App.ConsultarSaldo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemadeRestaurante {
    private static ConsultarSaldo consultarSaldo = new ConsultarSaldo(0.0);
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
            System.out.println("4. Cancelar Item do Pedido");
            System.out.println("5. Consultar seu Saldo");
            System.out.println("6. Finalizar e Sair");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
            } else {
                scanner.next();
                System.out.println("Por favor, digite um número válido.");
                continue;
            }
            if (opcao == 5 && pedidoAtual.calcularTotal() == 0) {
                System.out.println("Você ainda não adicionou nenhum item ao pedido.");
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
                    cancelamento cancelamentoAtual = new cancelamento(0);
                    System.out.print("Digite o ID do item que deseja cancelar: ");
                    int idCancelamento = scanner.nextInt();
                    boolean itemEncontrado = false;
                    for (ItemMenu item : pedidoAtual.getItens()) {
                        if (item.getId() == idCancelamento) {
                            itemEncontrado = true;
                            break;
                        }
                    }
                    if (!itemEncontrado) {
                        System.out.println("Item não encontrado no pedido.");
                        break;
                    }
                    break;
                case 5:
                    if (pedidoAtual.calcularTotal() > 400.0) {
                        System.out.println("Falha no pagamento: O total dos pedidos ultrapassa R$ 400,00.");
                    } else {
                        ConsultarSaldo consultarSaldo = new ConsultarSaldo(pedidoAtual.calcularTotal());
                        System.out.println("Seu saldo atual é: R$ " + consultarSaldo.getSaldo());
                    }
                    break;
                case 6:
                    pedidoAtual.exibirResumo();
                    System.out.println("Obrigado pela preferência! Volte sempre.");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 6);

        scanner.close();
    }

    private static void carregarCardapio() {
        cardapio.add(new ItemMenu(1, "Hambúrguer Artesanal", 28.50));
        cardapio.add(new ItemMenu(2, "Batata Frita Extra", 14.00));
        cardapio.add(new ItemMenu(3, "Refrigerante Lata", 6.00));
        cardapio.add(new ItemMenu(4, "Suco Natural 500ml", 8.50));
        cardapio.add(new ItemMenu(5, "Sobremesa da Casa", 12.00));
        cardapio.add(new ItemMenu(6, "Pizza Margherita", 45.00));
        cardapio.add(new ItemMenu(7, "Crepe de nutella", 18.00));
    }

    private static void exibirCardapio() {
        System.out.println("\n--- CARDÁPIO ---");
        for (ItemMenu item : cardapio) {
            System.out.println(item);
        }
    }
    private static void cancelarItemDoPedido(int id) {
        cancelamento cancelamentoAtual = new cancelamento(0);
        for (ItemMenu item : pedidoAtual.getItens()) {
            if (item.getId() == id) {
                cancelamentoAtual.cancelarItem(item);
                return;
            }
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
