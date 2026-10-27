package App;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemadeRestaurante {
    private static ConsultarSaldo consultarSaldo = new ConsultarSaldo(0.0);
    private static List<ItemMenu> cardapio = new ArrayList<>();
    private static List<Cadastropessoa> clientes = new ArrayList<>();
    private static final pedido pedidoAtual = new pedido();

    private static cancelamento cancelamentoAtual = new cancelamento(0);

    private static Cadastropessoa clienteAtual = new Cadastropessoa("Cliente Padrão", "000.000.000-00");

    public static void main(String[] args) {
        carregarCardapio();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("\n=== SEJA BEM VINDO AO RESTAURANTE Byte & Brasa ===");
            System.out.println("1. Cadastrar-se");
            System.out.println("2. Ver todos os clientes cadastrados");
            System.out.println("3. Ver Cardápio");
            System.out.println("4. Adicionar Item ao Pedido");
            System.out.println("5. Ver Resumo do Pedido");
            System.out.println("6. Cancelar Item do Pedido");
            System.out.println("7. Consultar seu Saldo");
            System.out.println("8. Finalizar e Sair");
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
                    System.out.println("=== CADASTRO DE CLIENTE ===");
                    System.out.print("Digite seu nome: ");
                    scanner.nextLine(); // Limpar o buffer
                    String nome = scanner.nextLine();

                    System.out.print("Digite seu CPF: ");
                    String cpf = scanner.nextLine();

                    clienteAtual = new Cadastropessoa(nome, cpf);
                    clientes.add(clienteAtual); 

                    System.out.println("Cadastro realizado com sucesso!");
                    break;
                case 2:
                    System.out.println("=== CLIENTES CADASTRADOS ===");
                    if (clientes.isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado.");
                    } else {
                        for (Cadastropessoa cliente : clientes) {
                            System.out.printf("Nome: %s, CPF: %s\n", cliente.getNome(), cliente.getCpf());
                        }
                    }
                    break;
                case 3:
                    exibirCardapio();
                    break;
                case 4:
                    System.out.print("Digite o ID do item que deseja adicionar ao pedido: ");
                    int idPedido = scanner.nextInt();
                    adicionarAoPedido(idPedido);
                    break;
                case 5:
                    pedidoAtual.exibirResumo();
                    break;
                case 6:
                    System.out.print("Digite o ID do item que deseja cancelar do pedido: ");
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
                    cancelarItemDoPedido(idCancelamento);
                    System.out.println("Item cancelado com sucesso.");
                    break;
                case 7:
                    System.out.printf("Seu saldo atual é: R$ %.2f\n", consultarSaldo.getSaldo());
                    break;
                case 8:
                    System.out.println("Obrigado por visitar o Restaurante Byte & Brasa! Até a próxima!");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        } while (opcao != 12);

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
        cardapio.add(new ItemMenu(8, "Salada", 6.00));
        cardapio.add(new ItemMenu(9, "Cerveja Budweiser 250Ml", 10.00));
        cardapio.add(new ItemMenu(10, "Água Mineral 500ml", 3.00));
        cardapio.add(new ItemMenu(11, "Café Expresso", 3.50));
        cardapio.add(new ItemMenu(12, "Chá Gelado", 5.00));
        cardapio.add(new ItemMenu(13, "Lasanha à Bolonhesa", 32.00));
        cardapio.add(new ItemMenu(14, "Espaguete ao Alho e Óleo", 25.67));
        cardapio.add(new ItemMenu(15, "Frango à Parmegiana", 43.00));
        cardapio.add(new ItemMenu(16, "Filé Mignon Grelhado", 55.00));
        cardapio.add(new ItemMenu(17, "petit gâteau", 60.00));
        cardapio.add(new ItemMenu(18, "Sorvete de Baunilha", 15.00));
        cardapio.add(new ItemMenu(19, "Torta de Limão", 18.00));
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
