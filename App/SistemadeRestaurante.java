
import java.util.ArrayList;
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


    // INÍCIO DO SISTEMA

    public static void main(String[] args) {

        carregarCardapio();

        Scanner sc = new Scanner(System.in);

        // Mantém o sistema funcionando até escolher encerrar.
        boolean sistemaAtivo = true;

        while (sistemaAtivo) {

            String perfil = fazerLogin(sc);

            if (perfil == null) {

                System.out.println("Sistema encerrado.");
                sistemaAtivo = false;

            } else {

                if (perfil.equals("Administrador")) {

                    menuAdministrador(sc);

                } else if (perfil.equals("Funcionario")) {

                    menuFuncionario(sc);

                } else if (perfil.equals("Cliente")) {

                    menuCliente(sc);
                }

                System.out.println("\nLogout realizado com sucesso!");
                System.out.println("Voltando para a tela de login...");
            }
        }

        sc.close();
    }


    // LOGIN DO SISTEMA

    private static String fazerLogin(Scanner sc) {

        while (true) {

            System.out.println("\n=== LOGIN BYTE & BRASA ===");
            System.out.println("Digite 0 no usuário para sair.");

            System.out.print("Usuário: ");
            String usuario = sc.nextLine();

            if (usuario.equals("0")) {
                return null;
            }

            System.out.print("Senha: ");
            String senha = sc.nextLine();

            if (usuario.equals("admin") && senha.equals("123")) {

                System.out.println("Login realizado! Perfil: Administrador");
                return "Administrador";
            }

            if (usuario.equals("funcionario") && senha.equals("123")) {

                System.out.println("Login realizado! Perfil: Funcionário");
                return "Funcionario";
            }

            if (usuario.equals("cliente") && senha.equals("123")) {

                System.out.println("Login realizado! Perfil: Cliente");
                return "Cliente";
            }

            System.out.println("Usuário ou senha incorretos. Tente novamente!");
        }
    }


    // TELA DO ADMINISTRADOR

    private static void menuAdministrador(Scanner sc) {

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n================================");
            System.out.println("       MENU ADMINISTRADOR");
            System.out.println("================================");
            System.out.println("1. Ver todos os clientes");
            System.out.println("2. Cadastrar clientes");
            System.out.println("3. Ver cardápio");
            System.out.println("4. Consultar saldo");
            System.out.println("5. Adicionar saldo");
            System.out.println("6. Adicionar item ao pedido");
            System.out.println("7. Ver resumo do pedido");
            System.out.println("8. Cancelar item do pedido");
            System.out.println("0. Sair da conta");

            System.out.print("Escolha uma opção: ");

            opcao = lerOpcao(sc);

            executarOpcao("Administrador", opcao, sc);
        }
    }


    // TELA DO FUNCIONÁRIO

    private static void menuFuncionario(Scanner sc) {

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n================================");
            System.out.println("        MENU FUNCIONÁRIO");
            System.out.println("================================");
            System.out.println("1. Ver cardápio");
            System.out.println("2. Adicionar item ao pedido");
            System.out.println("3. Ver resumo do pedido");
            System.out.println("4. Cancelar item do pedido");
            System.out.println("0. Sair da conta");

            System.out.print("Escolha uma opção: ");

            opcao = lerOpcao(sc);

            executarOpcao("Funcionario", opcao, sc);
        }
    }


    // TELA DO CLIENTE

    private static void menuCliente(Scanner sc) {

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n================================");
            System.out.println("           MENU CLIENTE");
            System.out.println("================================");
            System.out.println("1. Cadastrar-se");
            System.out.println("2. Ver cardápio");
            System.out.println("3. Adicionar item ao pedido");
            System.out.println("4. Ver resumo do pedido");
            System.out.println("5. Cancelar item do pedido");
            System.out.println("6. Consultar saldo");
            System.out.println("7. Adicionar saldo");
            System.out.println("8. Pagar a conta");
            System.out.println("0. Sair da conta");

            System.out.print("Escolha uma opção: ");

            opcao = lerOpcao(sc);

            executarOpcao("Cliente", opcao, sc);
        }
    }


    // LEITURA DAS OPÇÕES

    private static int lerOpcao(Scanner sc) {

        if (sc.hasNextInt()) {

            int opcao = sc.nextInt();
            sc.nextLine();

            return opcao;

        } else {

            sc.nextLine();

            System.out.println("Digite uma opção válida.");

            return -1;
        }
    }


    // EXECUÇÃO DAS OPÇÕES DE CADA PERFIL

    private static void executarOpcao(String perfil, int opcao, Scanner sc) {

        if (perfil.equals("Administrador")) {

            switch (opcao) {

                case 1:
                    listarClientes();
                    break;

                case 2:
                    cadastrarCliente(sc);
                    break;

                case 3:
                    exibirCardapio();
                    break;

                case 4:
                    consultarSaldoAtual();
                    break;

                case 5:
                    adicionarSaldo(sc);
                    break;

                case 6:
                    adicionarItemAoPedido(sc);
                    break;

                case 7:
                    exibirResumoPedido();
                    break;

                case 8:
                    cancelarItem(sc);
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } else if (perfil.equals("Funcionario")) {

            switch (opcao) {

                case 1:
                    exibirCardapio();
                    break;

                case 2:
                    adicionarItemAoPedido(sc);
                    break;

                case 3:
                    exibirResumoPedido();
                    break;

                case 4:
                    cancelarItem(sc);
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } else if (perfil.equals("Cliente")) {

            switch (opcao) {

                case 1:
                    cadastrarCliente(sc);
                    break;

                case 2:
                    exibirCardapio();
                    break;

                case 3:
                    adicionarItemAoPedido(sc);
                    break;

                case 4:
                    exibirResumoPedido();
                    break;

                case 5:
                    cancelarItem(sc);
                    break;

                case 6:
                    consultarSaldoAtual();
                    break;

                case 7:
                    adicionarSaldo(sc);
                    break;

                case 8:
                    realizarPagamento();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }


    // CADASTRO DE CLIENTES

    private static void cadastrarCliente(Scanner sc) {

        System.out.println("\n=== CADASTRO DE CLIENTE ===");

        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();

        System.out.print("Digite seu CPF (somente números): ");
        String cpf = sc.nextLine();
        

        if (String.valueOf(cpf).length() != 11) {

            System.out.println("O CPF deve conter 11 dígitos.");
            return;
        }

        clienteAtual = new Cadastropessoa(nome, cpf);
        clientes.add(clienteAtual);

        System.out.println("Cadastro realizado com sucesso!");
    }


    // LISTAGEM DE CLIENTES

    private static void listarClientes() {

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
    }


    // CONSULTA DE SALDO

    private static void consultarSaldoAtual() {

        System.out.printf(
                "Seu saldo atual é: R$ %.2f%n",
                consultarSaldo.getSaldo()
        );
    }


    // ADICIONAR SALDO

    private static void adicionarSaldo(Scanner sc) {

        System.out.print("Digite o valor que deseja adicionar ao seu saldo: ");

        if (sc.hasNextDouble()) {

            double valor = sc.nextDouble();
            sc.nextLine();

            if (valor > 0) {

                consultarSaldo.adicionarSaldo(valor);

                System.out.printf(
                        "Saldo adicionado! Novo saldo: R$ %.2f%n",
                        consultarSaldo.getSaldo()
                );

            } else {

                System.out.println("Digite um valor positivo.");
            }

        } else {

            sc.nextLine();

            System.out.println("Digite um valor válido.");
        }
    }


    // ADICIONAR ITEM AO PEDIDO

    private static void adicionarItemAoPedido(Scanner sc) {

        System.out.print("Digite o ID do item que deseja adicionar: ");

        if (sc.hasNextInt()) {

            int idPedido = sc.nextInt();
            sc.nextLine();

            adicionarAoPedido(idPedido);

        } else {

            sc.nextLine();

            System.out.println("Digite um ID válido.");
        }
    }


    // RESUMO DO PEDIDO

    private static void exibirResumoPedido() {

        if (pedidoAtual.getItens().isEmpty()) {

            System.out.println("Você ainda não adicionou nenhum item ao pedido.");
            return;
        }

        System.out.println("\n=== SUA COMANDA DO(S) PEDIDO ===");

        pedidoAtual.exibirResumo();

        System.out.println(
                "Você adicionou " + pedidoAtual.getItens().size()
                + " itens ao pedido."
        );

        System.out.printf(
                "Total do pedido: R$ %.2f%n",
                pedidoAtual.calcularTotal()
        );

        System.out.printf(
                "Saldo restante: R$ %.2f%n",
                consultarSaldo.calcularSaldoRestante(pedidoAtual.calcularTotal())
        );
    }


    // CANCELAR ITEM

    private static void cancelarItem(Scanner sc) {

        System.out.print("Digite o ID do item que deseja cancelar: ");

        if (sc.hasNextInt()) {

            int idCancelamento = sc.nextInt();
            sc.nextLine();

            boolean cancelado = cancelarItemDoPedido(idCancelamento);

            if (cancelado) {

                System.out.println("Item cancelado com sucesso!");

            } else {

                System.out.println("Não foi possível cancelar o item.");
            }

        } else {

            sc.nextLine();

            System.out.println("Digite um ID válido.");
        }
    }


    // CARREGAR CARDÁPIO

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
        cardapio.add(new ItemMenu(20, "Coxinha de Frango", 3.50));
    }


    // EXIBIR CARDÁPIO

    private static void exibirCardapio() {

        System.out.println("\n--- CARDÁPIO ---");

        for (ItemMenu item : cardapio) {
            System.out.println(item);
        }
    }


    // CANCELAR ITEM DO PEDIDO

    private static boolean cancelarItemDoPedido(int id) {

        return pedidoAtual.getItens()
                .removeIf(item -> item.getId() == id);
    }


    // ADICIONAR ITEM AO PEDIDO

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


    // REALIZAR PAGAMENTO

    private static void realizarPagamento() {

        if (pedidoAtual.getItens().isEmpty()) {

            System.out.println("Você não tem itens no pedido para pagar.");
            return;
        }

        double totalPedido = pedidoAtual.calcularTotal();

        double saldoRestante =
                consultarSaldo.calcularSaldoRestante(totalPedido);

        if (saldoRestante >= 0) {

            System.out.printf(
                    "Pagamento realizado com sucesso! Total pago: R$ %.2f%n",
                    totalPedido
            );

            System.out.println(
                    "======= Obrigado por escolher o Restaurante Byte & Brasa! ======="
            );

            consultarSaldo.adicionarSaldo(-totalPedido);

            pedidoAtual.getItens().clear();

        } else {

            System.out.println(
                    "Saldo insuficiente para realizar o pagamento."
            );
        }
    }
}
