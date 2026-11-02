
package App;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SistemadeRestaurante {

    private static ConsultarSaldo consultarSaldo =
            new ConsultarSaldo(0.0);

    private static List<ItemMenu> cardapio =
            new ArrayList<>();

    private static List<Cadastropessoa> clientes =
            new ArrayList<>();

    private static final Pedido pedidoAtual = new Pedido();

    private static Cancelamento cancelamentoAtual =
            new Cancelamento(0);

    private static Cadastropessoa clienteAtual =
            new Cadastropessoa("Cliente Padrão", "000.000.000-00");

    public static void main(String[] args) {

        carregarCardapio();

        Scanner sc = new Scanner(System.in);

        int opcao = 0;

        do {

            System.out.println("\n=== SEJA BEM-VINDO AO RESTAURANTE BYTE & BRASA ===");
            System.out.println("1. Cadastrar-se");
            System.out.println("2. Ver todos os clientes cadastrados");
            System.out.println("3. Ver Cardápio");
            System.out.println("4. Adicionar Item ao Pedido");
            System.out.println("5. Ver Resumo do Pedido");
            System.out.println("6. Cancelar Item do Pedido");
            System.out.println("7. Consultar seu Saldo");
            System.out.println("8. Adicionar Saldo à sua Conta");
            System.out.println("9. Finalizar e Sair");

            System.out.print("Escolha uma opção: ");

            if (sc.hasNextInt()) {
                opcao = sc.nextInt();
                sc.nextLine();
            } else {
                sc.nextLine();
                System.out.println("Digite um número válido.");
                continue;
            }

            if (opcao == 5 && pedidoAtual.calcularTotal() == 0) {
                System.out.println("Você ainda não adicionou nenhum item ao pedido.");
                continue;
            }

            switch (opcao) {

                case 1:

                    System.out.println("\n=== CADASTRO DE CLIENTE ===");

                    System.out.print("Digite seu nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Digite seu CPF: ");
                    String cpf = sc.nextLine();

                    clienteAtual = new Cadastropessoa(nome, cpf);

                    clientes.add(clienteAtual);

                    System.out.println("Cadastro realizado com sucesso!");

                    break;

                case 2:

                    System.out.println("\n=== CLIENTES CADASTRADOS ===");

                    if (clientes.isEmpty()) {

                        System.out.println("Nenhum cliente cadastrado.");

                    } else {

                        for (Cadastropessoa cliente : clientes) {

                            System.out.printf(
                                    "Nome: %s | CPF: %s%n",
                                    cliente.getNome(),
                                    cliente.getCpf()
                            );
                        }
                    }

                    break;

                case 3:

                    exibirCardapio();

                    break;

                case 4:

                    System.out.print("Digite o ID do item que deseja adicionar: ");

                    if (sc.hasNextInt()) {

                        int idPedido = sc.nextInt();
                        sc.nextLine();

                        adicionarAoPedido(idPedido);

                    } else {

                        sc.nextLine();
                        System.out.println("Digite um ID válido.");
                    }

                    break;

                case 5:

                    System.out.println("\n=== RESUMO DO PEDIDO ===");

                    pedidoAtual.exibirResumo();
                    System.out.printf("Total do pedido: R$ %.2f%n", pedidoAtual.calcularTotal());
                    System.out.printf("Saldo restante: R$ %.2f%n", consultarSaldo.calcularSaldoRestante(pedidoAtual.calcularTotal()));

                    break;

                case 6:

                    System.out.print("Digite o ID do item que deseja cancelar: ");

                    if (sc.hasNextInt()) {

                        int idCancelamento = sc.nextInt();
                        sc.nextLine();

                        boolean cancelado =
                                cancelarItemDoPedido(idCancelamento);

                        if (cancelado) {
                            System.out.println("Item cancelado com sucesso!");
                        } else {
                            System.out.println("Item não encontrado no pedido.");
                        }

                    } else {

                        sc.nextLine();
                        System.out.println("Digite um ID válido.");
                    }

                    break;

                case 7:

                    System.out.printf(
                            "Seu saldo atual é: R$ %.2f%n",
                            consultarSaldo.getSaldo()
                    );

                    break;

                case 8:

                    System.out.print("Digite o valor que deseja adicionar ao seu saldo: ");

                    if (sc.hasNextDouble()) {

                        double valor = sc.nextDouble();
                        sc.nextLine();

                        if (valor > 0) {
                            consultarSaldo.adicionarSaldo(valor);
                            System.out.printf("Saldo adicionado com sucesso! Seu novo saldo é: R$ %.2f%n", consultarSaldo.getSaldo());
                        } else {
                            System.out.println("Valor inválido. Por favor, digite um valor positivo.");
                        }

                    } else {

                        sc.nextLine();
                        System.out.println("Digite um valor válido.");
                    }

                    break;

                case 9:

                    System.out.println(
                            "Obrigado por visitar o Restaurante Byte & Brasa! Até a próxima!"
                    );

                    break;

                default:

                    System.out.println("Opção inválida. Tente novamente.");

                    break;
            }

        } while (opcao != 9);

        sc.close();
    }

    private static void carregarCardapio() {

        cardapio.add(new ItemMenu(1, "Hambúrguer Artesanal", 28.50));
        cardapio.add(new ItemMenu(2, "Batata Frita Extra", 14.00));
        cardapio.add(new ItemMenu(3, "Refrigerante Lata", 6.00));
        cardapio.add(new ItemMenu(4, "Suco Natural 500ml", 8.50));
        cardapio.add(new ItemMenu(5, "Sobremesa da Casa", 12.00));
        cardapio.add(new ItemMenu(6, "Pizza Margherita", 45.00));
        cardapio.add(new ItemMenu(7, "Crepe de Nutella", 18.00));
        cardapio.add(new ItemMenu(8, "Salada", 6.00));
        cardapio.add(new ItemMenu(9, "Cerveja Budweiser 250ml", 10.00));
        cardapio.add(new ItemMenu(10, "Água Mineral 500ml", 3.00));
        cardapio.add(new ItemMenu(11, "Café Expresso", 3.50));
        cardapio.add(new ItemMenu(12, "Chá Gelado", 5.00));
        cardapio.add(new ItemMenu(13, "Lasanha à Bolonhesa", 32.00));
        cardapio.add(new ItemMenu(14, "Espaguete ao Alho e Óleo", 25.67));
        cardapio.add(new ItemMenu(15, "Frango à Parmegiana", 43.00));
        cardapio.add(new ItemMenu(16, "Filé Mignon Grelhado", 55.00));
        cardapio.add(new ItemMenu(17, "Petit Gâteau", 60.00));
        cardapio.add(new ItemMenu(18, "Sorvete de Baunilha", 15.00));
        cardapio.add(new ItemMenu(19, "Torta de Limão", 18.00));
    }

    private static void exibirCardapio() {

        System.out.println("\n--- CARDÁPIO ---");

        for (ItemMenu item : cardapio) {
            System.out.println(item);
        }
    }

    private static boolean cancelarItemDoPedido(int id) {

        Iterator<ItemMenu> iterator = pedidoAtual.getItens().iterator();

        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {

                iterator.remove();

                return true;
            }
        }
        System.out.println("Item não encontrado no pedido.");
        return false;
    }

    private static void adicionarAoPedido(int id) {

        for (ItemMenu item : cardapio) {

            if (item.getId() == id) {

                pedidoAtual.adicionarItem(item);

                System.out.println("Item adicionado ao pedido!");

                return;
            }
        }

        System.out.println("Item não encontrado no cardápio.");
    }
}
